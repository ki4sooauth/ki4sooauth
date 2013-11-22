package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.shop.ShopInfo;

public class CouponDetail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Coupon coupon;//优惠凭证信息

    private ShopInfo shopInfo;//商家信息

    private Integer couponReserveNum;//库存量

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

    public Integer getCouponReserveNum()
    {
        return couponReserveNum;
    }

    public void setCouponReserveNum(Integer couponReserveNum)
    {
        this.couponReserveNum = couponReserveNum;
    }

}
