package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 购物清单商品表
 */

public class ShoppingPlanGoodsKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shoppingGoodsId;//购物清单详细编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShoppingGoodsId()
    {
        return shoppingGoodsId;
    }

    public void setShoppingGoodsId(String shoppingGoodsId)
    {
        this.shoppingGoodsId = shoppingGoodsId;
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
