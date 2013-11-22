package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 商家订单原始信息。商家订单来源：转发器产生的订单文件。只有餐饮业才有商家订单。
 */

public class ShopOrderInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopOrderId;//商家订单编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShopOrderId()
    {
        return shopOrderId;
    }

    public void setShopOrderId(String shopOrderId)
    {
        this.shopOrderId = shopOrderId;
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
