package com.gooagoo.entity.business.user;

import java.io.Serializable;

import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.shop.ShopInfo;

/**
 * 用户收藏详细信息
 */

public class FavoriteInfoDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private FavoriteInfo favoriteInfo;//收藏信息

    private ShopInfo shopInfo;//商家信息

    private GoodsBaseInfo goodsBaseInfo;//商品基本信息

    private GoodsMarketingInfo goodsMarketingInfo;//商品营销信息

    private Coupon coupon;//优惠凭证信息

    private MarketingActivity marketingActivity;//活动信息

    public FavoriteInfo getFavoriteInfo()
    {
        return favoriteInfo;
    }

    public void setFavoriteInfo(FavoriteInfo favoriteInfo)
    {
        this.favoriteInfo = favoriteInfo;
    }

    public ShopInfo getShopInfo()
    {
        return shopInfo;
    }

    public void setShopInfo(ShopInfo shopInfo)
    {
        this.shopInfo = shopInfo;
    }

    public GoodsBaseInfo getGoodsBaseInfo()
    {
        return goodsBaseInfo;
    }

    public void setGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo)
    {
        this.goodsBaseInfo = goodsBaseInfo;
    }

    public GoodsMarketingInfo getGoodsMarketingInfo()
    {
        return goodsMarketingInfo;
    }

    public void setGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo)
    {
        this.goodsMarketingInfo = goodsMarketingInfo;
    }

    public Coupon getCoupon()
    {
        return coupon;
    }

    public void setCoupon(Coupon coupon)
    {
        this.coupon = coupon;
    }

    public MarketingActivity getMarketingActivity()
    {
        return marketingActivity;
    }

    public void setMarketingActivity(MarketingActivity marketingActivity)
    {
        this.marketingActivity = marketingActivity;
    }

}
