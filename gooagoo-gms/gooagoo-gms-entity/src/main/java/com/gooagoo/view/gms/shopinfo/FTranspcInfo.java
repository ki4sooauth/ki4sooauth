package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FTranspcInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String deviceMac;//转发器MAC地址

    private String place;//设备位置描述

    private String note;//备注

    private String shopEntityId;//实体店编号
    private String shopEntityName;//实体店名称

    private String shopId;//商家编号

    private String deviceSn;//设备序列号

    private String status;//状态类型：0在用，1停用，2损坏

    private String deviceTransponderId;//转发器编号，UUID

    private String deviceType; //型号id

    private String typeNameCh; //型号中文名称

    private Date installDate;//安装日期

    private String systemType;//对应的操作系统，0-dos，1-windows，2-linux

    private String billParse;//对应的解析格式，参考字典表
    private String billParseName;//对应的解析格式，参考字典表

    private String stService;//对应的功能，参考字典表，可为多个功能，以逗号分隔
    private String stServiceName;//对应的功能，参考字典表，可为多个功能，以逗号分隔

    public Date getInstallDate()
    {
        return this.installDate;
    }

    public String getDeviceMac()
    {
        return this.deviceMac;
    }

    public void setDeviceMac(String deviceMac)
    {
        this.deviceMac = deviceMac;
    }

    public String getPlace()
    {
        return this.place;
    }

    public String getTypeNameCh()
    {
        return this.typeNameCh;
    }

    public void setTypeNameCh(String typeNameCh)
    {
        this.typeNameCh = typeNameCh;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setInstallDate(Date installDate)
    {
        this.installDate = installDate;
    }

    public void setPlace(String place)
    {
        this.place = place;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
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

    public String getDeviceSn()
    {
        return this.deviceSn;
    }

    public void setDeviceSn(String deviceSn)
    {
        this.deviceSn = deviceSn;
    }

    public String getDeviceType()
    {
        return this.deviceType;
    }

    public void setDeviceType(String deviceType)
    {
        this.deviceType = deviceType;
    }

    public String getDeviceTransponderId()
    {
        return this.deviceTransponderId;
    }

    public void setDeviceTransponderId(String deviceTransponderId)
    {
        this.deviceTransponderId = deviceTransponderId;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    //对应的操作系统，0-dos，1-windows，2-linux
    public String getSystemType()
    {
        if (this.systemType.equals("0"))
        {
            this.systemType = "dos";
        }
        if (this.systemType.equals("1"))
        {
            this.systemType = "windows";
        }
        if (this.systemType.equals("2"))
        {
            this.systemType = "linux";
        }

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

    public String getBillParseName()
    {
        return this.billParseName;
    }

    public void setBillParseName(String billParseName)
    {
        this.billParseName = billParseName;
    }

    public String getStServiceName()
    {
        return this.stServiceName;
    }

    public void setStServiceName(String stServiceName)
    {
        this.stServiceName = stServiceName;
    }

}
