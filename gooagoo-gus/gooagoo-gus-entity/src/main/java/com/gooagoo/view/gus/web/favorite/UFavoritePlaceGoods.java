package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UFavoritePlaceGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsId;//id
    private Image goodsimg;//图片
    private String goodsName;//名称
    private String goodsUrl;//链接
    private String shopId;//商家id
    private String shopName;//商家名称

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public Image getGoodsimg()
    {
        return this.goodsimg;
    }

    public void setGoodsimg(Image goodsimg)
    {
        this.goodsimg = goodsimg;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsUrl()
    {
        return this.goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl)
    {
        this.goodsUrl = goodsUrl;
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

}
