package com.gooagoo.view.mis.enterprise;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家wifisensor设备表
 */

public class MDeviceWifisensor implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String deviceWifisensorId;//自动编号，UUID

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String deviceMac;//MAC地址

    private String deviceType;//wifisensor设备型号，参考通用字典表的w_device_status

    private String deviceSn;//设备序列号

    private Date installDate;//安装日期

    private String status;//设备状态，参考通用字典表的device_status。分为0-在用，1-停用，2-损坏

    private String positionId;//位置编号，描述在实体店中所处的位置

    private String positionName;//位置名称，描述在实体店中所处的位置

    private String note;//备注

    private Double px;//x轴坐标（位置引擎中的坐标）

    private Double py;//y轴坐标（位置引擎中的坐标）

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getDeviceWifisensorId()
    {
        return deviceWifisensorId;
    }

    public void setDeviceWifisensorId(String deviceWifisensorId)
    {
        this.deviceWifisensorId = deviceWifisensorId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getDeviceMac()
    {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac)
    {
        this.deviceMac = deviceMac;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceSn()
    {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn)
    {
        this.deviceSn = deviceSn;
    }

    public Date getInstallDate()
    {
        return installDate;
    }

    public void setInstallDate(Date installDate)
    {
        this.installDate = installDate;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getPositionId()
    {
        return positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getPositionName()
    {
        return positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public Double getPx()
    {
        return px;
    }

    public void setPx(Double px)
    {
        this.px = px;
    }

    public Double getPy()
    {
        return py;
    }

    public void setPy(Double py)
    {
        this.py = py;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String toString()
    {
        return this.deviceWifisensorId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.deviceMac + "^" + this.deviceType + "^" + this.deviceSn + "^" + this.installDate + "^" + this.status + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
