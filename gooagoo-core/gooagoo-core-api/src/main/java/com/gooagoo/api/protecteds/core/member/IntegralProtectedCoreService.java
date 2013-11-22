package com.gooagoo.api.protecteds.core.member;

import com.gooagoo.entity.generator.member.IntegralDetailInfo;

/**
 * 会员卡管理
 */
public interface IntegralProtectedCoreService
{
    /**
     * 累加用户积分，并升级会员卡
     * @param integralDetailInfo
     * @return
     */
    public boolean increaseIntegralAndUpgradeCard(IntegralDetailInfo integralDetailInfo) throws Exception;

    /**
     * 处理用户积分信息：包括存储积分明细信息、存储/更新积分汇总信息
     * @param integralDetailInfo
     * @param isSynHistory 是否同步历史总积分
     * @return
     */
    public boolean dealUserIntegralInfo(IntegralDetailInfo integralDetailInfo, boolean isSynHistory);

    /**
     * 存储/更新用户积分汇总信息
     * @param userId
     * @param shopId
     * @param integralNumber
     * @param isSynHistory 是否同步历史总积分
     * @return
     */
    public boolean saveOrUpdateUserIntegralInfo(String userId, String shopId, Integer integralNumber, boolean isSynHistory);

}
