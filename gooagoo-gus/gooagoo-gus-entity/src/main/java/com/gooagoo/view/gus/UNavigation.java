package com.gooagoo.view.gus;

import java.io.Serializable;

/**
 * 地图导航
 * @author SPZ
 *
 */
public class UNavigation implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String mapId;//地图ID

    private Double x;//X轴

    private Double y;//Y轴

    private String shopId;//商家ID

    private String shopEntityId;//实体店ID

    private String positionName;//位置名称

    public String getMapId()
    {
        return mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public Double getX()
    {
        return x;
    }

    public void setX(Double x)
    {
        this.x = x;
    }

    public Double getY()
    {
        return y;
    }

    public void setY(Double y)
    {
        this.y = y;
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

    public String getPositionName()
    {
        return positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    @Override
    public String toString()
    {
        return "Navigation [mapId=" + mapId + ", x=" + x + ", y=" + y + ", shopId=" + shopId + ", shopEntityId=" + shopEntityId + ", positionName=" + positionName + "]";
    }

}
