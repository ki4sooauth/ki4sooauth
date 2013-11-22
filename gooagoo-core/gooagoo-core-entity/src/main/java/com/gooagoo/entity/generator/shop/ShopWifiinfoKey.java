package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 实体店Wifi信息配置表，每个实体店可以配置多个wifi
 */

public class ShopWifiinfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String wifiInfoId;//wifi编号，唯一，通过UUID产生

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getWifiInfoId()
    {
        return wifiInfoId;
    }

    public void setWifiInfoId(String wifiInfoId)
    {
        this.wifiInfoId = wifiInfoId;
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
