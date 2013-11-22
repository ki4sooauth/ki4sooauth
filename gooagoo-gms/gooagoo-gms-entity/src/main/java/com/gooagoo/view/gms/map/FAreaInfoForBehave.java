package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 区域信息 
 *
 */
public class FAreaInfoForBehave implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String mapId;// 所属地图编号
    private String positionId;// 位置编号

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
}
