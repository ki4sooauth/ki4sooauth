package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 用户订单原始信息
 */

public class UserOrderInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userOrderId;//用户订单编号，UUID

    public String getUserOrderId()
    {
        return userOrderId;
    }

    public void setUserOrderId(String userOrderId)
    {
        this.userOrderId = userOrderId;
    }

}
