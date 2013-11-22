package com.gooagoo.view.gus.web.merchant.mobile;

import java.io.Serializable;

public class UPositionMarketingRank implements Serializable
{
    private static final long serialVersionUID = 5249262812604339049L;

    private String positionName;//位置名称

    private String goodsName;//商品名称

    private String goodsPrice;//商品价格

    private String goodsVisitUrl;//商品访问地址

    private Integer sales;//商品被购买次数(销量)

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
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

    public String getGoodsVisitUrl()
    {
        return this.goodsVisitUrl;
    }

    public void setGoodsVisitUrl(String goodsVisitUrl)
    {
        this.goodsVisitUrl = goodsVisitUrl;
    }

    public Integer getSales()
    {
        return this.sales;
    }

    public void setSales(Integer sales)
    {
        this.sales = sales;
    }

}
