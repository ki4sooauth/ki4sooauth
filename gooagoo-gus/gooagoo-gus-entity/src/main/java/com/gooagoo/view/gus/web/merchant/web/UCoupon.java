package com.gooagoo.view.gus.web.merchant.web;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UCoupon implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String shopVisitUrl;//虚拟店铺访问

    private Image shopHeadPic;//商家头像

    private String couponId;//优惠凭证ID

    private Image couponImage;//优惠凭证图片

    private String couponValue;//立省：代金额度/折扣率

    private String couponType;//优惠凭证类型：代金券/折扣券

    private Integer popularity;//人气

    private Integer couponStockNum;//库存量

    private String couponName;//优惠凭证名称

    private String couponContent;//优惠凭证内容

    private String couponChannel;//优惠凭证发布渠道

    private String shopIntegralId;//积分营销ID

    private Integer convertIntegralValue;//兑换所需积分值

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
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopVisitUrl()
    {
        return shopVisitUrl;
    }

    public void setShopVisitUrl(String shopVisitUrl)
    {
        this.shopVisitUrl = shopVisitUrl;
    }

    public Image getShopHeadPic()
    {
        return shopHeadPic;
    }

    public void setShopHeadPic(Image shopHeadPic)
    {
        this.shopHeadPic = shopHeadPic;
    }

    public String getCouponId()
    {
        return couponId;
    }

    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }

    public Image getCouponImage()
    {
        return couponImage;
    }

    public void setCouponImage(Image couponImage)
    {
        this.couponImage = couponImage;
    }

    public String getCouponValue()
    {
        return couponValue;
    }

    public void setCouponValue(String couponValue)
    {
        this.couponValue = couponValue;
    }

    public String getCouponType()
    {
        return couponType;
    }

    public void setCouponType(String couponType)
    {
        this.couponType = couponType;
    }

    public Integer getPopularity()
    {
        return popularity;
    }

    public void setPopularity(Integer popularity)
    {
        this.popularity = popularity;
    }

    public Integer getCouponStockNum()
    {
        return couponStockNum;
    }

    public void setCouponStockNum(Integer couponStockNum)
    {
        this.couponStockNum = couponStockNum;
    }

    public String getCouponName()
    {
        return couponName;
    }

    public void setCouponName(String couponName)
    {
        this.couponName = couponName;
    }

    public String getCouponContent()
    {
        return couponContent;
    }

    public void setCouponContent(String couponContent)
    {
        this.couponContent = couponContent;
    }

    public String getCouponChannel()
    {
        return couponChannel;
    }

    public void setCouponChannel(String couponChannel)
    {
        this.couponChannel = couponChannel;
    }

    public String getShopIntegralId()
    {
        return shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
    }

    public Integer getConvertIntegralValue()
    {
        return convertIntegralValue;
    }

    public void setConvertIntegralValue(Integer convertIntegralValue)
    {
        this.convertIntegralValue = convertIntegralValue;
    }

}
