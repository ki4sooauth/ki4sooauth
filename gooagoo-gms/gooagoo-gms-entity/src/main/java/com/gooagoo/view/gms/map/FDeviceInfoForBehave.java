package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 设备信息
 *
 */
public class FDeviceInfoForBehave implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String mac;
    private String positionId;

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }
}
