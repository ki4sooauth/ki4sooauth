package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class URecommendGoods implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String goodsId;//商品ID

    private String goodsName;//商品名称

    private String goodsVisitUrl;//商品访问地址URL

    private Image goodsImage;//商品图片

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

    public String getGoodsVisitUrl()
    {
        return goodsVisitUrl;
    }

    public void setGoodsVisitUrl(String goodsVisitUrl)
    {
        this.goodsVisitUrl = goodsVisitUrl;
    }

    public Image getGoodsImage()
    {
        return goodsImage;
    }

    public void setGoodsImage(Image goodsImage)
    {
        this.goodsImage = goodsImage;
    }

}
