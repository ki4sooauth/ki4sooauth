package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 原始账单信息
 */

public class OriginalBillInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billId;//账单编号，UUID

    private String orderId;//统一订单编号，关联订单管理主表

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String userId;//用户编号

    private String mac;//商家硬件设备MAC地址

    private Date requestTime;//消费时间

    private String thirdOrderId;//第三方订单编号

    private String scardNo;//会员卡号，16位音频卡号

    private Integer goodsTotalNum;//账单商品总数

    private Double originalPrice;//原价格

    private Double discountRate;//折扣

    private Double payPrice;//实际支付价格

    private String roomName;//房间名称（仅针对餐饮）

    private String deskName;//桌子名称（仅针对餐饮）

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
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

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public Date getRequestTime()
    {
        return this.requestTime;
    }

    public void setRequestTime(Date requestTime)
    {
        this.requestTime = requestTime;
    }

    public String getThirdOrderId()
    {
        return this.thirdOrderId;
    }

    public void setThirdOrderId(String thirdOrderId)
    {
        this.thirdOrderId = thirdOrderId;
    }

    public String getScardNo()
    {
        return this.scardNo;
    }

    public void setScardNo(String scardNo)
    {
        this.scardNo = scardNo;
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
        return this.billId + "^" + this.orderId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.userId + "^" + this.mac + "^" + this.requestTime + "^" + this.thirdOrderId + "^" + this.scardNo + "^" + this.goodsTotalNum + "^" + this.originalPrice + "^" + this.discountRate + "^" + this.payPrice + "^" + this.roomName + "^" + this.deskName + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
