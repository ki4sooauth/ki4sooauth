package com.gooagoo.entity.business.marketing.cryout;

import java.io.Serializable;
import java.util.List;

/**
 * 商家吆喝信息
 */
public class ShopCryout implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<ShopCryoutInfo> shopCryoutInfoList;

    public List<ShopCryoutInfo> getShopCryoutInfoList()
    {
        return this.shopCryoutInfoList;
    }

    public void setShopCryoutInfoList(List<ShopCryoutInfo> shopCryoutInfoList)
    {
        this.shopCryoutInfoList = shopCryoutInfoList;
    }

}
