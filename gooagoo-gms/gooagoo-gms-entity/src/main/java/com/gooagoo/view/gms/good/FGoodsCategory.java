package com.gooagoo.view.gms.good;

import java.io.Serializable;

public class FGoodsCategory implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;// 自动编号

    private String categoryId;//品类编号
    private String categoryName;//品类名称
    private String parentCategoryId;//父品类编号，0表示没有父品类
    private String parentCategoryName;//父品类名称，若没有父品类此字段为空
    private String picUrl;//图片URL
    private String shopId;//所属商家
    private String entityId;// 实体店Id
    private String positionId; //位置编码
    private String positionName;//位置名称

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCategoryId()
    {
        return this.categoryId;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public String getParentCategoryId()
    {
        return this.parentCategoryId;
    }

    public String getParentCategoryName()
    {
        return this.parentCategoryName;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public void setParentCategoryId(String parentCategoryId)
    {
        this.parentCategoryId = parentCategoryId;
    }

    public void setParentCategoryName(String parentCategoryName)
    {
        this.parentCategoryName = parentCategoryName;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
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

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

}
