package com.gooagoo.mobile.common.entity;

import java.io.Serializable;

public class GoodsInfoEntity implements Serializable
{

    /**
     * 商品信息
     */
    private static final long serialVersionUID = 1L;

    public String goodsId;//商品编号

    public Integer goodsnum;//商品数量

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public Integer getGoodsnum()
    {
        return this.goodsnum;
    }

    public void setGoodsnum(Integer goodsnum)
    {
        this.goodsnum = goodsnum;
    }

    @Override
    public String toString()
    {
        return "GoodsInfoEntity [goodsId=" + this.goodsId + ", goodsnum=" + this.goodsnum + "]";
    }

}
