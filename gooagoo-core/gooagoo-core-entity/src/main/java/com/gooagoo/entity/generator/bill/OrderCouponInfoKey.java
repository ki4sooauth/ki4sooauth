package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 订单优惠凭证详情，包括三种途径提交的优惠凭证：提交用户订单时、提交结账申请时、单独提出优惠凭证申请
 */

public class OrderCouponInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderDetailId;//订单明细编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getOrderDetailId()
    {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId)
    {
        this.orderDetailId = orderDetailId;
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
