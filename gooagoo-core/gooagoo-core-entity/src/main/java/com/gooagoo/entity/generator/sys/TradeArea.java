package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 商圈
 */

public class TradeArea implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String tradeAreaId;//商圈编号，UUID

    private String platformId;//小平台编号，表明商圈属于该小平台下

    private String tradeAreaName;//商圈名称

    private String description;//描述

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getTradeAreaId()
    {
        return this.tradeAreaId;
    }

    public void setTradeAreaId(String tradeAreaId)
    {
        this.tradeAreaId = tradeAreaId;
    }

    public String getPlatformId()
    {
        return this.platformId;
    }

    public void setPlatformId(String platformId)
    {
        this.platformId = platformId;
    }

    public String getTradeAreaName()
    {
        return this.tradeAreaName;
    }

    public void setTradeAreaName(String tradeAreaName)
    {
        this.tradeAreaName = tradeAreaName;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
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

    @Override
    public String toString()
    {
        return this.tradeAreaId + "^" + this.platformId + "^" + this.tradeAreaName + "^" + this.description + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
