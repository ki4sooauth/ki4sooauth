package com.gooagoo.view.gus.web.common;

import java.io.Serializable;
import java.util.List;

public class UShopType implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer shopTypeId;//商家类型ID

    private String shopTypeName;//商家类型名称

    private List<UShopType> children;//子商家类型

    public Integer getShopTypeId()
    {
        return shopTypeId;
    }

    public void setShopTypeId(Integer shopTypeId)
    {
        this.shopTypeId = shopTypeId;
    }

    public String getShopTypeName()
    {
        return shopTypeName;
    }

    public void setShopTypeName(String shopTypeName)
    {
        this.shopTypeName = shopTypeName;
    }

    public List<UShopType> getChildren()
    {
        return children;
    }

    public void setChildren(List<UShopType> children)
    {
        this.children = children;
    }

}
