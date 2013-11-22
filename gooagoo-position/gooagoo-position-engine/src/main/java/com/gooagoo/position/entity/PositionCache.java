package com.gooagoo.position.entity;

import java.io.Serializable;

public class PositionCache implements Serializable
{
    private static final long serialVersionUID = -7547638298262523052L;

    private String mac;
    private String positionId;
    private char gridAttribute;//网格属性，0-室外，1-室内
    private long time;
    private String behavior;
    private String entityId; //实体店编号
    private String shopId;

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public char getGridAttribute()
    {
        return gridAttribute;
    }

    public void setGridAttribute(char gridAttribute)
    {
        this.gridAttribute = gridAttribute;
    }

    public long getTime()
    {
        return time;
    }

    public void setTime(long time)
    {
        this.time = time;
    }

    public String getBehavior()
    {
        return behavior;
    }

    public void setBehavior(String behavior)
    {
        this.behavior = behavior;
    }

    public String getEntityId()
    {
        return entityId;
    }

    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }
}
