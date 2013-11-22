package com.gooagoo.view.gus;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

/**
 * 优惠凭证
 * @author SPZ
 *
 */
public class UCoupon implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String couponId;//优惠凭证ID

    private String couponName;//优惠凭证名称

    private String couponLink;//优惠凭证链接

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

    public String getCouponLink()
    {
        return couponLink;
    }

    public void setCouponLink(String couponLink)
    {
        this.couponLink = couponLink;
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
        return this.ShopName;
    }

    public void setShopName(String shopName)
    {
        this.ShopName = shopName;
    }

    @Override
    public String toString()
    {
        return "UCoupon [couponId=" + couponId + ", couponName=" + couponName + ", couponLink=" + couponLink + ", couponImage=" + couponImage + ", shopId=" + shopId + ", ShopName=" + ShopName + "]";
    }

}
