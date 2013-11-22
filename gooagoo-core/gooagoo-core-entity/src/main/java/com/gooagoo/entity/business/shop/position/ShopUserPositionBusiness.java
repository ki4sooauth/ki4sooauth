package com.gooagoo.entity.business.shop.position;

import java.io.Serializable;

public class ShopUserPositionBusiness implements Serializable
{

    /**
     * 店员区域信息（店员有对应品牌，positionId为对应品牌的位置编号，店员无品牌时，对应的是实体店的主区域编号）
     */
    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String shopEntityName;//实体店名称

    private String positionId;//区域编号

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    @Override
    public String toString()
    {
        return "ShopUserPositionBusiness [shopEntityId=" + this.shopEntityId + ", shopEntityName=" + this.shopEntityName + ", positionId=" + this.positionId + "]";
    }

}
