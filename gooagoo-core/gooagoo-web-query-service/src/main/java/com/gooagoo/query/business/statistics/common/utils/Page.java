package com.gooagoo.query.business.statistics.common.utils;

public class Page
{
    private Integer start;
    private Integer end;

    public Page(Integer pageIndex, Integer pageSize)
    {
        if (pageIndex != null && pageSize != null)
        {
            this.start = pageIndex - 1 * pageSize;
            this.end = start + pageSize - 1;
        }
        else
        {
            this.start = 0;
            this.end = -1;
        }
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
