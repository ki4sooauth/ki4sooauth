package com.gooagoo.view.gus.web.merchant.mobile;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UGoods implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String shopVisitUrl;//虚拟店铺访问店铺

    private Image shopHeadPic;//商家头像

    private String shopEntityAddressId;//实体店所在位置ID

    private String shopEntityAddressName;//实体店所在位置名称

    private String shopEntityPhone;//实体店联系电话

    private String goodsId;//商品ID

    private Image goodsImage;//商品图片

    private String goodsBrandName;//商品品牌名称

    private String goodsName;//商品名称

    private String goodsCommentLevel;//商品评论星级

    private String goodsPrice;//商品价格

    private String goodsDes;//商品描述

    private String shopIntegralId;//积分营销ID

    private Integer convertIntegralValue;//兑换所需积分

    private boolean favorite;//是否已收藏

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
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopVisitUrl()
    {
        return shopVisitUrl;
    }

    public void setShopVisitUrl(String shopVisitUrl)
    {
        this.shopVisitUrl = shopVisitUrl;
    }

    public Image getShopHeadPic()
    {
        return shopHeadPic;
    }

    public void setShopHeadPic(Image shopHeadPic)
    {
        this.shopHeadPic = shopHeadPic;
    }

    public String getShopEntityAddressId()
    {
        return shopEntityAddressId;
    }

    public void setShopEntityAddressId(String shopEntityAddressId)
    {
        this.shopEntityAddressId = shopEntityAddressId;
    }

    public String getShopEntityAddressName()
    {
        return shopEntityAddressName;
    }

    public void setShopEntityAddressName(String shopEntityAddressName)
    {
        this.shopEntityAddressName = shopEntityAddressName;
    }

    public String getShopEntityPhone()
    {
        return shopEntityPhone;
    }

    public void setShopEntityPhone(String shopEntityPhone)
    {
        this.shopEntityPhone = shopEntityPhone;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public Image getGoodsImage()
    {
        return goodsImage;
    }

    public void setGoodsImage(Image goodsImage)
    {
        this.goodsImage = goodsImage;
    }

    public String getGoodsBrandName()
    {
        return goodsBrandName;
    }

    public void setGoodsBrandName(String goodsBrandName)
    {
        this.goodsBrandName = goodsBrandName;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsCommentLevel()
    {
        return goodsCommentLevel;
    }

    public void setGoodsCommentLevel(String goodsCommentLevel)
    {
        this.goodsCommentLevel = goodsCommentLevel;
    }

    public String getGoodsPrice()
    {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDes()
    {
        return goodsDes;
    }

    public void setGoodsDes(String goodsDes)
    {
        this.goodsDes = goodsDes;
    }

    public String getShopIntegralId()
    {
        return shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
    }

    public Integer getConvertIntegralValue()
    {
        return convertIntegralValue;
    }

    public void setConvertIntegralValue(Integer convertIntegralValue)
    {
        this.convertIntegralValue = convertIntegralValue;
    }

    public boolean isFavorite()
    {
        return favorite;
    }

    public void setFavorite(boolean favorite)
    {
        this.favorite = favorite;
    }

}
