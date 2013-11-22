package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FTableInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Date createTime;//创建时间

    private String id;//自动编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private String remark;//备用

    private String tableType;//餐桌类型，如3-8人

    private Integer minNums;//建议最小人数

    private Integer maxNums;//建议最大人数

    private String roomName;//包间名称：由字母、数字、文字组成

    private String shopEntityId;//实体店编号

    private String shopEntityName;//实体店编号

    private String shopId;//商家编号

    private String tableNo;//桌号：由字母、数字、文字组成，同一实体店内不能重复
    private String mac;//所属转发器mac地址

    public Integer getMinNums()
    {
        return this.minNums;
    }

    public void setMinNums(Integer minNums)
    {
        this.minNums = minNums;
    }

    public Integer getMaxNums()
    {
        return this.maxNums;
    }

    public void setMaxNums(Integer maxNums)
    {
        this.maxNums = maxNums;
    }

    public String getTableType()
    {
        return this.tableType;
    }

    public void setTableType(String tableType)
    {
        this.tableType = tableType;
    }

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getId()
    {
        return this.id;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public String getRemark()
    {
        return this.remark;
    }

    public String getRoomName()
    {
        return this.roomName;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getTableNo()
    {
        return this.tableNo;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public void setRoomName(String roomName)
    {
        this.roomName = roomName;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setTableNo(String tableNo)
    {
        this.tableNo = tableNo;
    }

    @Override
    public String toString()
    {
        return "FTableInfo [createTime=" + this.createTime + ", id=" + this.id + ", isDel=" + this.isDel + ", remark=" + this.remark + ", tableType=" + this.tableType + ", minNums=" + this.minNums + ", maxNums=" + this.maxNums + ", roomName=" + this.roomName + ", shopEntityId=" + this.shopEntityId + ", shopEntityName=" + this.shopEntityName + ", shopId=" + this.shopId + ", tableNo=" + this.tableNo + "]";
    }

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

}
