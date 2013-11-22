package com.gooagoo.entity.generator.bill;

import java.io.Serializable;

/**
 * 商家订单原始信息图片详情
 */

public class ShopOrderPic implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopOrderDetailId;//订单明细编号，UUID

    private String shopOrderId;//商家订单编号

    private String picUrl;//订单图片地址

    public String getShopOrderDetailId()
    {
        return this.shopOrderDetailId;
    }

    public void setShopOrderDetailId(String shopOrderDetailId)
    {
        this.shopOrderDetailId = shopOrderDetailId;
    }

    public String getShopOrderId()
    {
        return this.shopOrderId;
    }

    public void setShopOrderId(String shopOrderId)
    {
        this.shopOrderId = shopOrderId;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    @Override
    public String toString()
    {
        return this.shopOrderDetailId + "^" + this.shopOrderId + "^" + this.picUrl;
    }
}
