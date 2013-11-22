package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;

public class URecommendGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsId;//商品ID

    private String image;//商品图片

    private String goodsName;//商品名称

    private String goodsVisitUrl;//商品访问URL

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getImage()
    {
        return this.image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public String getGoodsVisitUrl()
    {
        return this.goodsVisitUrl;
    }

    public void setGoodsVisitUrl(String goodsVisitUrl)
    {
        this.goodsVisitUrl = goodsVisitUrl;
    }

}
