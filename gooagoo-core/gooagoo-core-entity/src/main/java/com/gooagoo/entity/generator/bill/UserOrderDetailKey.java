package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 用户订单原始信息商品详情
 */

public class UserOrderDetailKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userOrderDetailId;//订单明细编号

    public String getUserOrderDetailId()
    {
        return userOrderDetailId;
    }

    public void setUserOrderDetailId(String userOrderDetailId)
    {
        this.userOrderDetailId = userOrderDetailId;
    }

}
