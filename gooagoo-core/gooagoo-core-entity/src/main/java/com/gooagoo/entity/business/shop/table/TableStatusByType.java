package com.gooagoo.entity.business.shop.table;

import java.io.Serializable;

/**
 *  商家列表 
 */
public class TableStatusByType implements Serializable
{

    private static final long serialVersionUID = 1L;

    /**订单编号*/
    private String orderid;

    /** 餐桌类型编码  */
    private String tabletypecode;

    /** 餐桌名称 */
    private String tableName;

    /** 餐桌状态,1-空闲 2-点餐 3-正在结账  */
    private String tableStatus;

    /**餐桌上客户类型 0-会员 1-非会员*/
    private String isvip;

    /**如果是会员，则表示会员卡号*/
    private String scardno;

    /**HH:MM:SS用户提交订单时间*/
    private String userordertime;

    /** 用户总共点菜总数  */
    private String dishesnum;

    /** 已上菜品数  */
    private String ischecknum;

    /** 未上菜品数  */
    private String notchecknum;

    /** 用户用餐时长  */
    private String mealtime;

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableStatus()
    {
        return this.tableStatus;
    }

    public void setTableStatus(String tableStatus)
    {
        this.tableStatus = tableStatus;
    }

    public String getDishesnum()
    {
        return this.dishesnum;
    }

    public void setDishesnum(String dishesnum)
    {
        this.dishesnum = dishesnum;
    }

    public String getIschecknum()
    {
        return this.ischecknum;
    }

    public void setIschecknum(String ischecknum)
    {
        this.ischecknum = ischecknum;
    }

    public String getNotchecknum()
    {
        return this.notchecknum;
    }

    public void setNotchecknum(String notchecknum)
    {
        this.notchecknum = notchecknum;
    }

    public String getMealtime()
    {
        return this.mealtime;
    }

    public void setMealtime(String mealtime)
    {
        this.mealtime = mealtime;
    }

    public String getTabletypecode()
    {
        return this.tabletypecode;
    }

    public void setTabletypecode(String tabletypecode)
    {
        this.tabletypecode = tabletypecode;
    }

    public String getIsvip()
    {
        return this.isvip;
    }

    public void setIsvip(String isvip)
    {
        this.isvip = isvip;
    }

    public String getOrderid()
    {
        return this.orderid;
    }

    public void setOrderid(String orderid)
    {
        this.orderid = orderid;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getUserordertime()
    {
        return this.userordertime;
    }

    public void setUserordertime(String userordertime)
    {
        this.userordertime = userordertime;
    }

    @Override
    public String toString()
    {
        return "TableStatusByType [orderid=" + this.orderid + ", tabletypecode=" + this.tabletypecode + ", tableName=" + this.tableName + ", tableStatus=" + this.tableStatus + ", isvip=" + this.isvip + ", scardno=" + this.scardno + ", userordertime=" + this.userordertime + ", dishesnum=" + this.dishesnum + ", ischecknum=" + this.ischecknum + ", notchecknum=" + this.notchecknum + ", mealtime=" + this.mealtime + "]";
    }

}
