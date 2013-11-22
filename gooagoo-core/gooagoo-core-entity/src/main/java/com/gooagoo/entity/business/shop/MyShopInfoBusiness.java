package com.gooagoo.entity.business.shop;

import java.io.Serializable;

public class MyShopInfoBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

    private Integer shopTypeRoot;//商家类型

    private String shopName;//商家名称

    private String shopPopularity;//商家人气/满座率

    private String myCardId;//我的会员卡编号

    private String myCardType2;//我的会员卡类型

    private String myCardName;//我的会员卡名称

    private String myCardImageUrl;//我的会员卡图片

    private Integer myUseableIntegralNumber;//我的可用积分值

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public Integer getShopTypeRoot()
    {
        return shopTypeRoot;
    }

    public void setShopTypeRoot(Integer shopTypeRoot)
    {
        this.shopTypeRoot = shopTypeRoot;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopPopularity()
    {
        return shopPopularity;
    }

    public void setShopPopularity(String shopPopularity)
    {
        this.shopPopularity = shopPopularity;
    }

    public String getMyCardId()
    {
        return myCardId;
    }

    public void setMyCardId(String myCardId)
    {
        this.myCardId = myCardId;
    }

    public String getMyCardType2()
    {
        return myCardType2;
    }

    public void setMyCardType2(String myCardType2)
    {
        this.myCardType2 = myCardType2;
    }

    public String getMyCardName()
    {
        return myCardName;
    }

    public void setMyCardName(String myCardName)
    {
        this.myCardName = myCardName;
    }

    public String getMyCardImageUrl()
    {
        return myCardImageUrl;
    }

    public void setMyCardImageUrl(String myCardImageUrl)
    {
        this.myCardImageUrl = myCardImageUrl;
    }

    public Integer getMyUseableIntegralNumber()
    {
        return myUseableIntegralNumber;
    }

    public void setMyUseableIntegralNumber(Integer myUseableIntegralNumber)
    {
        this.myUseableIntegralNumber = myUseableIntegralNumber;
    }

}
