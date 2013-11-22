package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.bill.OrderCouponInfo;

/**
 * 订单优惠券信息
 * @author YL
 *
 */
public class OrderCouponBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<OrderCouponInfo> orderCouponInfoList;//订单优惠凭证详情
    private List<CanNotUseCoupon> canNotUseCouponList;//用户订单原始信息优惠凭证详情

    public List<OrderCouponInfo> getOrderCouponInfoList()
    {
        return this.orderCouponInfoList;
    }

    public void setOrderCouponInfoList(List<OrderCouponInfo> orderCouponInfoList)
    {
        this.orderCouponInfoList = orderCouponInfoList;
    }

    public List<CanNotUseCoupon> getCanNotUseCouponList()
    {
        return this.canNotUseCouponList;
    }

    public void setCanNotUseCouponList(List<CanNotUseCoupon> canNotUseCouponList)
    {
        this.canNotUseCouponList = canNotUseCouponList;
    }

}
