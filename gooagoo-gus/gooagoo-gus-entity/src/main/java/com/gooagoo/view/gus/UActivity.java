package com.gooagoo.view.gus;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

/**
 * 活动
 * @author SPZ
 *
 */
public class UActivity implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String activityId;//活动ID

    private String activityName;//活动名称

    private String activityLink;//活动链接

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

    public String getActivityLink()
    {
        return activityLink;
    }

    public void setActivityLink(String activityLink)
    {
        this.activityLink = activityLink;
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
        return this.ShopName;
    }

    public void setShopName(String shopName)
    {
        this.ShopName = shopName;
    }

    @Override
    public String toString()
    {
        return "UActivity [activityId=" + activityId + ", activityName=" + activityName + ", activityLink=" + activityLink + ", activityImage=" + activityImage + ", shopId=" + shopId + ", ShopName=" + ShopName + "]";
    }

}
