package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 区域信息
 */

public class FAreaInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String areaId;//区域编号

    private String mapId;//所属地图编号

    private String positionId;//位置编号

    private String positionName;// 位置名称

    private String shopId;// 商家编号

    private String shopEntityId;// 实体店编号

    private String svgTagId;//svg图上的标签id值

    private String svgTagCode;//svg图上的标签代码

    private Double px;//区域x轴坐标，展示活动等信息时，用到的坐标点

    private Double py;//区域y轴坐标，展示活动等信息时，用到的坐标点

    public String getAreaId()
    {
        return this.areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getSvgTagId()
    {
        return this.svgTagId;
    }

    public void setSvgTagId(String svgTagId)
    {
        this.svgTagId = svgTagId;
    }

    public String getSvgTagCode()
    {
        return this.svgTagCode;
    }

    public void setSvgTagCode(String svgTagCode)
    {
        this.svgTagCode = svgTagCode;
    }

    public Double getPx()
    {
        return this.px;
    }

    public void setPx(Double px)
    {
        this.px = px;
    }

    public Double getPy()
    {
        return this.py;
    }

    public void setPy(Double py)
    {
        this.py = py;
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

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }
}
