package com.gooagoo.entity.business.system.bid;

import java.io.Serializable;

import com.gooagoo.entity.generator.sys.AdsManage;
import com.gooagoo.entity.generator.sys.ShopAd;
import com.gooagoo.entity.generator.sys.ShopBid;

/**
 * 竞拍详细信息
 */
public class BidDetailInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String clickNums;//点击次数
    private ShopBid shopBid;//商家竞拍信息
    private ShopAd shopAd;//广告位信息
    private AdsManage adsManage;//广告位管理

    public String getClickNums()
    {
        return this.clickNums;
    }

    public void setClickNums(String clickNums)
    {
        this.clickNums = clickNums;
    }

    public ShopBid getShopBid()
    {
        return this.shopBid;
    }

    public void setShopBid(ShopBid shopBid)
    {
        this.shopBid = shopBid;
    }

    public ShopAd getShopAd()
    {
        return this.shopAd;
    }

    public void setShopAd(ShopAd shopAd)
    {
        this.shopAd = shopAd;
    }

    public AdsManage getAdsManage()
    {
        return this.adsManage;
    }

    public void setAdsManage(AdsManage adsManage)
    {
        this.adsManage = adsManage;
    }

    @Override
    public String toString()
    {
        return "BidDetailInfo [clickNums=" + this.clickNums + ", shopBid=" + this.shopBid.toString() + ", shopAd=" + this.shopAd.toString() + ", adsManage=" + this.adsManage.toString() + "]";
    }

}
