package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FShopLidDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Date createTime;//创建时间

    private String lid;//LID

    private String positionId;//位置编号，描述LID在实体店中所处的位置

    private String positionName;//位置名称，描述LID在实体店中所处的位置

    private String shopEntityId;//实体店编号

    private String shopEntityName;

    private String shopId;//商家编号

    private String status;//是否使用：Y-正在使用，N-未使用，S-停用，D-损坏

    private Double px;//x轴坐标

    private Double py;//y轴坐标

    public Double getPx()
    {
        return this.px;
    }

    public void setPx(Double px)
    {
        this.px = px;
    }

    public Double getPy()
    {
        return this.py;
    }

    public void setPy(Double py)
    {
        this.py = py;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getLid()
    {
        return this.lid;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public String getPositionName()
    {
        return this.positionName;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setLid(String lid)
    {
        this.lid = lid;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "FShopLidDetail [createTime=" + this.createTime + ", lid=" + this.lid + ", positionId=" + this.positionId + ", positionName=" + this.positionName + ", shopEntityId=" + this.shopEntityId + ", shopId=" + this.shopId + ", status=" + this.status + ",px=" + this.px + ",py=" + this.py + "]";
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
