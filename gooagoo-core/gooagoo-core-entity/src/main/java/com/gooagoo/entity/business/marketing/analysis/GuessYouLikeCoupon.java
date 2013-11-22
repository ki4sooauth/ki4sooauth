package com.gooagoo.entity.business.marketing.analysis;

import java.io.Serializable;

public class GuessYouLikeCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证ID

    private String couponName;//优惠凭证名称

    private String couponImageUrl;//优惠凭证图片URL

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

    public String getCouponImageUrl()
    {
        return couponImageUrl;
    }

    public void setCouponImageUrl(String couponImageUrl)
    {
        this.couponImageUrl = couponImageUrl;
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
