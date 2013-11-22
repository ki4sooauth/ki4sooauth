package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 图元素信息，门、人、车、设备、电梯、卫生间、ATM，lid，wifi sensor
 */

public class FMapElementInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String elementId;//图元素编号

    private String mapId;//所属图编号

    private String svgTagId;//svg图上的标签id值

    private String svgTagCode;//svg图上的标签代码

    private String elementType;//元素类别

    private String areaId;//元素所属区域id

    private Double px;//元素x轴坐标

    private Double py;//元素y轴坐标

    public String getElementId()
    {
        return this.elementId;
    }

    public void setElementId(String elementId)
    {
        this.elementId = elementId;
    }

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
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

    public String getElementType()
    {
        return this.elementType;
    }

    public void setElementType(String elementType)
    {
        this.elementType = elementType;
    }

    public String getAreaId()
    {
        return this.areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
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
}
