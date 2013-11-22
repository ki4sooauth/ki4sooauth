package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体店Wifi信息配置表，每个实体店可以配置多个wifi
 */

public class ShopWifiinfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String wifiInfoId;//wifi编号，唯一，通过UUID产生

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String wifiSsid;//wifi的名称

    private String wifiMac;//wifi的mac地址

    private String wifiPassword;//wifi的口令，md5加密

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getWifiInfoId()
    {
        return this.wifiInfoId;
    }

    public void setWifiInfoId(String wifiInfoId)
    {
        this.wifiInfoId = wifiInfoId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getWifiSsid()
    {
        return this.wifiSsid;
    }

    public void setWifiSsid(String wifiSsid)
    {
        this.wifiSsid = wifiSsid;
    }

    public String getWifiMac()
    {
        return this.wifiMac;
    }

    public void setWifiMac(String wifiMac)
    {
        this.wifiMac = wifiMac;
    }

    public String getWifiPassword()
    {
        return this.wifiPassword;
    }

    public void setWifiPassword(String wifiPassword)
    {
        this.wifiPassword = wifiPassword;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.wifiInfoId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.wifiSsid + "^" + this.wifiMac + "^" + this.wifiPassword + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
