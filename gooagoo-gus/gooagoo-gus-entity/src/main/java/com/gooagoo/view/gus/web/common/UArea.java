package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

public class UArea implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String areaId;//区县ID

    private String areaName;//区县名称

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

}
