package com.gooagoo.entity.generator.goods;

import java.io.Serializable;

/**
 * 商品营销信息
 */

public class GoodsMarketingInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String goodsId;//商品编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
