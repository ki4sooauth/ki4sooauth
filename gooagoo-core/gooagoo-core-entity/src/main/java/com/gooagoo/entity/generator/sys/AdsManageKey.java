package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 广告位管理
 */

public class AdsManageKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String bidId;//竞拍编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getBidId()
    {
        return bidId;
    }

    public void setBidId(String bidId)
    {
        this.bidId = bidId;
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
