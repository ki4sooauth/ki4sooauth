package com.gooagoo.template.entity;

import java.io.Serializable;

/**
 * 商品销量
 */

public class FGoodsSalesRanking implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String goodsId;//商品编号，UUID
    private String positionName;//位置名称
    private String goodsName;//商品名称
    private String categoryLeafId;//品类编号（叶节点）
    private String categoryLeafName;//品类名称（叶节点）
    private String goodsImg;//商品图片url
    private String goodsPrice;//商品价格
    private String Sales;//销量

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

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

    public String getCategoryLeafId()
    {
        return this.categoryLeafId;
    }

    public void setCategoryLeafId(String categoryLeafId)
    {
        this.categoryLeafId = categoryLeafId;
    }

    public String getCategoryLeafName()
    {
        return this.categoryLeafName;
    }

    public void setCategoryLeafName(String categoryLeafName)
    {
        this.categoryLeafName = categoryLeafName;
    }

    public String getGoodsImg()
    {
        return this.goodsImg;
    }

    public void setGoodsImg(String goodsImg)
    {
        this.goodsImg = goodsImg;
    }

    public String getGoodsPrice()
    {
        return this.goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice)
    {
        this.goodsPrice = goodsPrice;
    }

    public String getSales()
    {
        return this.Sales;
    }

    public void setSales(String sales)
    {
        this.Sales = sales;
    }

    @Override
    public String toString()
    {
        return "GoodsSalesRanking [goodsId=" + this.goodsId + ", positionName=" + this.positionName + ", goodsName=" + this.goodsName + ", categoryLeafId=" + this.categoryLeafId + ", categoryLeafName=" + this.categoryLeafName + ", goodsImg=" + this.goodsImg + ", goodsPrice=" + this.goodsPrice + ", Sales=" + this.Sales + "]";
    }

}
