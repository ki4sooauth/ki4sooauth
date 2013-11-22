package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 区域地图参数
 */

public class AreaParaKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String mapId;//地图编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getMapId()
    {
        return mapId;
    }

    public void setMapId(String mapId)
    {
        this.mapId = mapId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
