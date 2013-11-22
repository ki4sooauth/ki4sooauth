package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 通过网站手工添加的账单
 */

public class BillManual implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billId;//账单编号

    private String userId;//用户编号

    private String billNo;//单号，填写订单或账单的编号

    private String billType;//类别

    private Double fee;//消费金额

    private Date requestTime;//消费时间

    private String shopName;//所属商家

    private String note;//备注

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

    public Double getFee()
    {
        return this.fee;
    }

    public void setFee(Double fee)
    {
        this.fee = fee;
    }

    public Date getRequestTime()
    {
        return this.requestTime;
    }

    public void setRequestTime(Date requestTime)
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
        return this.billId + "^" + this.userId + "^" + this.billNo + "^" + this.billType + "^" + this.fee + "^" + this.requestTime + "^" + this.shopName + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
