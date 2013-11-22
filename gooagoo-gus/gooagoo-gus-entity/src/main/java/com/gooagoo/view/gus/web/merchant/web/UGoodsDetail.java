package com.gooagoo.view.gus.web.merchant.web;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class UGoodsDetail implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsId;//商品ID

    private String visitUrl;//访问地址

    private Image imageUrl;//图片URL

    private String price;//价格

    private Integer weekPopularity;//本周人气

    private String name;//菜名

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getVisitUrl()
    {
        return this.visitUrl;
    }

    public void setVisitUrl(String visitUrl)
    {
        this.visitUrl = visitUrl;
    }

    public Image getImageUrl()
    {
        return this.imageUrl;
    }

    public void setImageUrl(Image imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getPrice()
    {
        return this.price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public Integer getWeekPopularity()
    {
        return this.weekPopularity;
    }

    public void setWeekPopularity(Integer weekPopularity)
    {
        this.weekPopularity = weekPopularity;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
