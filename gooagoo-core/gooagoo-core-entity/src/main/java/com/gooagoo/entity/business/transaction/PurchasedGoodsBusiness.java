package com.gooagoo.entity.business.transaction;

import java.io.Serializable;

public class PurchasedGoodsBusiness implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String goodsId;//商品编号，UUID
    private String goodsName;//商品名称
    private String goodsImg;//商品主图URL
    private String shopId;//商家编号
    private String shopEntityId;//实体店编号
    private String shopName;//商家名称
    private String goodsNum;//商品数量
    private String payPrice;//实际支付单价
    private String requestTime;//消费时间

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

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
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

    public String getGoodsNum()
    {
        return this.goodsNum;
    }

    public void setGoodsNum(String goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getPayPrice()
    {
        return this.payPrice;
    }

    public void setPayPrice(String payPrice)
    {
        this.payPrice = payPrice;
    }

    public String getRequestTime()
    {
        return this.requestTime;
    }

    public void setRequestTime(String requestTime)
    {
        this.requestTime = requestTime;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    @Override
    public String toString()
    {
        return "PurchasedGoodsBusiness [goodsId=" + this.goodsId + ", goodsName=" + this.goodsName + ", goodsImg=" + this.goodsImg + ", shopId=" + this.shopId + ", shopEntityId=" + this.shopEntityId + ", shopName=" + this.shopName + ", goodsNum=" + this.goodsNum + ", payPrice=" + this.payPrice + ", requestTime=" + this.requestTime + "]";
    }

}
