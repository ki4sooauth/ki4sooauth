package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 实体店基本信息
 */

public class ShopEntityInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
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
