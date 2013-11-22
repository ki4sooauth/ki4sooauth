package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家wifisensor设备表
 */

public class FDeviceWifisensor implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String shopEntityName;//实体店名称

    private String deviceMac;//MAC地址

    private String deviceType;//wifisensor设备型号，参考通用字典表的w_device_status

    private String deviceSn;//设备序列号

    private Date installDate;//安装日期

    private String status;//设备状态，参考通用字典表的device_status。分为0-在用，1-停用，2-损坏

    private String positionId;//位置编号，描述在实体店中所处的位置

    private String positionName;//位置名称，描述在实体店中所处的位置

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    private Date installDate_F;//安装日期，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date installDate_T;//安装日期，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date installDate_FE;//安装日期，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date installDate_TE;//安装日期，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date createTime_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date createTime_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date createTime_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date createTime_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date cTimeStamp_F;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date cTimeStamp_T;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date cTimeStamp_FE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date cTimeStamp_TE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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

    public Date getInstallDate_F()
    {
        return this.installDate_F;
    }

    public void setInstallDate_F(Date installDate_F)
    {
        this.installDate_F = installDate_F;
    }

    public Date getInstallDate_T()
    {
        return this.installDate_T;
    }

    public void setInstallDate_T(Date installDate_T)
    {
        this.installDate_T = installDate_T;
    }

    public Date getInstallDate_FE()
    {
        return this.installDate_FE;
    }

    public void setInstallDate_FE(Date installDate_FE)
    {
        this.installDate_FE = installDate_FE;
    }

    public Date getInstallDate_TE()
    {
        return this.installDate_TE;
    }

    public void setInstallDate_TE(Date installDate_TE)
    {
        this.installDate_TE = installDate_TE;
    }

    public Date getCreateTime_F()
    {
        return this.createTime_F;
    }

    public void setCreateTime_F(Date createTime_F)
    {
        this.createTime_F = createTime_F;
    }

    public Date getCreateTime_T()
    {
        return this.createTime_T;
    }

    public void setCreateTime_T(Date createTime_T)
    {
        this.createTime_T = createTime_T;
    }

    public Date getCreateTime_FE()
    {
        return this.createTime_FE;
    }

    public void setCreateTime_FE(Date createTime_FE)
    {
        this.createTime_FE = createTime_FE;
    }

    public Date getCreateTime_TE()
    {
        return this.createTime_TE;
    }

    public void setCreateTime_TE(Date createTime_TE)
    {
        this.createTime_TE = createTime_TE;
    }

    public Date getCTimeStamp_F()
    {
        return this.cTimeStamp_F;
    }

    public void setCTimeStamp_F(Date cTimeStamp_F)
    {
        this.cTimeStamp_F = cTimeStamp_F;
    }

    public Date getCTimeStamp_T()
    {
        return this.cTimeStamp_T;
    }

    public void setCTimeStamp_T(Date cTimeStamp_T)
    {
        this.cTimeStamp_T = cTimeStamp_T;
    }

    public Date getCTimeStamp_FE()
    {
        return this.cTimeStamp_FE;
    }

    public void setCTimeStamp_FE(Date cTimeStamp_FE)
    {
        this.cTimeStamp_FE = cTimeStamp_FE;
    }

    public Date getCTimeStamp_TE()
    {
        return this.cTimeStamp_TE;
    }

    public void setCTimeStamp_TE(Date cTimeStamp_TE)
    {
        this.cTimeStamp_TE = cTimeStamp_TE;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.deviceMac + "^" + this.deviceType + "^" + this.deviceSn + "^" + this.installDate + "^" + this.status + "^" + this.positionId + "^" + this.positionName + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
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
