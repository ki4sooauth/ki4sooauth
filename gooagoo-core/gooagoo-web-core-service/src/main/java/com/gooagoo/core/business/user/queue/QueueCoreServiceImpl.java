package com.gooagoo.core.business.user.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.cache.TableCacheCoreService;
import com.gooagoo.api.business.core.user.queue.QueueCoreService;
import com.gooagoo.api.generator.core.behave.UserStoreQueueGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableTypeManageGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.user.QueueBusiness;
import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample.Criteria;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.exception.business.behave.AlreadyArrangedException;
import com.gooagoo.exception.business.behave.NotNeedArrangeException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.redis.data.RedisStringDao;

@Service
public class QueueCoreServiceImpl implements QueueCoreService
{

    @Autowired
    private ShopTableTypeManageGeneratorCoreService shopTableTypeManageGeneratorCoreService;
    @Autowired
    private UserStoreQueueGeneratorCoreService userStoreQueueGeneratorCoreService;
    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;
    @Autowired
    private TableCacheCoreService tableCacheCoreService;
    @Autowired
    private ShopTableInfoGeneratorCoreService shopTableInfoGeneratorCoreService;

    private final static Object synObject = new Object();//用户排号同步锁

    @Override
    public QueueBusiness arranging(String shopId, String shopEntityId, String scardno, String userId, String tableTypeCode, String persianNums) throws Exception
    {
        synchronized (synObject)
        {
            QueueBusiness queueBusiness = null;
            if (!StringUtils.hasText(tableTypeCode))
            {
                tableTypeCode = this.getTableTypeCodeByPersianNums(persianNums);
            }
            if (!StringUtils.hasText(shopId))
            {
                return queueBusiness;
            }
            if (StringUtils.hasText(tableTypeCode))
            {
                if (!StringUtils.hasText(userId) && StringUtils.hasText(scardno))
                {
                    MemberOfCard memberOfCard = this.memberOfCardGeneratorCoreService.selectUnDelByPrimaryKey(scardno);
                    if (memberOfCard == null || !StringUtils.hasText(memberOfCard.getUserId()))
                    {
                        GooagooLog.warn("通过会员卡音频编号获取用户编号为空[scardno=" + scardno + "]");
                        throw new NullException("通过会员卡音频编号获取用户编号为空[scardno=" + scardno + "]");
                    }
                    userId = memberOfCard.getUserId();
                }
                //redis获取某实体店指定餐桌类型如果有空闲则无需排号
                ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
                com.gooagoo.entity.generator.shop.ShopTableInfoExample.Criteria shopTableInfoCriteria = shopTableInfoExample.createCriteria();
                shopTableInfoCriteria.andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
                if (StringUtils.hasText(tableTypeCode))
                {
                    shopTableInfoCriteria.andTableTypeCodeEqualTo(tableTypeCode);
                }
                List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorCoreService.selectByExample(shopTableInfoExample);
                if (CollectionUtils.isNotEmpty(shopTableInfoList))
                {
                    for (ShopTableInfo shopTableInfo : shopTableInfoList)
                    {
                        Map<String, String> tableCache = this.tableCacheCoreService.findTableInfoByTableName(shopEntityId, shopTableInfo.getTableName());
                        if (tableCache != null && tableCache.size() > 0 && "空闲".equals(tableCache.get("tablestate")))
                        {
                            GooagooLog.info("无需排号(已有空闲餐桌无需排号)[空闲餐桌桌号=" + tableCache.get("tablestate") + "]");
                            throw new NotNeedArrangeException("无需排号(已有空闲餐桌无需排号)[空闲餐桌桌号=" + tableCache.get("tablestate") + "]");
                        }
                    }
                }
                //判断当前用户是否排号了
                UserStoreQueueExample userStoreQueueExample = new UserStoreQueueExample();
                UserStoreQueue userStoreQueue = new UserStoreQueue();
                if (StringUtils.hasText(userId))
                {
                    userStoreQueueExample.createCriteria().andUserIdEqualTo(userId).andShopEntityIdEqualTo(shopEntityId).andIsEliminationEqualTo("N").andIsDelEqualTo("N");
                    boolean isArranged = CollectionUtils.isNotEmpty(this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample));
                    if (isArranged)
                    {
                        GooagooLog.info("不能重复排号[userId=" + userId + "、shopEntityId=" + shopEntityId + "]");
                        throw new AlreadyArrangedException("用户在该商家已排号、不能重复排号[userId=" + userId + "、shopEntityId=" + shopEntityId + "]");
                    }
                    userStoreQueue.setUserId(userId);
                }
                userStoreQueue.setId(UUID.getUUID());
                userStoreQueue.setShopId(shopId);
                userStoreQueue.setShopEntityId(shopEntityId);
                //获取排号
                userStoreQueueExample = new UserStoreQueueExample();
                userStoreQueueExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsEliminationEqualTo("N").andIsDelEqualTo("N");
                userStoreQueueExample.setOrderByClause("queue_no DESC");
                List<UserStoreQueue> userStoreQueueList = this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample);
                Integer queueNo = 1;
                if (CollectionUtils.isNotEmpty(userStoreQueueList))
                {
                    queueNo = userStoreQueueList.get(0).getQueueNo() + 1;
                }
                userStoreQueue.setQueueNo(queueNo);
                userStoreQueue.setNums(StringUtils.hasText(persianNums) ? Integer.parseInt(persianNums) : null);
                userStoreQueue.setQueueType(tableTypeCode);
                userStoreQueue.setIsElimination("N");
                userStoreQueue.setIsDel("N");
                if (!this.userStoreQueueGeneratorCoreService.insertSelective(userStoreQueue))
                {
                    GooagooLog.error("排号失败[userStoreQueue = " + userStoreQueue.toString() + "]", null);
                    return null;
                }
                //排号信息
                queueBusiness = this.returnArrangingInfo(shopEntityId, queueNo.toString());
            }
            return queueBusiness;
        }
    }

    private QueueBusiness returnArrangingInfo(String shopEntityId, String queueno)
    {
        QueueBusiness queueBusiness = null;
        UserStoreQueueExample userStoreQueueExample = new UserStoreQueueExample();
        userStoreQueueExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andQueueNoEqualTo(queueno).andIsEliminationEqualTo("N").andIsDelEqualTo("N");
        List<UserStoreQueue> currentUserStoreQueueList = this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample);
        queueBusiness = new QueueBusiness();
        UserStoreQueue currentUserStoreQueue = currentUserStoreQueueList.get(0);
        String tableType = currentUserStoreQueue.getQueueType();//餐桌类型
        queueBusiness.setQueueNo(currentUserStoreQueue.getQueueNo().toString());//封装排队号码
        queueBusiness.setCreatetime(TimeUtils.convertDateToString(currentUserStoreQueue.getCreateTime(), TimeUtils.FORMAT1));//封装排号时间
        //redis获取正在结帐数量
        String key = currentUserStoreQueue.getShopEntityId() + "_" + tableType;
        RedisStringDao redisStringDao = new RedisStringDao(RedisServerConstants.catering_checkout);
        String checkout = redisStringDao.get(key);
        String checkoutnum = StringUtils.hasText(checkout) ? checkout : "0";
        queueBusiness.setCheckoutnum(checkoutnum);//封装正在结帐数
        userStoreQueueExample = new UserStoreQueueExample();
        userStoreQueueExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andIsEliminationGreaterThan("N").andIsDelEqualTo("N");
        userStoreQueueExample.setOrderByClause("c_time_stamp ASC");
        List<UserStoreQueue> userStoreQueueList = this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample);
        Integer currentqueueno = 0;//即将叫到的号码
        if (CollectionUtils.isNotEmpty(userStoreQueueList))
        {
            currentqueueno = userStoreQueueList.get(0).getQueueNo();
        }
        queueBusiness.setCurrentqueueno(currentqueueno.toString());//封装即将叫到的号码
        //排队等候数
        Integer waitnum = 0;
        for (UserStoreQueue userStoreQueue : userStoreQueueList)
        {
            //过滤餐桌类型和比自己小的排号
            if (tableType.equals(userStoreQueue.getQueueType()) && Integer.parseInt(queueno) > userStoreQueue.getQueueNo())
            {
                waitnum += 1;
            }
        }
        queueBusiness.setWaitnum(waitnum.toString());//封装排队等候数
        return queueBusiness;
    }

    @Override
    public List<QueueBusiness> refreshArranging(String userId, String shopEntityId)
    {
        List<QueueBusiness> queueBusinessList = null;
        UserStoreQueueExample userStoreQueueExample = new UserStoreQueueExample();
        Criteria criteria = userStoreQueueExample.createCriteria();
        if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        criteria.andUserIdEqualTo(userId).andIsEliminationEqualTo("N").andIsDelEqualTo("N");
        List<UserStoreQueue> currentUserStoreQueueList = this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample);
        if (CollectionUtils.isNotEmpty(currentUserStoreQueueList))
        {
            queueBusinessList = new ArrayList<QueueBusiness>();
            for (UserStoreQueue currentUserStoreQueue : currentUserStoreQueueList)
            {
                QueueBusiness queueBusiness = new QueueBusiness();
                String tableType = currentUserStoreQueue.getQueueType();//餐桌类型
                queueBusiness.setShopId(currentUserStoreQueue.getShopId());
                queueBusiness.setShopEntityId(currentUserStoreQueue.getShopEntityId());
                queueBusiness.setQueueNo(currentUserStoreQueue.getQueueNo().toString());//封装排队号码
                queueBusiness.setCreatetime(TimeUtils.convertDateToString(currentUserStoreQueue.getCreateTime(), TimeUtils.FORMAT1));//封装排号时间
                //redis获取正在结帐数量
                String key = currentUserStoreQueue.getShopEntityId() + "_" + tableType;
                RedisStringDao redisStringDao = new RedisStringDao(RedisServerConstants.catering_checkout);
                String checkout = redisStringDao.get(key);
                String checkoutnum = StringUtils.hasText(checkout) ? checkout : "0";
                queueBusiness.setCheckoutnum(checkoutnum);//封装正在结帐数
                userStoreQueueExample = new UserStoreQueueExample();
                userStoreQueueExample.createCriteria().andShopEntityIdEqualTo(currentUserStoreQueue.getShopEntityId()).andIsEliminationEqualTo("N").andIsDelEqualTo("N");
                userStoreQueueExample.setOrderByClause("c_time_stamp ASC");
                List<UserStoreQueue> userStoreQueueList = this.userStoreQueueGeneratorCoreService.selectByExample(userStoreQueueExample);
                Integer currentqueueno = 0;
                Integer waitnum = 0;
                if (CollectionUtils.isNotEmpty(userStoreQueueList))
                {
                    //即将叫到的号码
                    currentqueueno = userStoreQueueList.get(0).getQueueNo();
                    //排队等候数
                    for (UserStoreQueue userStoreQueue : userStoreQueueList)
                    {
                        //过滤餐桌类型和比自己大的排号
                        if (tableType.equals(userStoreQueue.getQueueType()) && currentUserStoreQueue.getQueueNo() > userStoreQueue.getQueueNo())
                        {
                            waitnum += 1;
                        }
                    }
                }
                queueBusiness.setCurrentqueueno(currentqueueno.toString());//封装即将叫到的号码
                queueBusiness.setWaitnum(waitnum.toString());//封装排队等候数
                queueBusinessList.add(queueBusiness);
            }
        }
        return queueBusinessList;
    }

    private String getTableTypeCodeByPersianNums(String persianNums)
    {
        ShopTableTypeManageExample shopTableTypeManageExample = new ShopTableTypeManageExample();
        shopTableTypeManageExample.createCriteria().andMinNumsLessThanOrEqualTo(persianNums).andMaxNumsGreaterThanOrEqualTo(persianNums).andIsDelEqualTo("N");
        List<ShopTableTypeManage> shopTableTypeManageList = this.shopTableTypeManageGeneratorCoreService.selectByExample(shopTableTypeManageExample);
        if (CollectionUtils.isNotEmpty(shopTableTypeManageList))
        {
            return shopTableTypeManageList.get(0).getTableTypeCode();
        }
        return null;
    }

}
