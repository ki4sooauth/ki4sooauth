package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsb02.transform.ShopMemberCardsRoot;
import com.gooagoo.trans.entity.gtsb03.transform.GetUserIntegralRoot;

/**
 * 会员管理 相关接口
 */
public interface MemberManageTransService
{
    /**
     * 接口gtsb02:商家查询会员卡基本表
     * @param shopId 商家编号
     * @param ctimestamp 最大时间戳
     * @return
     * @throws Exception
     */
    public ShopMemberCardsRoot getShopMemberCards(String shopId, String ctimestamp) throws Exception;

    /**
     * 接口gtsb03:商家查询会员积分
     * @param shopId 商家编号
     * @param userId 用户编号
     * @return
     * @throws Exception
     */
    public GetUserIntegralRoot getUserIntegral(String shopId, String userId) throws Exception;
}
