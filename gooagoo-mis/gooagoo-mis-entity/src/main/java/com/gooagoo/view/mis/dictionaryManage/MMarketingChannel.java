package com.gooagoo.view.mis.dictionaryManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销渠道字典表
 * @author Administrator
 *
 */
public class MMarketingChannel implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer channelCode;// 营销渠道编码
    private String channelName;// 营销渠道名称
    private Integer parentChannelCode;// 父级编码
    private Integer sortOrder;// 排序号
    private String isDel;// 是否删除，Y-已删除，N-未删除
    private Date createTime;// 创建时间
    private Date cTimeStamp;// 最后一次修改时间

    public Integer getChannelCode()
    {
        return channelCode;
    }

    public void setChannelCode(Integer channelCode)
    {
        this.channelCode = channelCode;
    }

    public String getChannelName()
    {
        return channelName;
    }

    public void setChannelName(String channelName)
    {
        this.channelName = channelName;
    }

    public Integer getParentChannelCode()
    {
        return parentChannelCode;
    }

    public void setParentChannelCode(Integer parentChannelCode)
    {
        this.parentChannelCode = parentChannelCode;
    }

    public Integer getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
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

}
