package com.gooagoo.view.gus.web.calendar;

import java.io.Serializable;

public class UShoppinglist implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String title;//购物清单的标题

    private String shoppingListId;//购物清单的id

    private String preShoppingTime;//预计购物时间

    public String getPreShoppingTime()
    {
        return this.preShoppingTime;
    }

    public void setPreShoppingTime(String preShoppingTime)
    {
        this.preShoppingTime = preShoppingTime;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getShoppingListId()
    {
        return this.shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

}
