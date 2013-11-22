package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.List;

/**
 * 原始账单信息
 * @author YL
 *
 */
public class OrderResult implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String orderId;//订单号
    private List<CanNotUseCoupon> canNotUseCouponList;//用户订单原始信息优惠凭证详情

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public List<CanNotUseCoupon> getCanNotUseCouponList()
    {
        return this.canNotUseCouponList;
    }

    public void setCanNotUseCouponList(List<CanNotUseCoupon> canNotUseCouponList)
    {
        this.canNotUseCouponList = canNotUseCouponList;
    }

    @Override
    public String toString()
    {
        return "OrderResult [orderId=" + this.orderId + ", canNotUseCouponList=" + this.canNotUseCouponList + "]";
    }

}
