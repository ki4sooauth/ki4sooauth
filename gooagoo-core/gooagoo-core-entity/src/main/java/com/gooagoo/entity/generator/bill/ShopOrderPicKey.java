package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 商家订单原始信息图片详情
 */

public class ShopOrderPicKey implements Serializable
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
