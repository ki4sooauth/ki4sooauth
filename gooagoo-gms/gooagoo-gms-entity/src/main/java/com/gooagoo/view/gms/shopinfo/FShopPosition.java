package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FShopPosition implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Date createTime;//创建时间

    private String description;//位置描述

    private String parentPositionId;//父位置编号

    private String parentPositionName;//父级名称

    private String positionId;//位置编号，唯一，通过UUID产生

    private String positionName;//位置名称

    private String shopEntityId;//实体店编号

    private String shopId;//商家编号

    private String lesseeShopId;//承租商家编号

    public String getLesseeShopId()
    {
        return this.lesseeShopId;
    }

    public void setLesseeShopId(String lesseeShopId)
    {
        this.lesseeShopId = lesseeShopId;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getDescription()
    {
        return this.description;
    }

    public String getParentPositionId()
    {
        return this.parentPositionId;
    }

    public String getParentPositionName()
    {
        return this.parentPositionName;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setParentPositionId(String parentPositionId)
    {
        this.parentPositionId = parentPositionId;
    }

    public void setParentPositionName(String parentPositionName)
    {
        this.parentPositionName = parentPositionName;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    @Override
    public String toString()
    {
        return "FShopPosition [createTime=" + this.createTime + ", description=" + this.description + ", parentPositionId=" + this.parentPositionId + ", parentPositionName=" + this.parentPositionName + ", positionId=" + this.positionId + ", positionName=" + this.positionName + ", shopEntityId=" + this.shopEntityId + ", shopId=" + this.shopId + "]";
    }

}
