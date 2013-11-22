package com.gooagoo.trans.api;

import com.gooagoo.trans.entity.gtsd01.transform.FindCouponInfoByCouponidRoot;
import com.gooagoo.trans.entity.gtsd02.transform.FindOrderInfoByOrderidRoot;
import com.gooagoo.trans.entity.gtsd03.transform.FindOrderInfoByVoucherinfoidRoot;
import com.gooagoo.trans.entity.gtsd04.transform.OpenInvoiceRoot;

/**
 * 转发器音频服务相关接口
 */
public interface AudioTransService
{
    /**
     * 接口GTSD01:根据优惠劵编号查询商家优惠劵信息
     * @param shopEntityId 实体店编号
     * @param couponId 优惠券编号
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public FindCouponInfoByCouponidRoot findCouponInfoByCouponid(String shopEntityId, String couponId, String shopId) throws Exception;

    /**
     * 接口GTSD02:根据订单编号查询商家的订单/账单信息
     * @param favoriteId 优惠凭证编号
     * @param shopentityid 实体店编号
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public FindOrderInfoByOrderidRoot findOrderInfoByOrderid(String orderId, String shopId) throws Exception;

    /**
     * 接口GTSD03:根据提货凭证编号查询商家订单/账单信息
     * @param favoriteId 优惠凭证编号
     * @param shopentityid 实体店编号
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public FindOrderInfoByVoucherinfoidRoot findOrderInfoByVoucherinfoid(String orderId, String shopId) throws Exception;

    /**
     * 接口GTSD04:根据发票凭证查询发票申请信息
     * @param favoriteId 优惠凭证编号
     * @param shopentityid 实体店编号
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public OpenInvoiceRoot findInvoiceInfo(String orderId, String shopId) throws Exception;

}
