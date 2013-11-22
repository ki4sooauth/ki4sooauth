package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 营销活动表
 */

public class MarketingActivityKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String activityId;//活动编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getActivityId()
    {
        return activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
