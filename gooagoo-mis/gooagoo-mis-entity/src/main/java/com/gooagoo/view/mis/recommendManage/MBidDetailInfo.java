package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;

import com.gooagoo.view.mis.recommendManage.MAdsManage;
import com.gooagoo.view.mis.recommendManage.MShopAd;

/**
 * 竞拍详细信息
 */
public class MBidDetailInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private MShopBid shopBid;//商家竞拍信息
    private MShopAd shopAd;//广告位信息
    private MAdsManage adsManage;//广告位管理

    public MShopBid getShopBid()
    {
        return shopBid;
    }

    public void setShopBid(MShopBid shopBid)
    {
        this.shopBid = shopBid;
    }

    public MShopAd getShopAd()
    {
        return shopAd;
    }

    public void setShopAd(MShopAd shopAd)
    {
        this.shopAd = shopAd;
    }

    public MAdsManage getAdsManage()
    {
        return adsManage;
    }

    public void setAdsManage(MAdsManage adsManage)
    {
        this.adsManage = adsManage;
    }

}
