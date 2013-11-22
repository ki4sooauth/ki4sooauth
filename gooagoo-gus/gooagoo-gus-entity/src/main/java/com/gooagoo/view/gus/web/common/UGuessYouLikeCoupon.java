package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UGuessYouLikeCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证ID

    private String couponName;//优惠凭证名称

    private String couponVisitUrl;//优惠凭证访问地址URL

    private Image couponImage;//优惠凭证图片

    private String shopId;//商家ID

    private String ShopName;//商家名称

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponName()
    {
        return couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public String getCouponVisitUrl()
    {
        return couponVisitUrl;
    }

    public void setCouponVisitUrl(String couponVisitUrl)
    {
        this.couponVisitUrl = couponVisitUrl;
    }

    public Image getCouponImage()
    {
        return couponImage;
    }

    public void setCouponImage(Image couponImage)
    {
        this.couponImage = couponImage;
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
