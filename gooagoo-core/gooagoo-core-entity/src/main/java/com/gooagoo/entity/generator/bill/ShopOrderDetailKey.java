package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 商家订单原始信息商品详情
 */

public class ShopOrderDetailKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopOrderDetailId;//订单明细编号，UUID

    public String getShopOrderDetailId()
    {
        return shopOrderDetailId;
    }

    public void setShopOrderDetailId(String shopOrderDetailId)
    {
        this.shopOrderDetailId = shopOrderDetailId;
    }

}
