package com.gooagoo.mobile.common.entity;

import java.io.Serializable;

/**
 * 拍了付接口入参
 */
public class PlfPayEntity implements Serializable
{

    /**
     *  拍了付接口入参
     */
    private static final long serialVersionUID = 1L;

    /**
     * 合作ID，拍乐付为合作伙伴分配的唯一标识
     */
    private String PartnerId;

    /**
     * 商户号，拍乐付分配
     */
    private String MerId;

    /**
     * 订单号，合作方生成订单唯一标识
     */
    private String OrderId;

    /**
     * 订单总金额，单位为分
     */
    private Integer Amount;

    /**
     * 交易成功后，异步通知合作方后台的URL
     */
    private String BackEndUrl;

    /**
     * 订单描述信息
     */
    private String OrderDescription;

    /**
     * 交易发生时的时间日期，yyyyMMddHHmmss
     */
    private String OrderTime;

    public String getPartnerId()
    {
        return this.PartnerId;
    }

    public void setPartnerId(String partnerId)
    {
        this.PartnerId = partnerId;
    }

    public String getMerId()
    {
        return this.MerId;
    }

    public void setMerId(String merId)
    {
        this.MerId = merId;
    }

    public String getOrderId()
    {
        return this.OrderId;
    }

    public void setOrderId(String orderId)
    {
        this.OrderId = orderId;
    }

    public Integer getAmount()
    {
        return this.Amount;
    }

    public void setAmount(Integer amount)
    {
        this.Amount = amount;
    }

    public String getBackEndUrl()
    {
        return this.BackEndUrl;
    }

    public void setBackEndUrl(String backEndUrl)
    {
        this.BackEndUrl = backEndUrl;
    }

    public String getOrderDescription()
    {
        return this.OrderDescription;
    }

    public void setOrderDescription(String orderDescription)
    {
        this.OrderDescription = orderDescription;
    }

    public String getOrderTime()
    {
        return this.OrderTime;
    }

    public void setOrderTime(String orderTime)
    {
        this.OrderTime = orderTime;
    }

    @Override
    public String toString()
    {
        return "PlfPayEntity [PartnerId=" + this.PartnerId + ", MerId=" + this.MerId + ", OrderId=" + this.OrderId + ", Amount=" + this.Amount + ", BackEndUrl=" + this.BackEndUrl + ", OrderDescription=" + this.OrderDescription + ", OrderTime=" + this.OrderTime + "]";
    }

}
