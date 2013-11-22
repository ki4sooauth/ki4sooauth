package com.gooagoo.entity.business.shop.table;

import java.io.Serializable;

/**
 *  商家列表 
 */
public class TableDiningStatus implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 餐桌名称 */
    private String tableName = "";

    /** 餐桌类型名称  */
    private String tableTypeName = "";

    /** 餐桌类型编号  */
    private String tabletypecode = "";

    /** 餐桌上客户类型 0-会员 1-非会员  */
    private String memberType = "";

    /** 会员卡音频编号  */
    private String scardno = "";

    /** 餐桌状态,1-空闲 2-点餐 3-正在结账  */
    private String tableStatus = "";

    /**用户提交订单时间*/
    private String userordertime = "";

    /** 用户用餐时长 ，格式为: HH:mm:ss */
    private String mealtime = "";

    public String getTabletypecode()
    {
        return this.tabletypecode;
    }

    public void setTabletypecode(String tabletypecode)
    {
        this.tabletypecode = tabletypecode;
    }

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getTableTypeName()
    {
        return this.tableTypeName;
    }

    public void setTableTypeName(String tableTypeName)
    {
        this.tableTypeName = tableTypeName;
    }

    public String getMemberType()
    {
        return this.memberType;
    }

    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }

    public String getScardno()
    {
        return this.scardno;
    }

    public void setScardno(String scardno)
    {
        this.scardno = scardno;
    }

    public String getTableStatus()
    {
        return this.tableStatus;
    }

    public void setTableStatus(String tableStatus)
    {
        this.tableStatus = tableStatus;
    }

    public String getMealtime()
    {
        return this.mealtime;
    }

    public void setMealtime(String mealtime)
    {
        this.mealtime = mealtime;
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
        return "TableDiningStatus [tableName=" + this.tableName + ", tableTypeName=" + this.tableTypeName + ", tabletypecode=" + this.tabletypecode + ", memberType=" + this.memberType + ", scardno=" + this.scardno + ", tableStatus=" + this.tableStatus + ", userordertime=" + this.userordertime + ", mealtime=" + this.mealtime + "]";
    }

}
