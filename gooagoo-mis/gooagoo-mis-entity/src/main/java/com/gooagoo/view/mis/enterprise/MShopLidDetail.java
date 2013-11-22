package com.gooagoo.view.mis.enterprise;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家LID详细分配信息
 */

public class MShopLidDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lid;//LID

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String positionId;//位置编号，描述LID在实体店中所处的位置

    private String positionName;//位置名称，描述LID在实体店中所处的位置

    private String status;//是否使用：Y-正在使用，N-未使用，S-停用，D-损坏

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getLid()
    {
        return lid;
    }

    public void setLid(String lid)
    {
        this.lid = lid;
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

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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
        return this.lid + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.positionId + "^" + this.positionName + "^" + this.status + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
