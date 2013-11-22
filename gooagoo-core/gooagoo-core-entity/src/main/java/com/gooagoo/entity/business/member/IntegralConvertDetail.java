package com.gooagoo.entity.business.member;

import java.io.Serializable;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.ShopIntegralConvert;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfo;

public class IntegralConvertDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private ShopIntegralConvert shopIntegralConvert;//积分兑换信息

    private GoodsBaseInfo goodsBaseInfo;//商品基本信息

    private GoodsMarketingInfo goodsMarketingInfo;//商品营销信息

    private Coupon coupon;//优惠凭证信息

    private ShopInfo shopInfo;//商家信息

    private ConsigneeInfo consigneeInfo;//收货地址信息

    public ShopIntegralConvert getShopIntegralConvert()
    {
        return shopIntegralConvert;
    }

    public void setShopIntegralConvert(ShopIntegralConvert shopIntegralConvert)
    {
        this.shopIntegralConvert = shopIntegralConvert;
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

    public ShopInfo getShopInfo()
    {
        return shopInfo;
    }

    public void setShopInfo(ShopInfo shopInfo)
    {
        this.shopInfo = shopInfo;
    }

    public ConsigneeInfo getConsigneeInfo()
    {
        return consigneeInfo;
    }

    public void setConsigneeInfo(ConsigneeInfo consigneeInfo)
    {
        this.consigneeInfo = consigneeInfo;
    }

}
