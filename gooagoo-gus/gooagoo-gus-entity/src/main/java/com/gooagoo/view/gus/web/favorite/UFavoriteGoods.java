package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;
import java.util.Date;

import com.gooagoo.view.gus.common.Image;

public class UFavoriteGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String favoriteId;//收藏ID

    private String goodsId;//商品ID

    private String shopName;//商家名称

    private String goodsCategoryName;//商品类别

    private String goodsBrandName;//商品品牌

    private String goodsName;//商品名称

    private String goodsPrice;//价格

    private String goodsDiscountPrice;//优惠价格

    private Image image;//商品图片

    private String address;//产地

    private String goodsUrl;//商品详情链接地址

    private Date favoriteTime;//收藏时间

    public String getFavoriteId()
    {
        return this.favoriteId;
    }

    public void setFavoriteId(String favoriteId)
    {
        this.favoriteId = favoriteId;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getGoodsCategoryName()
    {
        return this.goodsCategoryName;
    }

    public void setGoodsCategoryName(String goodsCategoryName)
    {
        this.goodsCategoryName = goodsCategoryName;
    }

    public String getGoodsBrandName()
    {
        return this.goodsBrandName;
    }

    public void setGoodsBrandName(String goodsBrandName)
    {
        this.goodsBrandName = goodsBrandName;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsPrice()
    {
        return this.goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDiscountPrice()
    {
        return this.goodsDiscountPrice;
    }

    public void setGoodsDiscountPrice(String goodsDiscountPrice)
    {
        this.goodsDiscountPrice = goodsDiscountPrice;
    }

    public Image getImage()
    {
        return this.image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getGoodsUrl()
    {
        return this.goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl)
    {
        this.goodsUrl = goodsUrl;
    }

    public Date getFavoriteTime()
    {
        return favoriteTime;
    }

    public void setFavoriteTime(Date favoriteTime)
    {
        this.favoriteTime = favoriteTime;
    }

}
