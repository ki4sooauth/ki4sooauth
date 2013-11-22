package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UFavoritePlaceActivity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String activityId;//id
    private String activityUrl;//链接
    private String activityName;//名称
    private Image imgUrl;//图片
    private String shopId;//商家id
    private String shopName;//商家名称

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getActivityUrl()
    {
        return this.activityUrl;
    }

    public void setActivityUrl(String activityUrl)
    {
        this.activityUrl = activityUrl;
    }

    public String getActivityName()
    {
        return this.activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public Image getImgUrl()
    {
        return this.imgUrl;
    }

    public void setImgUrl(Image imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

}
