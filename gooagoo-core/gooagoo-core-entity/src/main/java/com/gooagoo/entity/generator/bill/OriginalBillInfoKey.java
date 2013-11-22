package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 原始账单信息
 */

public class OriginalBillInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billId;//账单编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getBillId()
    {
        return billId;
    }

    public void setBillId(String billId)
    {
        this.billId = billId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
