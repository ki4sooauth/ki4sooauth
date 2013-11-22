package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 手机端发起---后台---转发器---第三方系统
 */

public class BillPayApplicationKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderId;//订单编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
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
