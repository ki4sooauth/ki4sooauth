package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 通过网站手工添加的账单
 */

public class BillManualKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billId;//账单编号

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
