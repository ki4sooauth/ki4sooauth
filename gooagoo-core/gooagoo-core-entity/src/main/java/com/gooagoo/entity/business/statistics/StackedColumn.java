package com.gooagoo.entity.business.statistics;

public class StackedColumn
{
    /**
     * X轴标签名称
     */
    private String xLable;

    /**
     * Y轴分组名称
     */
    private String yCategory;

    /**
     * Y轴分组值
     */
    private long value;

    public String getxLable()
    {
        return this.xLable;
    }

    public void setxLable(String xLable)
    {
        this.xLable = xLable;
    }

    public String getyCategory()
    {
        return this.yCategory;
    }

    public void setyCategory(String yCategory)
    {
        this.yCategory = yCategory;
    }

    public long getValue()
    {
        return this.value;
    }

    public void setValue(long value)
    {
        this.value = value;
    }
}
