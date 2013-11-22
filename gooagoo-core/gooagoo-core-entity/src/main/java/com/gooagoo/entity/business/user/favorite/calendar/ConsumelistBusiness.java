package com.gooagoo.entity.business.user.favorite.calendar;

import java.io.Serializable;

public class ConsumelistBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 当日订单数目  */
    private Integer ordernum = 0;

    /** 当日账单数目  */
    private Integer billnum = 0;

    /** 当日活动数目 */
    private Integer activitynum = 0;

    /** 购物清单 数目 */
    private Integer shopinglistnum = 0;

    /**
     * 设置当日订单数目 
     * @param ordernum  当日订单数目 
     */
    public void setOrdernum(Integer ordernum)
    {
        this.ordernum = ordernum;
    }

    /**
     * 获取当日订单数目 
     * @return  当日订单数目 
     */
    public Integer getOrdernum()
    {
        return this.ordernum;
    }

    /**
     * 设置当日账单数目 
     * @param billnum   当日账单数目 
     */
    public void setBillnum(Integer billnum)
    {
        this.billnum = billnum;
    }

    /**
     * 获取当日账单数目 
     * @return  当日账单数目 
     */
    public Integer getBillnum()
    {
        return this.billnum;
    }

    /**
     * 设置当日活动数目
     * @param activitynum   当日活动数目
     */
    public void setActivitynum(Integer activitynum)
    {
        this.activitynum = activitynum;
    }

    /**
     * 获取当日活动数目
     * @return  当日活动数目 
     */
    public Integer getActivitynum()
    {
        return this.activitynum;
    }

    /**
     * 设置购物清单 数目
     * @param shopinglistnum    购物清单 数目
     */
    public void setShopinglistnum(Integer shopinglistnum)
    {
        this.shopinglistnum = shopinglistnum;
    }

    /**
     * 获取购物清单 数目
     * @return  购物清单 数目
     */
    public Integer getShopinglistnum()
    {
        return this.shopinglistnum;
    }

    @Override
    public String toString()
    {
        return "ConsumelistBusiness [ordernum=" + this.ordernum + ", billnum=" + this.billnum + ", activitynum=" + this.activitynum + ", shopinglistnum=" + this.shopinglistnum + "]";
    }

}
