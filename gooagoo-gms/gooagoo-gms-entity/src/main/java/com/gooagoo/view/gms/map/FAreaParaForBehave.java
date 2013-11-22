package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 地图信息
 *
 */
public class FAreaParaForBehave implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String mapId;
    private String ratio;
    private String offset_x;
    private String offset_y;

    public String getMapId()
    {
        return this.mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public String getRatio()
    {
        return this.ratio;
    }

    public void setRatio(String ratio)
    {
        this.ratio = ratio;
    }

    public String getOffset_x()
    {
        return this.offset_x;
    }

    public void setOffset_x(String offset_x)
    {
        this.offset_x = offset_x;
    }

    public String getOffset_y()
    {
        return this.offset_y;
    }

    public void setOffset_y(String offset_y)
    {
        this.offset_y = offset_y;
    }
}
