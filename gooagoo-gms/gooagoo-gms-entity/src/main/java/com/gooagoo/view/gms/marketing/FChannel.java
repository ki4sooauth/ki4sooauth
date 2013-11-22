package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销渠道信息
 */
public class FChannel implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String channelCode;//营销渠道编码（主键）
    private String channelName;//营销渠道名称
    private String parentChannelCode;//父级营销渠道编码（一级营销渠道编码-父渠道编码为‘0’）
    private Integer sort;//排序
    private Date lastModifyTime;//最后修改时间

    public String getChannelCode()
    {
        return this.channelCode;
    }

    public void setChannelCode(String channelCode)
    {
        this.channelCode = channelCode;
    }

    public String getChannelName()
    {
        return this.channelName;
    }

    public void setChannelName(String channelName)
    {
        this.channelName = channelName;
    }

    public String getParentChannelCode()
    {
        return this.parentChannelCode;
    }

    public void setParentChannelCode(String parentChannelCode)
    {
        this.parentChannelCode = parentChannelCode;
    }

    public Integer getSort()
    {
        return this.sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public Date getLastModifyTime()
    {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime)
    {
        this.lastModifyTime = lastModifyTime;
    }

}
