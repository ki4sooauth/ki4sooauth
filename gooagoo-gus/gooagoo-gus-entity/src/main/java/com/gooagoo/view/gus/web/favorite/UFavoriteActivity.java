package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;
import java.util.Date;

import com.gooagoo.view.gus.common.Image;

public class UFavoriteActivity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String favoriteId;//收藏ID

    private String activityId;//活动ID

    private String shopName;//商家名称

    private String activityTitle;//活动标题

    private String activityName;//活动名称

    private String activityContent;//活动内容

    private String activityStartTime;//活动开始时间

    private String activityEndTime;//活动结束时间

    private Image image;//活动图片

    private String activityUrl;//活动详情链接地址

    private Date favoriteTime;//收藏时间

    public String getFavoriteId()
    {
        return this.favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getActivityTitle()
    {
        return this.activityTitle;
    }

    public void setActivityTitle(String activityTitle)
    {
        this.activityTitle = activityTitle;
    }

    public String getActivityName()
    {
        return this.activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getActivityContent()
    {
        return this.activityContent;
    }

    public void setActivityContent(String activityContent)
    {
        this.activityContent = activityContent;
    }

    public String getActivityStartTime()
    {
        return this.activityStartTime;
    }

    public void setActivityStartTime(String activityStartTime)
    {
        this.activityStartTime = activityStartTime;
    }

    public String getActivityEndTime()
    {
        return this.activityEndTime;
    }

    public void setActivityEndTime(String activityEndTime)
    {
        this.activityEndTime = activityEndTime;
    }

    public Image getImage()
    {
        return this.image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public String getActivityUrl()
    {
        return this.activityUrl;
    }

    public void setActivityUrl(String activityUrl)
    {
        this.activityUrl = activityUrl;
    }

    public Date getFavoriteTime()
    {
        return favoriteTime;
    }

    public void setFavoriteTime(Date favoriteTime)
    {
        this.favoriteTime = favoriteTime;
    }

}
