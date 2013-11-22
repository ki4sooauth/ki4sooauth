package com.gooagoo.view.gms.common;

import java.io.Serializable;

public class PageCondition implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String orderBy;//排序字段
    private int pageIndex; //起始页
    private int pageSize; //每页显示条数

    public PageCondition()
    {
        super();
    }

    public PageCondition(int pageIndex, int pageSize, String orderBy)
    {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }

    public String getOrderBy()
    {
        return this.orderBy;
    }

    public int getPageIndex()
    {
        return this.pageIndex;
    }

    public int getPageSize()
    {
        return this.pageSize;
    }

    public void setOrderBy(String orderBy)
    {
        this.orderBy = orderBy;
    }

    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    @Override
    public String toString()
    {
        return "PageInfo [orderBy=" + this.orderBy + ", pageIndex=" + this.pageIndex + ", pageSize=" + this.pageSize + "]";
    }

}
