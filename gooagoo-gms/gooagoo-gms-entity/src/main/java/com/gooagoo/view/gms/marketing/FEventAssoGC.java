package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

/**
 * 营销事件商品（优惠凭证）关联信息
 */
public class FEventAssoGC implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String eventId;//营销事件id
    private String activityId;//活动id
    private String shopId;//商家id
    private String shopEntityId;//商家实体店id
    private String goodscouponType;//关联类型（1-商品，2-优惠凭证）
    private String goodscouponId;//商品（优惠凭证）id
    private Integer sort;//排列顺序

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

    public String getGoodscouponType()
    {
        return this.goodscouponType;
    }

    public void setGoodscouponType(String goodscouponType)
    {
        this.goodscouponType = goodscouponType;
    }

    public String getGoodscouponId()
    {
        return this.goodscouponId;
    }

    public void setGoodscouponId(String goodscouponId)
    {
        this.goodscouponId = goodscouponId;
    }

    public Integer getSort()
    {
        return this.sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

}
