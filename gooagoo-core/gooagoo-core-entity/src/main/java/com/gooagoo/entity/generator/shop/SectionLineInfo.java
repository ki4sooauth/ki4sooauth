package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 分段线路信息--导航时需要
 */

public class SectionLineInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lineId;//路线编号

    private String mapId;//所属地图编号

    private String svgTagCode;//svg图上的标签代码

    private Integer weight;//权重

    private Double length;//路线的长度

    private Double firstPointX;//路线第一个点的x坐标

    private Double firstPointY;//路线第一个点的y坐标

    private Double secondPointX;//路线第二个点的x坐标

    private Double secondPointY;//路线第二个点的y坐标

    private Date createTime;//创建时间

    public String getLineId()
    {
        return this.lineId;
    }

    public void setLineId(String lineId)
    {
        this.lineId = lineId;
    }

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public String getSvgTagCode()
    {
        return this.svgTagCode;
    }

    public void setSvgTagCode(String svgTagCode)
    {
        this.svgTagCode = svgTagCode;
    }

    public Integer getWeight()
    {
        return this.weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }

    public Double getLength()
    {
        return this.length;
    }

    public void setLength(Double length)
    {
        this.length = length;
    }

    public Double getFirstPointX()
    {
        return this.firstPointX;
    }

    public void setFirstPointX(Double firstPointX)
    {
        this.firstPointX = firstPointX;
    }

    public Double getFirstPointY()
    {
        return this.firstPointY;
    }

    public void setFirstPointY(Double firstPointY)
    {
        this.firstPointY = firstPointY;
    }

    public Double getSecondPointX()
    {
        return this.secondPointX;
    }

    public void setSecondPointX(Double secondPointX)
    {
        this.secondPointX = secondPointX;
    }

    public Double getSecondPointY()
    {
        return this.secondPointY;
    }

    public void setSecondPointY(Double secondPointY)
    {
        this.secondPointY = secondPointY;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return this.lineId + "^" + this.mapId + "^" + this.svgTagCode + "^" + this.weight + "^" + this.length + "^" + this.firstPointX + "^" + this.firstPointY + "^" + this.secondPointX + "^" + this.secondPointY + "^" + this.createTime;
    }
}
