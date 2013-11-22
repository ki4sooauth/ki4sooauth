package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 商家转发器设备表
 */

public class DeviceTransponderKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String deviceTransponderId;//转发器设备编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getDeviceTransponderId()
    {
        return deviceTransponderId;
    }

    public void setDeviceTransponderId(String deviceTransponderId)
    {
        this.deviceTransponderId = deviceTransponderId;
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
