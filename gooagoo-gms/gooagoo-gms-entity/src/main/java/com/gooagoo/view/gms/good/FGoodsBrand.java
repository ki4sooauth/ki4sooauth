package com.gooagoo.view.gms.good;

import java.io.Serializable;

public class FGoodsBrand implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String brandId; //品牌编号
    private String brandName;//品牌名称
    private String id; //品牌Id
    private String picUrl;//品牌图片
    private String positionId; //位置编码
    private String positionName;//位置名称
    private String shopId;//商家id 
    private String entityId;// 实体店id

    public String getBrandId()
    {
        return this.brandId;
    }

    public String getBrandName()
    {
        return this.brandName;
    }

    public String getId()
    {
        return this.id;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getEntityId()
    {
        return this.entityId;
    }

    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }

    @Override
    public String toString()
    {
        return "FGoodsBrand [brandId=" + this.brandId + ", brandName=" + this.brandName + ", id=" + this.id + ", picUrl=" + this.picUrl + ", positionId=" + this.positionId + ", positionName=" + this.positionName + ", shopId=" + this.shopId + "]";
    }

}
