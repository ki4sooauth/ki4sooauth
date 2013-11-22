package com.gooagoo.entity.position;

import java.io.Serializable;

public class Position implements Serializable
{
    private static final long serialVersionUID = -1020742623078761541L;

    private String macAddress;//MAC地址
    private String x;//x位置坐标
    private String y;//y位置坐标
    private String mapId;//地图编号

    public Position()
    {
        super();
    }

    public Position(String macAddress, String x, String y, String mapId)
    {
        super();
        this.macAddress = macAddress;
        this.x = x;
        this.y = y;
        this.mapId = mapId;
    }

    public String getMacAddress()
    {
        return macAddress;
    }

    public void setMacAddress(String macAddress)
    {
        this.macAddress = macAddress;
    }

    public String getX()
    {
        return x;
    }

    public void setX(String x)
    {
        this.x = x;
    }

    public String getY()
    {
        return y;
    }

    public void setY(String y)
    {
        this.y = y;
    }

    public String getMapId()
    {
        return mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }
}
