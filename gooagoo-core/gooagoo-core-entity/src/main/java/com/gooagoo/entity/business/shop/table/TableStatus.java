package com.gooagoo.entity.business.shop.table;

import java.io.Serializable;

/**
 *  商家列表 
 */
public class TableStatus implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 餐桌编号  */
    private String tableName = "";

    /** 餐桌状态,1-空闲 2-点餐 3-正在结账  */
    private String deskStatus = "";

    /** 建议最小人数  */
    private String minNums = "";

    /** 建议最大人数  */
    private String maxNums = "";

    /** 当前状态出现时间  */
    private String mealTime = "";

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getDeskStatus()
    {
        return this.deskStatus;
    }

    public void setDeskStatus(String deskStatus)
    {
        this.deskStatus = deskStatus;
    }

    public String getMinNums()
    {
        return this.minNums;
    }

    public void setMinNums(String minNums)
    {
        this.minNums = minNums;
    }

    public String getMaxNums()
    {
        return this.maxNums;
    }

    public void setMaxNums(String maxNums)
    {
        this.maxNums = maxNums;
    }

    public String getMealTime()
    {
        return this.mealTime;
    }

    public void setMealTime(String mealTime)
    {
        this.mealTime = mealTime;
    }

    @Override
    public String toString()
    {
        return "TableStatus [tableName=" + this.tableName + ", deskStatus=" + this.deskStatus + ", minNums=" + this.minNums + ", maxNums=" + this.maxNums + ", mealTime=" + this.mealTime + "]";
    }

}
