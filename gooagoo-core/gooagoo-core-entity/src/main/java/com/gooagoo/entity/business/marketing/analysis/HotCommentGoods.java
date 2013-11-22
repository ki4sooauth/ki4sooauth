package com.gooagoo.entity.business.marketing.analysis;

import java.io.Serializable;

public class HotCommentGoods implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String goodsId;//商品ID

    private String goodsName;//商品名称

    private String goodsImageUrl;//商品图片URL

    private String shopId;//商家ID

    private String ShopName;//商家名称

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsImageUrl()
    {
        return goodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl)
    {
        this.goodsImageUrl = goodsImageUrl;
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
        return ShopName;
    }

    public void setShopName(String shopName)
    {
        ShopName = shopName;
    }

}
