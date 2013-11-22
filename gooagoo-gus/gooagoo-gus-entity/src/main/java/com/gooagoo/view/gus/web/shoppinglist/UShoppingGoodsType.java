package com.gooagoo.view.gus.web.shoppinglist;

import java.io.Serializable;

public class UShoppingGoodsType implements Serializable
{
    private static final long serialVersionUID = 1L;

    private Integer goodsTypeId;//商品类型编号，自增长

    private String goodsTypeName;//商品类型名称

    private Integer parentGoodsTypeId;//上级类型编号，-1表示无上级

    public Integer getGoodsTypeId()
    {
        return this.goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId)
    {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName()
    {
        return this.goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName)
    {
        this.goodsTypeName = goodsTypeName;
    }

    public Integer getParentGoodsTypeId()
    {
        return this.parentGoodsTypeId;
    }

    public void setParentGoodsTypeId(Integer parentGoodsTypeId)
    {
        this.parentGoodsTypeId = parentGoodsTypeId;
    }
}
