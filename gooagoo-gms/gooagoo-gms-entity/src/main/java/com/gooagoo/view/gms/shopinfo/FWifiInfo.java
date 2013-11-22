package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;

public class FWifiInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String shopEntityName;//实体店编号

    private String shopId;//商家编号

    private String wifiInfoId;//wifi编号，唯一，通过UUID产生

    private String wifiMac;//wifi的mac地址

    private String wifiPassword;//wifi的口令，md5加密

    private String wifiSsid;//wifi的名称

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getWifiInfoId()
    {
        return this.wifiInfoId;
    }

    public String getWifiMac()
    {
        return this.wifiMac;
    }

    public String getWifiPassword()
    {
        return this.wifiPassword;
    }

    public String getWifiSsid()
    {
        return this.wifiSsid;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setWifiInfoId(String wifiInfoId)
    {
        this.wifiInfoId = wifiInfoId;
    }

    public void setWifiMac(String wifiMac)
    {
        this.wifiMac = wifiMac;
    }

    public void setWifiPassword(String wifiPassword)
    {
        this.wifiPassword = wifiPassword;
    }

    public void setWifiSsid(String wifiSsid)
    {
        this.wifiSsid = wifiSsid;
    }

    @Override
    public String toString()
    {
        return "FWifiInfo [shopEntityId=" + this.shopEntityId + ", shopId=" + this.shopId + ", wifiInfoId=" + this.wifiInfoId + ", wifiMac=" + this.wifiMac + ", wifiPassword=" + this.wifiPassword + ", wifiSsid=" + this.wifiSsid + "]";
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

}
