package com.gooagoo.view.gms.crm;

import java.io.Serializable;

/**
 * 
 * CRM 查询条件信息
 *
 */
public class FSumCondition implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 查询用户类别
     * 全部用户  1
     * 到访用户  2
     * 新增用户  3
     * 全部会员  4
     * 新增会员  5
     * 到访会员  6
     * 活跃会员  7
     * 沉默会员  8
     * 流失会员  9
     */
    private String userType;// 用户类型
    private String shopId;// 商家id
    private String shopEntityId;// 实体店id
    private String positionId;//位置id
    /**
     * 查询时间列表
     * 年 Y
     * 月 M
     * 周 W
     * 日 D
     * 时 H
     */
    private String timeType;//时间类型

    public String getUserType()
    {
        return this.userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
    }

    public String getTimeType()
    {
        return this.timeType;
    }

    public void setTimeType(String timeType)
    {
        this.timeType = timeType;
    }
}
