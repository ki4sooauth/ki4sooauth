package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 用户-角色关联
 */

public class ShopUserRole2Key implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

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
