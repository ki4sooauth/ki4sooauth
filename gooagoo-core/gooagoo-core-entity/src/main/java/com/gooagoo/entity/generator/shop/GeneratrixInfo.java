package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 动线信息
 */

public class GeneratrixInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String generatrixId;//动线编号

    private String mapId;//所属地图编号

    private String generatrixType;//动线类型

    private String svgTagId;//svg图上的标签id值

    private String svgTagCode;//svg图上的标签代码

    private Date createTime;//创建时间

    public String getGeneratrixId()
    {
        return this.generatrixId;
    }

    public void setGeneratrixId(String generatrixId)
    {
        this.generatrixId = generatrixId;
    }

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public String getGeneratrixType()
    {
        return this.generatrixType;
    }

    public void setGeneratrixType(String generatrixType)
    {
        this.generatrixType = generatrixType;
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
        return this.generatrixId + "^" + this.mapId + "^" + this.generatrixType + "^" + this.svgTagId + "^" + this.svgTagCode + "^" + this.createTime;
    }
}
