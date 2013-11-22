package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 商家店员助理设备表
 */

public class DeviceAssistantKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String deviceAssistantId;//店员助理设备编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getDeviceAssistantId()
    {
        return deviceAssistantId;
    }

    public void setDeviceAssistantId(String deviceAssistantId)
    {
        this.deviceAssistantId = deviceAssistantId;
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
