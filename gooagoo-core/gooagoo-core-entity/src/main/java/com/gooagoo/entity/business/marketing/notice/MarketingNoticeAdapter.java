package com.gooagoo.entity.business.marketing.notice;

import java.io.Serializable;

import com.gooagoo.entity.generator.marketing.MarketingUserLink;

public class MarketingNoticeAdapter implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 推送时间+营销内容与用户关联表主键  */
    private String pageId;

    /** 营销内容与用户关联表  */
    private MarketingUserLink marketingUserLink;

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

    @Override
    public String toString()
    {
        return "MarketingNoticeAdapter [pageId=" + this.pageId + ", marketingUserLink=" + this.marketingUserLink.toString() + "]";
    }

}
