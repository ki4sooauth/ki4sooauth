package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;
import java.util.Date;

import com.gooagoo.view.gus.common.Image;

public class UFavoriteCoupon implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String favoriteId;//收藏ID

    private String couponId;//优惠凭证ID

    private String shopName;//商家昵称

    private String couponType;//优惠凭证类型

    private String couponValue;//折扣/金额/次数

    private String couponContent;//优惠凭证描述

    private String couponimg;//优惠凭证的图片

    private String couponUrl;//优惠劵详情链接

    private String couponStatus;//优惠凭证状态

    private Date couponStartTime;//优惠开始时间

    private Date couponEndTime;//优惠结束时间

    private Image image;//优惠凭证图片

    private String couponName;//优惠凭证名称

    private Date favoriteTime;//收藏时间

    public String getFavoriteId()
    {
        return favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getCouponType()
    {
        return couponType;
    }

    public void setCouponType(String couponType)
    {
        this.couponType = couponType;
    }

    public String getCouponValue()
    {
        return couponValue;
    }

    public void setCouponValue(String couponValue)
    {
        this.couponValue = couponValue;
    }

    public String getCouponContent()
    {
        return couponContent;
    }

    public void setCouponContent(String couponContent)
    {
        this.couponContent = couponContent;
    }

    public String getCouponimg()
    {
        return couponimg;
    }

    public void setCouponimg(String couponimg)
    {
        this.couponimg = couponimg;
    }

    public String getCouponUrl()
    {
        return couponUrl;
    }

    public void setCouponUrl(String couponUrl)
    {
        this.couponUrl = couponUrl;
    }

    public String getCouponStatus()
    {
        return couponStatus;
    }

    public void setCouponStatus(String couponStatus)
    {
        this.couponStatus = couponStatus;
    }

    public Date getCouponStartTime()
    {
        return couponStartTime;
    }

    public void setCouponStartTime(Date couponStartTime)
    {
        this.couponStartTime = couponStartTime;
    }

    public Date getCouponEndTime()
    {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime)
    {
        this.couponEndTime = couponEndTime;
    }

    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public String getCouponName()
    {
        return couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
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
