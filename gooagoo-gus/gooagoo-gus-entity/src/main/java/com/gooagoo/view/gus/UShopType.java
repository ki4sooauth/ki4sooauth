package com.gooagoo.view.gus;

import java.io.Serializable;
import java.util.List;

/**
 * 商家类型
 * @author SPZ
 *
 */
public class UShopType implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer shopTypeId;//商家类型ID

    private String shopTypeName;//商家类型名称

    private List<UShopType> childrenShopType;//子商家类型

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

    public List<UShopType> getChildrenShopType()
    {
        return childrenShopType;
    }

    public void setChildrenShopType(List<UShopType> childrenShopType)
    {
        this.childrenShopType = childrenShopType;
    }

    @Override
    public String toString()
    {
        return "UShopType [shopTypeId=" + shopTypeId + ", shopTypeName=" + shopTypeName + ", childrenShopType=" + childrenShopType + "]";
    }

}
