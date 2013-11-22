package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户订单原始信息
 */

public class UserOrderInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userOrderId;//用户订单编号，UUID

    private String orderId;//统一订单编号，关联订单管理主表

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String userId;//用户编号

    private Integer goodsTotalNum;//订单商品总数

    private Double originalPrice;//原价格

    private Double discountRate;//折扣

    private Double payPrice;//实际支付价格

    private String takeMethod;//提货方式，0-直接拿走、1-前台提货、2-送货上门

    private String consigneeId;//收货人信息编号，关联收货人信息的主键

    private String roomName;//房间名称（仅针对餐饮）

    private String deskName;//桌子名称（仅针对餐饮）

    private String isSaCommit;//是否店员助理提交，Y-是，N-否

    private String account;//店员助理登录帐号

    private Date createTime;//创建时间

    public String getUserOrderId()
    {
        return this.userOrderId;
    }

    public void setUserOrderId(String userOrderId)
    {
        this.userOrderId = userOrderId;
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

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Integer getGoodsTotalNum()
    {
        return this.goodsTotalNum;
    }

    public void setGoodsTotalNum(Integer goodsTotalNum)
    {
        this.goodsTotalNum = goodsTotalNum;
    }

    public Double getOriginalPrice()
    {
        return this.originalPrice;
    }

    public void setOriginalPrice(Double originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public Double getDiscountRate()
    {
        return this.discountRate;
    }

    public void setDiscountRate(Double discountRate)
    {
        this.discountRate = discountRate;
    }

    public Double getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(Double payPrice)
    {
        this.payPrice = payPrice;
    }

    public String getTakeMethod()
    {
        return this.takeMethod;
    }

    public void setTakeMethod(String takeMethod)
    {
        this.takeMethod = takeMethod;
    }

    public String getConsigneeId()
    {
        return this.consigneeId;
    }

    public void setConsigneeId(String consigneeId)
    {
        this.consigneeId = consigneeId;
    }

    public String getRoomName()
    {
        return this.roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getDeskName()
    {
        return this.deskName;
    }

    public void setDeskName(String deskName)
    {
        this.deskName = deskName;
    }

    public String getIsSaCommit()
    {
        return this.isSaCommit;
    }

    public void setIsSaCommit(String isSaCommit)
    {
        this.isSaCommit = isSaCommit;
    }

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return this.userOrderId + "^" + this.orderId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.userId + "^" + this.goodsTotalNum + "^" + this.originalPrice + "^" + this.discountRate + "^" + this.payPrice + "^" + this.takeMethod + "^" + this.consigneeId + "^" + this.roomName + "^" + this.deskName + "^" + this.isSaCommit + "^" + this.account + "^" + this.createTime;
    }
}
