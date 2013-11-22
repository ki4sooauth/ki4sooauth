package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单优惠凭证详情，包括三种途径提交的优惠凭证：提交用户订单时、提交结账申请时、单独提出优惠凭证申请
 */

public class OrderCouponInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号，UUID

    private String orderId;//订单编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String couponUserId;//优惠凭证收藏编号

    private String userId;//提交者

    private String couponSource;//优惠凭证来源，0-购阿购

    private String status;//优惠凭证状态，0-不可用，1-等待商家处理，2-商家确认可使用，3-商家确认不可使用

    private String isDeal;//商家是否处理，Y-已处理，N未处理

    private Date dealTime;//商家处理时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getOrderDetailId()
    {
        return this.orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIsDeal()
    {
        return this.isDeal;
    }

    public void setIsDeal(String isDeal)
    {
        this.isDeal = isDeal;
    }

    public Date getDealTime()
    {
        return this.dealTime;
    }

    public void setDealTime(Date dealTime)
    {
        this.dealTime = dealTime;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.orderDetailId + "^" + this.orderId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.couponUserId + "^" + this.userId + "^" + this.couponSource + "^" + this.status + "^" + this.isDeal + "^" + this.dealTime + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
