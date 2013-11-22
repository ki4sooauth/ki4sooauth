package com.gooagoo.core.business.statistics.common.utils;

public class Page
{
    private int pageIndex;
    private int pageSize;
    private int start;
    private int end;

    public Page(int pageIndex, int pageSize)
    {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.start = pageIndex - 1 * pageSize;
        this.end = start + pageSize - 1;
    }

    public int getStart()
    {
        return start;
    }

    public int getEnd()
    {
        return end;
    }
}
