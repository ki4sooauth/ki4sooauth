package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 商家类型字典表
 */

public class ShopTypeKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer shopTypeId;//商家类型编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public Integer getShopTypeId()
    {
        return shopTypeId;
    }

    public void setShopTypeId(Integer shopTypeId)
    {
        this.shopTypeId = shopTypeId;
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
