package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 用户订单原始信息优惠凭证详情
 */

public class UserOrderCouponKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userOrderDetailId;//订单明细编号，UUID

    public String getUserOrderDetailId()
    {
        return userOrderDetailId;
    }

    public void setUserOrderDetailId(String userOrderDetailId)
    {
        this.userOrderDetailId = userOrderDetailId;
    }

}
