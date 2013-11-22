package com.gooagoo.mobile.common.entity;

import java.io.Serializable;
import java.util.Date;

public class ShopInfoEntity implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String shopid = null;//商家编号

    public Date cTimeStamp = null;//最大时间戳

    public String getShopid()
    {
        return this.shopid;
    }

    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return "ShopInfoEntity [shopid=" + this.shopid + ", cTimeStamp=" + this.cTimeStamp + "]";
    }
}
