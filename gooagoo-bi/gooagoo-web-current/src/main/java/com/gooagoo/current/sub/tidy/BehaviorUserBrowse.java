package com.gooagoo.current.sub.tidy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.entity.cache.GoodsCache;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;

@Message(DispatcherConstants.browse)
public class BehaviorUserBrowse implements Customer
{

    @Override
    public void message(Object message)
    {
        BehaveLog behaveLog = (BehaveLog) message;

        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);

        ActionRecord actionRecord = new ActionRecord();
        actionRecord.set_id(UUID.getUUID());
        actionRecord.setShopId(behaveLog.getShopId()); //商家id
        actionRecord.setUserId(behaveLog.getUserId()); //用户id
        actionRecord.setIp(behaveLog.getIpAddress()); //ip
        actionRecord.setMac(behaveLog.getMacAddress()); //mac
        actionRecord.setBehaveType("9"); //行为类型 9浏览
        actionRecord.setSource(behaveLog.getSource());
        actionRecord.setTimestamp(new Date()); //时间戳
        actionRecord.setObjectType(behaveLog.getObjectType());
        //A-活动，G-商品，C-优惠凭证，Y-吆喝，N-通知，Q-购好奇，M-邮件，S-手机服务，0-cms栏目，1-cms文章，2-广告
        if ("A".equals(behaveLog.getObjectType()))
        {
            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }
        if ("G".equals(behaveLog.getObjectType()))
        {
            String id = behaveLog.getObjectValue();
            GoodsCache goodsCache = this.getGoodsCache(id);
            if (goodsCache.getGoodsCategory() == null)
            {
                GooagooLog.debug("商品缓存不正确，没有品类信息 商品序列号:" + goodsCache.getItemSerial());
                return;
            }
            String shopId = goodsCache.getShopId();
            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }

        if ("C".equals(behaveLog.getObjectType()))
        {
            String id = behaveLog.getObjectValue();
            GoodsCache goodsCache = this.getGoodsCache(id);
            if (goodsCache.getGoodsCategory() == null)
            {
                GooagooLog.debug("商品缓存不正确，没有品类信息 商品序列号:" + goodsCache.getItemSerial());
                return;
            }
            String shopId = goodsCache.getShopId();
            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }
        if ("Y".equals(behaveLog.getObjectType()))
        {

            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }
        if ("N".equals(behaveLog.getObjectType()))
        {

            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }
        if ("S".equals(behaveLog.getObjectType()))
        {

            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }
        if ("Q".equals(behaveLog.getObjectType()))
        {
            actionRecord.setObjectValue(behaveLog.getObjectValue());
        }
        mongoDao.saveEntity(actionRecord);

    }

    private GoodsCache getGoodsCache(String id)
    {
        GoodsCacheQueryService goodsCacheQueryService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);
        GoodsCache target = new GoodsCache();
        try
        {
            Map<String, String> findGoodsInfo = goodsCacheQueryService.findGoodsInfo(id);
            BeanUtils.populate(target, findGoodsInfo);
            String categoryCache = findGoodsInfo.get("category");
            if (StringUtils.hasText(categoryCache))
            {
                String[] categories = categoryCache.split(",");
                target.setGoodsCategory(new ArrayList<String>(Arrays.asList(categories)));
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("查询商品缓存出错（goodsCacheQueryService.findGoodsInfo）", e);
        }
        return target;
    }

}
