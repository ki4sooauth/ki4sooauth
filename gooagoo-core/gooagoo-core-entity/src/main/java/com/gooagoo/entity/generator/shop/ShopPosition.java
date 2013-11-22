package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 位置管理表
 */

public class ShopPosition implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String positionId;//位置编号，唯一，通过UUID产生

    private String positionName;//位置名称

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String parentPositionId;//父位置编号

    private String description;//位置描述

    private String lesseeShopId;//承租商家编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getParentPositionId()
    {
        return this.parentPositionId;
    }

    public void setParentPositionId(String parentPositionId)
    {
        this.parentPositionId = parentPositionId;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLesseeShopId()
    {
        return this.lesseeShopId;
    }

    public void setLesseeShopId(String lesseeShopId)
    {
        this.lesseeShopId = lesseeShopId;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.positionId + "^" + this.positionName + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.parentPositionId + "^" + this.description + "^" + this.lesseeShopId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
