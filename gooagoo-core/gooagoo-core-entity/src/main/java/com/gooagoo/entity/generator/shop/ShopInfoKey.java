package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 商家信息
 */

public class ShopInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
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
