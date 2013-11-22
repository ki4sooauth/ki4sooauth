package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 用户订单原始信息优惠凭证详情
 */

public class UserOrderCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userOrderDetailId;//订单明细编号，UUID

    private String userOrderId;//用户订单编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String couponUserId;//优惠凭证收藏编号

    private String userId;//提交者

    private String couponSource;//优惠凭证来源，0-购阿购

    public String getUserOrderDetailId()
    {
        return this.userOrderDetailId;
    }

    public void setUserOrderDetailId(String userOrderDetailId)
    {
        this.userOrderDetailId = userOrderDetailId;
    }

    public String getUserOrderId()
    {
        return this.userOrderId;
    }

    public void setUserOrderId(String userOrderId)
    {
        this.userOrderId = userOrderId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getCouponUserId()
    {
        return this.couponUserId;
    }

    public void setCouponUserId(String couponUserId)
    {
        this.couponUserId = couponUserId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getCouponSource()
    {
        return this.couponSource;
    }

    public void setCouponSource(String couponSource)
    {
        this.couponSource = couponSource;
    }

    @Override
    public String toString()
    {
        return this.userOrderDetailId + "^" + this.userOrderId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.couponUserId + "^" + this.userId + "^" + this.couponSource;
    }
}
