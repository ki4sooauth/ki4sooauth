package com.gooagoo.view.gus.web.bill;

import java.io.Serializable;

public class UBillManualDetails implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String billId;//账单编号

    private String userId;//用户编号

    private String billNo;//单号，填写订单或账单的编号

    private String billType;//类别

    private String fee;//消费金额

    private String requestTime;//消费时间

    private String shopName;//所属商家

    private String note;//备注

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getBillNo()
    {
        return this.billNo;
    }

    public void setBillNo(String billNo)
    {
        this.billNo = billNo;
    }

    public String getBillType()
    {
        return this.billType;
    }

    public void setBillType(String billType)
    {
        this.billType = billType;
    }

    public String getFee()
    {
        return this.fee;
    }

    public void setFee(String fee)
    {
        this.fee = fee;
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

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

}
