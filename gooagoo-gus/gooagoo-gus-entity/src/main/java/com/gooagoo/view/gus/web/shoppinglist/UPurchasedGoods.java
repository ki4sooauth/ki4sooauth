package com.gooagoo.view.gus.web.shoppinglist;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UPurchasedGoods implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String goodsName;//商家名称
    private String shopName;//商家名称
    private String time;//购买日期
    private String payPice;//价格
    private String marketingLinkId;
    private String shopId;//商家id
    private String goodsId;//商品id
    private String goodsNum;//商品数量
    private String goodsUrl;//图片访问的地址
    private Image goodsImg; //图片

    public String getGoodsNum()
    {
        return this.goodsNum;
    }

    public void setGoodsNum(String goodsNum)
    {
        this.goodsNum = goodsNum;
    }

    public String getGoodsUrl()
    {
        return this.goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl)
    {
        this.goodsUrl = goodsUrl;
    }

    public Image getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(Image goodsImg)
    {
        this.goodsImg = goodsImg;
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

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getTime()
    {
        return this.time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

    public String getPayPice()
    {
        return this.payPice;
    }

    public void setPayPice(String payPice)
    {
        this.payPice = payPice;
    }

    public String getMarketingLinkId()
    {
        return this.marketingLinkId;
    }

    public void setMarketingLinkId(String marketingLinkId)
    {
        this.marketingLinkId = marketingLinkId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

}
