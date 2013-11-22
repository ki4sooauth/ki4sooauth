package com.gooagoo.entity.generator.behave;

import java.io.Serializable;

/**
 * 购物清单主表
 */

public class UserShoppingPlanKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shoppingListId;//购物清单编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getShoppingListId()
    {
        return shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
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
