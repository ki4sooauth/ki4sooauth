package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsc09.transform.GetAllDeskStatusRoot;
import com.gooagoo.trans.entity.gtsc11.transform.SwipeCardRoot;
import com.gooagoo.trans.entity.gtsc13.transform.QueryGoodsInfoRoot;

/**
 * 订单关联接口
 */
public interface OrderLinkTransService
{
    /**
     * 接口gtsc08:商家确认优惠凭证是否可用需求变接口
     * @param orderId 订单编号
     * @param agreeyInfo 是否同意 [{"favoriteid":"","agreetype":""}]agreetype取值范围：Y-同意，N-不同意
     * @return
     * @throws Exception
     */
    public boolean couponCheck(String orderId, String agreeyInfo) throws Exception;

    /**
     * gtsc09:实体店所有餐桌状态查询（针对到餐桌号，不涉及餐桌类型）
     * @param shopEntityId 实体店编号
     * @param pageIndex 页码
     * @param pageSize  每页信息显示条数
     * @return
     * @throws Exception
     */
    public GetAllDeskStatusRoot getAllDeskStatus(String shopEntityId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gtsc11:验证用户刷卡信息
     * @param scardno 会员卡号
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public SwipeCardRoot swipeCard(String scardno, String shopId) throws Exception;

    /**
     * 接口gtsc13:商家根据自定义序列号查询商品信息
     * @param shopentityid 实体店编号
     * @param itemserial 商品自定义序列号
     * @return
     * @throws Exception
     */
    public QueryGoodsInfoRoot getGoodsInfo(String shopentityid, String itemserial) throws Exception;

}
