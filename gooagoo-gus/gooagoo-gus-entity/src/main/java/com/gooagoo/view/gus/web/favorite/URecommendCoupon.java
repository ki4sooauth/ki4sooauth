package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;

public class URecommendCoupon implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证ID

    private String image;//优惠凭证图片

    private String couponName;//优惠凭证名称

    private String couponVisitUrl;//优惠凭证访问URL

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getImage()
    {
        return this.image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getCouponVisitUrl()
    {
        return this.couponVisitUrl;
    }

    public void setCouponVisitUrl(String couponVisitUrl)
    {
        this.couponVisitUrl = couponVisitUrl;
    }

    public String getCouponName()
    {
        return this.couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }
}
