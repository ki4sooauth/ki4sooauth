package com.gooagoo.entity.business.shop;

import java.io.Serializable;

import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityLink;

/**
 * 实体店关联信息（实体店基本信息、实体店联系信息）
 */
public class ShopEntityInfoBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private ShopEntityInfo ShopEntityInfo;//实体店基本信息

    private ShopEntityLink ShopEntityLink;//实体店联系方式

    public ShopEntityInfo getShopEntityInfo()
    {
        return this.ShopEntityInfo;
    }

    public void setShopEntityInfo(ShopEntityInfo shopEntityInfo)
    {
        this.ShopEntityInfo = shopEntityInfo;
    }

    public ShopEntityLink getShopEntityLink()
    {
        return this.ShopEntityLink;
    }

    public void setShopEntityLink(ShopEntityLink shopEntityLink)
    {
        this.ShopEntityLink = shopEntityLink;
    }

    @Override
    public String toString()
    {
        return "ShopEntityInfoBusiness [ShopEntityInfo=" + this.ShopEntityInfo + ", ShopEntityLink=" + this.ShopEntityLink + "]";
    }

}
