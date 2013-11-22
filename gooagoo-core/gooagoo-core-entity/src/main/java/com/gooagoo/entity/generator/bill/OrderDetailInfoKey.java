package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 订单商品详细信息
 */

public class OrderDetailInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号，UUID

    public String getOrderDetailId()
    {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
    }

}
