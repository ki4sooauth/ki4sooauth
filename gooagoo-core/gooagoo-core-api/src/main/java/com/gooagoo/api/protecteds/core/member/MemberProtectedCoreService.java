package com.gooagoo.api.protecteds.core.member;

import com.gooagoo.entity.generator.member.ConvertApply;
import com.gooagoo.exception.business.card.CardAlreadyConvertedException;
import com.gooagoo.exception.business.shop.ShopCardStatusException;

public interface MemberProtectedCoreService
{

    /**
     * 获取电子卡号(暂取商家总店)
     * @param shopId
     * @param userId
     * @param cardType
     * @return scardNo
     * @throws Exception 
     */
    public String getScardNo(String shopId, String userId, String cardType) throws Exception;

    /**
     * 验证物理卡转换
     * @param convertApply 物理卡转换申请
     * @return
     * @throws CardAlreadyConvertedException 物理卡已转换异常
     * @throws Exception
     */
    public void checkConvertCard(ConvertApply convertApply) throws Exception;

    /**
     * 发放会员卡（包括关注卡、基础卡、高级卡、审核）
     * @param userId
     * @param cardId 会员卡号
     * @return
     * @throws ShopCardStatusException 商家卡的发布状态不是已发布异常
     */
    public boolean sendCard(String userId, String cardId) throws Exception;

    /**
     * 会员卡升级（自动），积分达到卡升级积分要求时自动升级（用户历史总积分增加时触发此操作）
     * @param userId
     * @param shopId
     * @param historyTotalIntegral
     * @return
     * @throws Exception
     */
    public boolean autoUpgradeCardByIntegral(String userId, String shopId, Integer historyTotalIntegral) throws Exception;
}
