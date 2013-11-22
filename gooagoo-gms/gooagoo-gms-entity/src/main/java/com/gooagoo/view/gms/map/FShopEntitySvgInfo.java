package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 实体店的svg地图
 *
 */
public class FShopEntitySvgInfo extends FSvgInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }
}
