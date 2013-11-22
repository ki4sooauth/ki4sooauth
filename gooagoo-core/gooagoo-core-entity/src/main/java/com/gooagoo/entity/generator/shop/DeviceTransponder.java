package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家转发器设备表
 */

public class DeviceTransponder implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String deviceTransponderId;//转发器设备编号，UUID

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String deviceMac;//MAC地址

    private String deviceType;//转发器设备型号，参考通用字典表的s_device_status

    private String deviceSn;//设备序列号

    private Date installDate;//安装日期

    private String status;//设备状态，参考通用字典表的device_status。分为0-在用，1-停用，2-损坏

    private String note;//备注

    private String systemType;//对应的操作系统，0-dos，1-windows，2-linux

    private String billParse;//对应的解析格式，参考字典表

    private String stService;//对应的功能，参考字典表

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getDeviceTransponderId()
    {
        return this.deviceTransponderId;
    }

    public void setDeviceTransponderId(String deviceTransponderId)
    {
        this.deviceTransponderId = deviceTransponderId;
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

    public String getDeviceMac()
    {
        return this.deviceMac;
    }

    public void setDeviceMac(String deviceMac)
    {
        this.deviceMac = deviceMac;
    }

    public String getDeviceType()
    {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceSn()
    {
        return this.deviceSn;
    }

    public void setDeviceSn(String deviceSn)
    {
        this.deviceSn = deviceSn;
    }

    public Date getInstallDate()
    {
        return this.installDate;
    }

    public void setInstallDate(Date installDate)
    {
        this.installDate = installDate;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getSystemType()
    {
        return this.systemType;
    }

    public void setSystemType(String systemType)
    {
        this.systemType = systemType;
    }

    public String getBillParse()
    {
        return this.billParse;
    }

    public void setBillParse(String billParse)
    {
        this.billParse = billParse;
    }

    public String getStService()
    {
        return this.stService;
    }

    public void setStService(String stService)
    {
        this.stService = stService;
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
        return this.deviceTransponderId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.deviceMac + "^" + this.deviceType + "^" + this.deviceSn + "^" + this.installDate + "^" + this.status + "^" + this.note + "^" + this.systemType + "^" + this.billParse + "^" + this.stService + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
