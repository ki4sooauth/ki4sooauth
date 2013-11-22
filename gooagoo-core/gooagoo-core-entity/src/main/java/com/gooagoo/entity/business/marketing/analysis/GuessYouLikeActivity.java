package com.gooagoo.entity.business.marketing.analysis;

import java.io.Serializable;

public class GuessYouLikeActivity implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String activityId;//活动ID

    private String activityName;//活动名称

    private String activityImageUrl;//活动图片URL

    private String shopId;//商家ID

    private String ShopName;//商家名称

    public String getActivityId()
    {
        return activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getActivityImageUrl()
    {
        return activityImageUrl;
    }

    public void setActivityImageUrl(String activityImageUrl)
    {
        this.activityImageUrl = activityImageUrl;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return ShopName;
    }

    public void setShopName(String shopName)
    {
        ShopName = shopName;
    }

}
