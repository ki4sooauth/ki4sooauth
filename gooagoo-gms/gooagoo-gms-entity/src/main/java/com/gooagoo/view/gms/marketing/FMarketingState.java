package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

/**
 * 营销状态信息
 *
 */
public class FMarketingState implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String shopId;//商家Id
    private String activityId;//活动id
    private String sumType;// 统计来源（总体、app、web）
    private Integer sumValue;// 统计人数
    private String timeValue;// 统计时间
    private String timeType;// 时间类型

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getSumType()
    {
        return this.sumType;
    }

    public void setSumType(String sumType)
    {
        this.sumType = sumType;
    }

    public Integer getSumValue()
    {
        return this.sumValue;
    }

    public void setSumValue(Integer sumValue)
    {
        this.sumValue = sumValue;
    }

    public String getTimeValue()
    {
        return this.timeValue;
    }

    public void setTimeValue(String sumTime)
    {
        this.timeValue = sumTime;
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
