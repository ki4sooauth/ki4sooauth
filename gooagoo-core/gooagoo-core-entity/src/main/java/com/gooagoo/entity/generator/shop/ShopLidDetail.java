package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家LID详细分配信息
 */

public class ShopLidDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lid;//LID

    private String lidBase;//LID基本信息

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String positionId;//位置编号，描述LID在实体店中所处的位置

    private String positionName;//位置名称，描述LID在实体店中所处的位置

    private String status;//是否使用：Y-正在使用，N-未使用，S-停用，D-损坏

    private Double px;//x轴坐标（位置引擎中的坐标）

    private Double py;//y轴坐标（位置引擎中的坐标）

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getLid()
    {
        return this.lid;
    }

    public void setLid(String lid)
    {
        this.lid = lid;
    }

    public String getLidBase()
    {
        return this.lidBase;
    }

    public void setLidBase(String lidBase)
    {
        this.lidBase = lidBase;
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

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

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
        return this.lid + "^" + this.lidBase + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.positionId + "^" + this.positionName + "^" + this.status + "^" + this.px + "^" + this.py + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
