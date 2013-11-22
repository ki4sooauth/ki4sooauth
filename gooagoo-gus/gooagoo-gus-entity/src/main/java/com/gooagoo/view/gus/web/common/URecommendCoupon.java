package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class URecommendCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证ID

    private String couponVisitUrl;//优惠凭证访问地址

    private String couponName;//优惠凭证名称

    private Image couponImage;//优惠凭证图片URL

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponVisitUrl()
    {
        return couponVisitUrl;
    }

    public void setCouponVisitUrl(String couponVisitUrl)
    {
        this.couponVisitUrl = couponVisitUrl;
    }

    public String getCouponName()
    {
        return couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public Image getCouponImage()
    {
        return couponImage;
    }

    public void setCouponImage(Image couponImage)
    {
        this.couponImage = couponImage;
    }

}
