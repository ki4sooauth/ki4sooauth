package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 商家wifisensor设备表
 */

public class DeviceWifisensorKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String deviceWifisensorId;//wifi设备编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getDeviceWifisensorId()
    {
        return deviceWifisensorId;
    }

    public void setDeviceWifisensorId(String deviceWifisensorId)
    {
        this.deviceWifisensorId = deviceWifisensorId;
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
