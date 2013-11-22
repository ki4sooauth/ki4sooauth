package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销渠道
 */

public class MarketingChannel implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer channelCode;//营销渠道编码

    private String channelName;//营销渠道名称

    private Integer parentChannelCode;//父级编码

    private Integer sortOrder;//排序号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public Integer getChannelCode()
    {
        return this.channelCode;
    }

    public void setChannelCode(Integer channelCode)
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

    public Integer getParentChannelCode()
    {
        return this.parentChannelCode;
    }

    public void setParentChannelCode(Integer parentChannelCode)
    {
        this.parentChannelCode = parentChannelCode;
    }

    public Integer getSortOrder()
    {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
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
        return this.channelCode + "^" + this.channelName + "^" + this.parentChannelCode + "^" + this.sortOrder + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
