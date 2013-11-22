package com.gooagoo.view.gus.web.merchant.web;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.view.gus.common.Image;

public class UGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String goodsId;//商品ID

    private String goodsName;//商品名称

    private List<Image> goodsImageList;//商品图片集合

    private String goodsPrice;//商品价格

    private Integer dayPopularity;//当天人气

    private Integer weekPopularity;//本周人气

    private String goodsCommentLevel;//商品评论星级

    private String goodsVendor;//商品供应商

    private String goodsAddress;//商品产地

    private List<USimpleGoodsInfo> otherSingleGoodsList;//其他单品

    private List<USimpleGoodsInfo> goodsCrossGoodsList;//交叉营销商品

    private List<USimpleGoodsInfo> goodsRelationGoodsList;//关联销售商品

    private List<USimpleGoodsInfo> goodsReplaceGoodsList;//可替换商品

    private String goodsUseMessage;//商品使用方法

    private String goodsContent;//商品推荐描述

    private String goodsSolution;//商品解决方案描述

    private String shopIntegralId;//积分营销ID

    private Integer convertIntegralValue;//兑换所需积分

    private boolean favorite;//是否已收藏

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

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public List<Image> getGoodsImageList()
    {
        return this.goodsImageList;
    }

    public void setGoodsImageList(List<Image> goodsImageList)
    {
        this.goodsImageList = goodsImageList;
    }

    public String getGoodsPrice()
    {
        return this.goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public Integer getDayPopularity()
    {
        return this.dayPopularity;
    }

    public void setDayPopularity(Integer dayPopularity)
    {
        this.dayPopularity = dayPopularity;
    }

    public Integer getWeekPopularity()
    {
        return this.weekPopularity;
    }

    public void setWeekPopularity(Integer weekPopularity)
    {
        this.weekPopularity = weekPopularity;
    }

    public String getGoodsCommentLevel()
    {
        return this.goodsCommentLevel;
    }

    public void setGoodsCommentLevel(String goodsCommentLevel)
    {
        this.goodsCommentLevel = goodsCommentLevel;
    }

    public String getGoodsVendor()
    {
        return this.goodsVendor;
    }

    public void setGoodsVendor(String goodsVendor)
    {
        this.goodsVendor = goodsVendor;
    }

    public String getGoodsAddress()
    {
        return this.goodsAddress;
    }

    public void setGoodsAddress(String goodsAddress)
    {
        this.goodsAddress = goodsAddress;
    }

    public List<USimpleGoodsInfo> getOtherSingleGoodsList()
    {
        return this.otherSingleGoodsList;
    }

    public void setOtherSingleGoodsList(List<USimpleGoodsInfo> otherSingleGoodsList)
    {
        this.otherSingleGoodsList = otherSingleGoodsList;
    }

    public List<USimpleGoodsInfo> getGoodsCrossGoodsList()
    {
        return this.goodsCrossGoodsList;
    }

    public void setGoodsCrossGoodsList(List<USimpleGoodsInfo> goodsCrossGoodsList)
    {
        this.goodsCrossGoodsList = goodsCrossGoodsList;
    }

    public List<USimpleGoodsInfo> getGoodsRelationGoodsList()
    {
        return this.goodsRelationGoodsList;
    }

    public void setGoodsRelationGoodsList(List<USimpleGoodsInfo> goodsRelationGoodsList)
    {
        this.goodsRelationGoodsList = goodsRelationGoodsList;
    }

    public List<USimpleGoodsInfo> getGoodsReplaceGoodsList()
    {
        return this.goodsReplaceGoodsList;
    }

    public void setGoodsReplaceGoodsList(List<USimpleGoodsInfo> goodsReplaceGoodsList)
    {
        this.goodsReplaceGoodsList = goodsReplaceGoodsList;
    }

    public String getGoodsUseMessage()
    {
        return this.goodsUseMessage;
    }

    public void setGoodsUseMessage(String goodsUseMessage)
    {
        this.goodsUseMessage = goodsUseMessage;
    }

    public String getGoodsContent()
    {
        return this.goodsContent;
    }

    public void setGoodsContent(String goodsContent)
    {
        this.goodsContent = goodsContent;
    }

    public String getGoodsSolution()
    {
        return this.goodsSolution;
    }

    public void setGoodsSolution(String goodsSolution)
    {
        this.goodsSolution = goodsSolution;
    }

    public String getShopIntegralId()
    {
        return this.shopIntegralId;
    }

    public void setShopIntegralId(String shopIntegralId)
    {
        this.shopIntegralId = shopIntegralId;
    }

    public Integer getConvertIntegralValue()
    {
        return this.convertIntegralValue;
    }

    public void setConvertIntegralValue(Integer convertIntegralValue)
    {
        this.convertIntegralValue = convertIntegralValue;
    }

    public boolean isFavorite()
    {
        return this.favorite;
    }

    public void setFavorite(boolean favorite)
    {
        this.favorite = favorite;
    }

}
