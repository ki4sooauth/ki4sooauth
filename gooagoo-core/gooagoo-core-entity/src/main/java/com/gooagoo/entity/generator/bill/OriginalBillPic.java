package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 原始账单信息图片详情
 */

public class OriginalBillPic implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billDetailId;//账单明细编号，UUID

    private String billId;//账单编号

    private String picUrl;//账单图片地址

    public String getBillDetailId()
    {
        return this.billDetailId;
    }

    public void setBillDetailId(String billDetailId)
    {
        this.billDetailId = billDetailId;
    }

    public String getBillId()
    {
        return this.billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    @Override
    public String toString()
    {
        return this.billDetailId + "^" + this.billId + "^" + this.picUrl;
    }
}
