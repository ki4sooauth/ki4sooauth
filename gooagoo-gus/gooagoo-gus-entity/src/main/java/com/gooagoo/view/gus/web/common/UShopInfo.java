package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

public class UShopInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String shopName;//商家名称

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

}
