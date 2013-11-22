package com.gooagoo.view.mis.systemHierarchy;

import java.io.Serializable;
import java.util.Date;

/**
 * 商圈
 */
public class MTradeArea implements Serializable
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

    private String platformName;//小平台名称（用于页面展示）

    private String tradeAreaNoPage;//是否分页查询（null时默认分页查询，有值则取消分页查询）

    public String getTradeAreaId()
    {
        return tradeAreaId;
    }

    public void setTradeAreaId(String tradeAreaId)
    {
        this.tradeAreaId = tradeAreaId;
    }

    public String getPlatformId()
    {
        return platformId;
    }

    public void setPlatformId(String platformId)
    {
        this.platformId = platformId;
    }

    public String getTradeAreaName()
    {
        return tradeAreaName;
    }

    public void setTradeAreaName(String tradeAreaName)
    {
        this.tradeAreaName = tradeAreaName;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
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

    public String getPlatformName()
    {
        return platformName;
    }

    public void setPlatformName(String platformName)
    {
        this.platformName = platformName;
    }

    public String getTradeAreaNoPage()
    {
        return tradeAreaNoPage;
    }

    public void setTradeAreaNoPage(String tradeAreaNoPage)
    {
        this.tradeAreaNoPage = tradeAreaNoPage;
    }

}
