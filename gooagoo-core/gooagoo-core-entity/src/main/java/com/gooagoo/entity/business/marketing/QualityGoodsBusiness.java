package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

public class QualityGoodsBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String goodsId;//商品编号，UUID
    private String goodsName;//商品名称
    private String goodsImg;//商品图片URL，json串
    private String favnums;//收藏人数
    private String isfav;//是否收藏，Y-已收藏，N-未收藏

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

    public String getFavnums()
    {
        return this.favnums;
    }

    public void setFavnums(String favnums)
    {
        this.favnums = favnums;
    }

    public String getIsfav()
    {
        return this.isfav;
    }

    public void setIsfav(String isfav)
    {
        this.isfav = isfav;
    }

    @Override
    public String toString()
    {
        return "QualityGoodsBusiness [goodsId=" + this.goodsId + ", goodsName=" + this.goodsName + ", goodsImg=" + this.goodsImg + ", favnums=" + this.favnums + ", isfav=" + this.isfav + "]";
    }

}
