package com.gooagoo.view.gus.web.calendar;

import java.io.Serializable;

public class UBill implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopName;//账单里面的商家名称

    private String payPrice;//价格

    private String billId;//账单的id

    private String requestTime;//消费时间

    public String getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(String payPrice)
    {
        this.payPrice = payPrice;
    }

    public String getRequestTime()
    {
        return this.requestTime;
    }

    public void setRequestTime(String requestTime)
    {
        this.requestTime = requestTime;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

}
