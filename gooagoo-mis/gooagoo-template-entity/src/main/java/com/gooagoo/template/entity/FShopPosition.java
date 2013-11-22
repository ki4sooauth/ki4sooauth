package com.gooagoo.template.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 位置管理表
 */

public class FShopPosition implements Serializable
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
    
    private String shopName;//商家名称
    private String shopEntityName;//实体店名称

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getPositionName()
    {
        return positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getParentPositionId()
    {
        return parentPositionId;
    }

    public void setParentPositionId(String parentPositionId)
    {
        this.parentPositionId = parentPositionId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLesseeShopId()
    {
        return lesseeShopId;
    }

    public void setLesseeShopId(String lesseeShopId)
    {
        this.lesseeShopId = lesseeShopId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopEntityName()
    {
        return shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

}
