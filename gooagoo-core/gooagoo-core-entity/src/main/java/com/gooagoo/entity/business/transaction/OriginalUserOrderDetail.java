package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;

/**
 * 用户订单原始信息
 */
public class OriginalUserOrderDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private UserOrderInfo userOrderInfo;//商家订单原始信息

    private List<UserOrderDetail> userOrderDetailList;//商家订单原始信息商品详情

    private List<UserOrderCoupon> userOrderCouponList;//商家订单原始信息图片详情

    public UserOrderInfo getUserOrderInfo()
    {
        return this.userOrderInfo;
    }

    public void setUserOrderInfo(UserOrderInfo userOrderInfo)
    {
        this.userOrderInfo = userOrderInfo;
    }

    public List<UserOrderDetail> getUserOrderDetailList()
    {
        return this.userOrderDetailList;
    }

    public void setUserOrderDetailList(List<UserOrderDetail> userOrderDetailList)
    {
        this.userOrderDetailList = userOrderDetailList;
    }

    public List<UserOrderCoupon> getUserOrderCouponList()
    {
        return this.userOrderCouponList;
    }

    public void setUserOrderCouponList(List<UserOrderCoupon> userOrderCouponList)
    {
        this.userOrderCouponList = userOrderCouponList;
    }

}
