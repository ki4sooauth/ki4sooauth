package com.gooagoo.core.protecteds.member;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.generator.core.member.IntegralDetailInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.IntegralInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.member.IntegralProtectedCoreService;
import com.gooagoo.api.protecteds.core.member.MemberProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;

/**
 * 积分管理
 */
@Service
public class IntegralProtectedCoreServiceImpl implements IntegralProtectedCoreService
{

    @Autowired
    private IntegralInfoGeneratorCoreService integralInfoGeneratorCoreService;

    @Autowired
    private IntegralDetailInfoGeneratorCoreService integralDetailInfoGeneratorCoreService;

    @Autowired
    private MemberProtectedCoreService memberProtectedCoreService;

    private final static Object synObject = new Object();//存储/更新积分汇总信息同步锁

    @Override
    public boolean increaseIntegralAndUpgradeCard(IntegralDetailInfo integralDetailInfo) throws Exception
    {
        if (StringUtils.isBlank(integralDetailInfo.getShopId()))
        {
            GooagooLog.info("累加用户积分，并升级会员卡：商家ID（" + integralDetailInfo.getShopId() + "）为空");
            return false;
        }
        if (StringUtils.isBlank(integralDetailInfo.getUserId()))
        {
            GooagooLog.info("累加用户积分，并升级会员卡：用户ID（" + integralDetailInfo.getUserId() + "）为空");
            return false;
        }
        //1、处理用户积分信息
        IntegralInfo integralInfo = this.dealIntegralInfo(integralDetailInfo, true);
        if (integralInfo == null)
        {
            GooagooLog.info("累加用户积分，并升级会员卡：处理用户积分信息异常[integralDetailInfo=" + integralDetailInfo.toString() + "]");
            return false;
        }
        //2、自动升级会员卡
        if (!this.memberProtectedCoreService.autoUpgradeCardByIntegral(integralInfo.getUserId(), integralInfo.getShopId(), integralInfo.getHistoryTotalIntegral()))
        {
            GooagooLog.info("累加用户积分，并升级会员卡：处理用户积分信息异常[integralDetailInfo=" + integralDetailInfo.toString() + "]");
            return false;
        }
        return true;
    }

    @Override
    public boolean dealUserIntegralInfo(IntegralDetailInfo integralDetailInfo, boolean isSynHistory)
    {
        if (StringUtils.isBlank(integralDetailInfo.getShopId()))
        {
            GooagooLog.info("累加用户积分，并升级会员卡：商家ID（" + integralDetailInfo.getShopId() + "）为空");
            return false;
        }
        if (StringUtils.isBlank(integralDetailInfo.getUserId()))
        {
            GooagooLog.info("累加用户积分，并升级会员卡：用户ID（" + integralDetailInfo.getUserId() + "）为空");
            return false;
        }
        if (this.dealIntegralInfo(integralDetailInfo, isSynHistory) == null)
        {
            GooagooLog.info("处理用户积分信息：处理用户积分信息异常");
            return false;
        }
        return true;
    }

    @Override
    public boolean saveOrUpdateUserIntegralInfo(String userId, String shopId, Integer integralNumber, boolean isSynHistory)
    {
        if (this.saveOrUpdateIntegralInfo(userId, shopId, integralNumber, isSynHistory) == null)
        {
            GooagooLog.info("存储/更新用户积分汇总信息：存储/更新用户积分汇总信息异常");
            return false;
        }
        return true;
    }

    /**
     * 处理积分信息：包括积分明细、积分汇总
     * @param integralDetailInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private IntegralInfo dealIntegralInfo(IntegralDetailInfo integralDetailInfo, boolean isSynHistory)
    {
        //1、填补积分明细表默认信息
        integralDetailInfo.setIntegralId(UUID.getUUID());
        integralDetailInfo.setIntegralCreateTime(new Date());
        integralDetailInfo.setIsFreez("N");
        integralDetailInfo.setIsDel("N");
        //2、存储积分明细信息
        if (!this.integralDetailInfoGeneratorCoreService.insertSelective(integralDetailInfo))
        {
            GooagooLog.error("处理积分信息：存储积分明细信息（" + integralDetailInfo.toString() + "）异常", null);
            return null;
        }
        //3、存储/更新积分汇总信息
        IntegralInfo integralInfo = this.saveOrUpdateIntegralInfo(integralDetailInfo.getUserId(), integralDetailInfo.getShopId(), integralDetailInfo.getIntegralNumber(), isSynHistory);
        if (integralInfo == null)
        {
            GooagooLog.error("处理积分信息：存储/更新积分汇总信息异常", null);
            return null;
        }
        return integralInfo;
    }

    /**
     * 存储/更新积分汇总信息
     * @param userId
     * @param shopId
     * @param integralNumber
     * @param isSynHistory 是否更新历史总积分
     * @return
     */
    private IntegralInfo saveOrUpdateIntegralInfo(String userId, String shopId, Integer integralNumber, boolean isSynHistory)
    {
        IntegralInfoExample queryCondition = new IntegralInfoExample();
        queryCondition.createCriteria().andShopIdEqualTo(shopId).andUserIdEqualTo(userId).andIsDelEqualTo("N");
        synchronized (synObject)
        {
            List<IntegralInfo> integralInfoList = this.integralInfoGeneratorCoreService.selectByExample(queryCondition);
            IntegralInfo integralInfo = new IntegralInfo();
            integralInfo.setShopId(shopId);
            integralInfo.setUserId(userId);
            if (CollectionUtils.isEmpty(integralInfoList))
            {
                if (integralNumber < 0)
                {
                    GooagooLog.info("存储/更新积分汇总信息：用户（" + userId + "）未持有商家（" + shopId + "）积分，无法扣除积分（" + integralNumber + "）");
                    return null;
                }
                integralInfo.setIntegralId(UUID.getUUID());
                integralInfo.setHistoryTotalIntegral(integralNumber);
                integralInfo.setUseableIntegralNumber(integralNumber);
                integralInfo.setIsDel("N");
                if (!this.integralInfoGeneratorCoreService.insertSelective(integralInfo))
                {
                    GooagooLog.error("存储/更新积分汇总信息：存储积分汇总信息（" + integralInfo.toString() + "）异常", null);
                    return null;
                }
            }
            else if (integralInfoList.size() == 1)
            {
                integralInfo.setIntegralId(integralInfoList.get(0).getIntegralId());
                if (isSynHistory)
                {
                    integralInfo.setHistoryTotalIntegral(integralInfoList.get(0).getHistoryTotalIntegral() + integralNumber);
                }
                integralInfo.setUseableIntegralNumber(integralInfoList.get(0).getUseableIntegralNumber() + integralNumber);
                if (integralInfo.getUseableIntegralNumber() < 0)
                {
                    GooagooLog.info("存储/更新积分汇总信息：用户（" + userId + "）持有的商家（" + shopId + "）积分（" + integralInfo.getUseableIntegralNumber() + "）不足，无法扣除积分（" + integralNumber + "）");
                    return null;
                }
                if (!this.integralInfoGeneratorCoreService.updateByPrimaryKeySelective(integralInfo))
                {
                    GooagooLog.error("存储/更新积分汇总信息：更新用积分汇总信息（" + integralInfo.toString() + "）异常", null);
                    return null;
                }
            }
            else
            {
                GooagooLog.info("存储/更新积分汇总信息：用户（" + userId + "）在商家（" + shopId + "）中的总积分异常");
                return null;
            }
            return integralInfo;
        }
    }

}
