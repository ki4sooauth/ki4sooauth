package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 发票信息管理
 */

public class ReceiptInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String receiptId;//自动编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getReceiptId()
    {
        return receiptId;
    }

    public void setReceiptId(String receiptId)
    {
        this.receiptId = receiptId;
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
