package com.gooagoo.view.gus.web.shop;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UShopList implements Serializable
{
    private static final long serialVersionUID = 3222054470845850119L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String shopName;//商家名称

    private String shopLogo;//商家logo

    private String color;//推荐背景色值

    private String startTime;//起始时间

    private String endTime;//结束时间

    private String cardId;//会员卡编号

    private String cardName;//会员卡名称

    private Image cardImg;//卡头图片

    private Integer shopType;//商家类类型

    private String shopUrl;//商家链接地址；

    private Integer useableIntegralNumber;//可用积分

    private Integer popularity;//人气

    private String cardType;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
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

    public String getShopLogo()
    {
        return this.shopLogo;
    }

    public void setShopLogo(String shopLogo)
    {
        this.shopLogo = shopLogo;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getCardId()
    {
        return this.cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getCardName()
    {
        return this.cardName;
    }

    public void setCardName(String cardName)
    {
        this.cardName = cardName;
    }

    public Image getCardImg()
    {
        return this.cardImg;
    }

    public void setCardImg(Image cardImg)
    {
        this.cardImg = cardImg;
    }

    public Integer getShopType()
    {
        return this.shopType;
    }

    public void setShopType(Integer shopType)
    {
        this.shopType = shopType;
    }

    public String getShopUrl()
    {
        return this.shopUrl;
    }

    public void setShopUrl(String shopUrl)
    {
        this.shopUrl = shopUrl;
    }

    public Integer getUseableIntegralNumber()
    {
        return this.useableIntegralNumber;
    }

    public void setUseableIntegralNumber(Integer useableIntegralNumber)
    {
        this.useableIntegralNumber = useableIntegralNumber;
    }

    public Integer getPopularity()
    {
        return this.popularity;
    }

    public void setPopularity(Integer popularity)
    {
        this.popularity = popularity;
    }

    public String getCardType()
    {
        return this.cardType;
    }

    public void setCardType(String cardType)
    {
        this.cardType = cardType;
    }

}
