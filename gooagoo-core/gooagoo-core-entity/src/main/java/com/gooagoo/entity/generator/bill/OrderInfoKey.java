package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 订单信息，记录用户订单、商家订单、账单、开发票的全程变化，对外服务的数据全都从这个表中获取。
 */

public class OrderInfoKey implements Serializable
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
