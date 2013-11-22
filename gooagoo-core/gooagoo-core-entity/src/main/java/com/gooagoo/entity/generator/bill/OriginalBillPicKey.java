package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 原始账单信息图片详情
 */

public class OriginalBillPicKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String billDetailId;//账单明细编号，UUID

    public String getBillDetailId()
    {
        return billDetailId;
    }

    public void setBillDetailId(String billDetailId)
    {
        this.billDetailId = billDetailId;
    }

}
