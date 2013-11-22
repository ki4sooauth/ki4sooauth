package com.gooagoo.view.gus.web.merchant.mobile;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UActive implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String shopVisitUrl;//虚拟店铺访问地址

    private Image shopHeadPic;//商家头像

    private String activeId;//活动ID

    private Image activeImage;//活动图片

    private String activeName;//活动名称

    private String activeTitle;//活动主题

    private String activeDes;//活动描述

    private String activeStartTime;//活动开始时间

    private String activeEndTime;//活动结束时间

    private boolean favorite;//是否已收藏

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

    public String getShopVisitUrl()
    {
        return this.shopVisitUrl;
    }

    public void setShopVisitUrl(String shopVisitUrl)
    {
        this.shopVisitUrl = shopVisitUrl;
    }

    public Image getShopHeadPic()
    {
        return this.shopHeadPic;
    }

    public void setShopHeadPic(Image shopHeadPic)
    {
        this.shopHeadPic = shopHeadPic;
    }

    public String getActiveId()
    {
        return this.activeId;
    }

    public void setActiveId(String activeId)
    {
        this.activeId = activeId;
    }

    public Image getActiveImage()
    {
        return this.activeImage;
    }

    public void setActiveImage(Image activeImage)
    {
        this.activeImage = activeImage;
    }

    public String getActiveName()
    {
        return this.activeName;
    }

    public void setActiveName(String activeName)
    {
        this.activeName = activeName;
    }

    public String getActiveTitle()
    {
        return this.activeTitle;
    }

    public void setActiveTitle(String activeTitle)
    {
        this.activeTitle = activeTitle;
    }

    public String getActiveDes()
    {
        return this.activeDes;
    }

    public void setActiveDes(String activeDes)
    {
        this.activeDes = activeDes;
    }

    public String getActiveStartTime()
    {
        return this.activeStartTime;
    }

    public void setActiveStartTime(String activeStartTime)
    {
        this.activeStartTime = activeStartTime;
    }

    public String getActiveEndTime()
    {
        return this.activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime)
    {
        this.activeEndTime = activeEndTime;
    }

    public boolean isFavorite()
    {
        return this.favorite;
    }

    public void setFavorite(boolean favorite)
    {
        this.favorite = favorite;
    }
}
