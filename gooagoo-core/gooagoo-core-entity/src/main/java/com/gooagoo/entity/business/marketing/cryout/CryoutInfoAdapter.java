package com.gooagoo.entity.business.marketing.cryout;

import java.io.Serializable;

import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;

public class CryoutInfoAdapter implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 推送时间+营销内容与用户关联表主键  */
    private String pageId;

    /** 营销内容与用户关联表  */
    private MarketingUserLink marketingUserLink;

    /** 吆喝信息表  */
    private CryoutInfo cryoutInfo;

    public String getPageId()
    {
        return this.pageId;
    }

    public void setPageId(String pageId)
    {
        this.pageId = pageId;
    }

    public MarketingUserLink getMarketingUserLink()
    {
        return this.marketingUserLink;
    }

    public void setMarketingUserLink(MarketingUserLink marketingUserLink)
    {
        this.marketingUserLink = marketingUserLink;
    }

    public CryoutInfo getCryoutInfo()
    {
        return this.cryoutInfo;
    }

    public void setCryoutInfo(CryoutInfo cryoutInfo)
    {
        this.cryoutInfo = cryoutInfo;
    }

    @Override
    public String toString()
    {
        return "CryoutInfoAdapter [pageId=" + this.pageId + ", marketingUserLink=" + this.marketingUserLink.toString() + ", cryoutInfo=" + this.cryoutInfo.toString() + "]";
    }

}
