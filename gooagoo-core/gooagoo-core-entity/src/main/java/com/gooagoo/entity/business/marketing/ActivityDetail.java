package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.shop.ShopInfo;

public class ActivityDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private MarketingActivity marketingActivity;//活动信息

    private ShopInfo shopInfo;//商家信息

    public MarketingActivity getMarketingActivity()
    {
        return marketingActivity;
    }

    public void setMarketingActivity(MarketingActivity marketingActivity)
    {
        this.marketingActivity = marketingActivity;
    }

    public ShopInfo getShopInfo()
    {
        return shopInfo;
    }

    public void setShopInfo(ShopInfo shopInfo)
    {
        this.shopInfo = shopInfo;
    }

}
