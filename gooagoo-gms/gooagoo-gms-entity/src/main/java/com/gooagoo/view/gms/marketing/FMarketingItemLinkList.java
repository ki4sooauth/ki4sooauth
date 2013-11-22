package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 营销内容与商品、活动、优惠凭证关联表
 */

public class FMarketingItemLinkList implements Serializable
{

    private static final long serialVersionUID = 1L;

    private List<String> marketingLinkType = new ArrayList<String>();
    private List<String> marketingLinkId = new ArrayList<String>();

    public List<String> getMarketingLinkType()
    {
        return this.marketingLinkType;
    }

    public void setMarketingLinkType(List<String> marketingLinkType)
    {
        this.marketingLinkType = marketingLinkType;
    }

    public List<String> getMarketingLinkId()
    {
        return this.marketingLinkId;
    }

    public void setMarketingLinkId(List<String> marketingLinkId)
    {
        this.marketingLinkId = marketingLinkId;
    }

}
