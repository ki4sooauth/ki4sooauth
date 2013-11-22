package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UGuessYouLikeActivity implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String activityId;//活动ID

    private String activityName;//活动名称

    private String activityVisitUrl;//活动访问地址URL

    private Image activityImage;//活动图片

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

    public String getActivityVisitUrl()
    {
        return activityVisitUrl;
    }

    public void setActivityVisitUrl(String activityVisitUrl)
    {
        this.activityVisitUrl = activityVisitUrl;
    }

    public Image getActivityImage()
    {
        return activityImage;
    }

    public void setActivityImage(Image activityImage)
    {
        this.activityImage = activityImage;
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
