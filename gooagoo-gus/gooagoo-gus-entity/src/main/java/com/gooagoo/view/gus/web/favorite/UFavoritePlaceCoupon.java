package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UFavoritePlaceCoupon implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String couponId;//id
    private Image couponimg;//图片
    private String couponName;//名称
    private String couponUrl;//链接
    private String shopId;//商家id
    private String shopName;//商家名称

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public Image getCouponimg()
    {
        return this.couponimg;
    }

    public void setCouponimg(Image couponimg)
    {
        this.couponimg = couponimg;
    }

    public String getCouponName()
    {
        return this.couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public String getCouponUrl()
    {
        return this.couponUrl;
    }

    public void setCouponUrl(String couponUrl)
    {
        this.couponUrl = couponUrl;
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
