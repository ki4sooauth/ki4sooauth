package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 营销渠道
 */

public class MarketingChannelKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer channelCode;//营销渠道编码

    private String isDel;//是否删除，Y-已删除，N-未删除

    public Integer getChannelCode()
    {
        return channelCode;
    }

    public void setChannelCode(Integer channelCode)
    {
        this.channelCode = channelCode;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
