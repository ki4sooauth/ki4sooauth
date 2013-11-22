package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 精品广场商品类型字典表
 */

public class QualitySquareGoodsTypeKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer goodsTypeId;//商品类型编号，自增长

    private String isDel;//是否删除，Y-已删除，N-未删除

    public Integer getGoodsTypeId()
    {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId)
    {
        this.goodsTypeId = goodsTypeId;
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
