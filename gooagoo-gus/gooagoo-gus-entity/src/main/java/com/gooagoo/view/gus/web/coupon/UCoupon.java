package com.gooagoo.view.gus.web.coupon;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UCoupon implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证编号，UUID

    private String couponName;//优惠凭证名称

    private String shopId;//商家编号

    private String shopName;//商家名称

    private Image couponUrl;//优惠凭证图片URL

    private String visitUrl;//网站优惠凭证介绍地址

    private String objId;//营销Id

    public String getObjId()
    {
        return this.objId;
    }

    public void setObjId(String objId)
    {
        this.objId = objId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getVisitUrl()
    {
        return this.visitUrl;
    }

    public void setVisitUrl(String visitUrl)
    {
        this.visitUrl = visitUrl;
    }

    public String getCouponId()
    {
        return this.couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public String getCouponName()
    {
        return this.couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public Image getCouponUrl()
    {
        return this.couponUrl;
    }

    public void setCouponUrl(Image couponUrl)
    {
        this.couponUrl = couponUrl;
    }
}
