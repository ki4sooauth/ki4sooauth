package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 餐厅桌号信息表
 */

public class ShopTableInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String tableName;//餐桌名称：可由字母、数字、文字组成，同一实体店内不能重复，需与餐饮软件中保持一致

    private String roomName;//包间名称：可由字母、数字、文字组成，同一实体店内不能重复，需与餐饮软件中保持一致

    private String remark;//备用

    private String tableTypeCode;//餐桌类型编码

    private String status;//餐桌状态，参考通用字典表的desk_status，默认为1（空闲）

    private String mac;//所属转发器mac地址

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getRoomName()
    {
        return this.roomName;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getTableTypeCode()
    {
        return this.tableTypeCode;
    }

    public void setTableTypeCode(String tableTypeCode)
    {
        this.tableTypeCode = tableTypeCode;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
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
        return this.id + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.tableName + "^" + this.roomName + "^" + this.remark + "^" + this.tableTypeCode + "^" + this.status + "^" + this.mac + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
