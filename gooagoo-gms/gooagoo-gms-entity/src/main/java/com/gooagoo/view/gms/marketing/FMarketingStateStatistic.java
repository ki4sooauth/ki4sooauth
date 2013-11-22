package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

/**
 * 营销状态统计信息
 *
 */
public class FMarketingStateStatistic implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String shopId;//商家Id
    private String activityId;//活动id
    private String sumType;// 统计来源（总体、app、web）
    private Integer sumValue;// 统计人数
    private String timeValue;// 统计时间
    private String timeType;// 时间类型
    private String goodsId ;//商品ID
    private String entityId ;//实体店编号
    private String actType ;//行为类型
    private String categoryId ;//品类ID
    private String brandId ;//品牌Id
    private String couponId ;//优惠凭证Id
    private String eventId ;//事件Id
    private String cryoutId ;//吆喝Id
    private String noticeId ;//通知Id
    private String toolId ;//服务工具Id
    public String getShopId()
    {
        return shopId;
    }
    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }
    public String getActivityId()
    {
        return activityId;
    }
    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }
    public String getSumType()
    {
        return sumType;
    }
    public void setSumType(String sumType)
    {
        this.sumType = sumType;
    }
    public Integer getSumValue()
    {
        return sumValue;
    }
    public void setSumValue(Integer sumValue)
    {
        this.sumValue = sumValue;
    }
    public String getTimeValue()
    {
        return timeValue;
    }
    public void setTimeValue(String timeValue)
    {
        this.timeValue = timeValue;
    }
    public String getTimeType()
    {
        return timeType;
    }
    public void setTimeType(String timeType)
    {
        this.timeType = timeType;
    }
    public String getGoodsId()
    {
        return goodsId;
    }
    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }
    public String getEntityId()
    {
        return entityId;
    }
    public void setEntityId(String entityId)
    {
        this.entityId = entityId;
    }
    public String getActType()
    {
        return actType;
    }
    public void setActType(String actType)
    {
        this.actType = actType;
    }
    public String getCategoryId()
    {
        return categoryId;
    }
    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }
    public String getBrandId()
    {
        return brandId;
    }
    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }
    public String getCouponId()
    {
        return couponId;
    }
    public void setCouponId(String couponId)
    {
        this.couponId = couponId;
    }
    public String getEventId()
    {
        return eventId;
    }
    public void setEventId(String eventId)
    {
        this.eventId = eventId;
    }
    public String getCryoutId()
    {
        return cryoutId;
    }
    public void setCryoutId(String cryoutId)
    {
        this.cryoutId = cryoutId;
    }
    public String getNoticeId()
    {
        return noticeId;
    }
    public void setNoticeId(String noticeId)
    {
        this.noticeId = noticeId;
    }
    public String getToolId()
    {
        return toolId;
    }
    public void setToolId(String toolId)
    {
        this.toolId = toolId;
    }
    
    
}
