package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

/**
 * 营销事件用户关联信息
 */
public class FEventAssoUser implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String eventId;//营销事件id
    private String activityId;//活动id
    private String userId;//用户Id
    private String shopId;//商家id
    private String shopEntityId;//商家实体店id

    public String getEventId()
    {
        return this.eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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

}
