package com.gooagoo.view.gus.web.shoppinglist;

import java.io.Serializable;
import java.util.Date;

public class UShoppinglist implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shoppingListId;//购物清单编号，UUID

    private String userId;//用户编号

    private String title;//购物清单标题

    private Date preShoppingTime;//预计购物时间

    public String getShoppingListId()
    {
        return shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getPreShoppingTime()
    {
        return preShoppingTime;
    }

    public void setPreShoppingTime(Date preShoppingTime)
    {
        this.preShoppingTime = preShoppingTime;
    }
    
    

}
