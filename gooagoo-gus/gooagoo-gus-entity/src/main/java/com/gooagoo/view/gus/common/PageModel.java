package com.gooagoo.view.gus.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页排序
 * @author GUS
 *
 * @param <T>
 */
public class PageModel<T> implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer pageIndex; //第几页

    private Integer pageSize; //每页条数

    private Integer count = 0; //总记录数

    private List<T> result = new ArrayList<T>();

    public Integer getPageIndex()
    {
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize()
    {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getCount()
    {
        return this.count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public List<T> getResult()
    {
        return this.result;
    }

    public void setResult(List<T> result)
    {
        this.result = result;
    }

    /**
     * 获取总页数
     * @return
     */
    public Integer getPages()
    {
        if (this.getPageSize() == 0)
        {
            return 0;
        }
        int c = this.getCount() - 1;
        if (c < 0)
        {
            c = 0;
        }
        Integer pages = (c / this.getPageSize() + 1);
        return pages;
    }

    /**
     * 数据库对应每页的起始下标值
     * @return
     */
    public Integer getIndex()
    {
        int index = 0;
        if (this.getPageSize() >= 1 && this.getPageIndex() >= 1)
        {
            index = (this.getPageIndex() - 1) * this.getPageSize();
        }
        return index;
    }

    /**
     * 显示页数开始页数
     * @return
     */
    public Integer getPageStart(int pageNum)
    {
        int start = 1;
        if (this.getPages() > pageNum)
        {
            start = this.getPageIndex() - pageNum;
            if (start < 1)
            {
                start = 1;
            }
        }
        return start;
    }

    /**
     * 显示页数结束页数
     * @return
     */
    public Integer getPageEnd(int pageNum)
    {
        int end = this.getPages();
        if (this.getPages() > pageNum)
        {
            end = this.getPageIndex() + pageNum;
            if (end > this.getPages())
            {
                end = this.getPages();
            }
        }
        return end;
    }

}
