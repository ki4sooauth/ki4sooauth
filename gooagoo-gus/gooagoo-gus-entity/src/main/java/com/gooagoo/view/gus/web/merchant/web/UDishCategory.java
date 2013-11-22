package com.gooagoo.view.gus.web.merchant.web;

import java.io.Serializable;

public class UDishCategory implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//品类编号

    private String Name;//品类名称

    private Integer dishCount;//商品总数

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public Integer getDishCount()
    {
        return this.dishCount;
    }

    public void setDishCount(Integer dishCount)
    {
        this.dishCount = dishCount;
    }

}
