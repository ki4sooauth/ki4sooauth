package com.gooagoo.view.mis.recommendManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 推荐活动
 */
public class MNominateActivityBusiness implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//推荐活动表自动编号
    private String shopId;//推荐活动表商家编号
    private String activityId;//推荐活动表活动编号
    private Date startTime;//推荐活动表起始时间
    private Date endTime;//推荐活动表结束时间
    private Date nominateActivityCTimeStamp;//推荐活动表更新时间
    private String shopName;//商家信息表商家名称
    private String activityName;//营销活动表活动名称
    private String title;//营销活动表活动主题
    private Date activityStartTime;//营销活动表活动开始时间
    private Date activityEndTime;//营销活动表活动结束时间
    private Date marketingActivityCTimeStamp;//营销活动表状态更新时间
    private String isNominate;//活动信息表是否推荐（非数据库字段）Y-推荐，N-不推荐
    private String publishStatus;//活动状态

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

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

    public Date getStartTime()
    {
        return this.startTime;
    }

    public void setStartTime(Date startTime)
    {
        this.startTime = startTime;
    }

    public Date getEndTime()
    {
        return this.endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public Date getNominateActivityCTimeStamp()
    {
        return this.nominateActivityCTimeStamp;
    }

    public void setNominateActivityCTimeStamp(Date nominateActivityCTimeStamp)
    {
        this.nominateActivityCTimeStamp = nominateActivityCTimeStamp;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getActivityName()
    {
        return this.activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getActivityStartTime()
    {
        return this.activityStartTime;
    }

    public void setActivityStartTime(Date activityStartTime)
    {
        this.activityStartTime = activityStartTime;
    }

    public Date getActivityEndTime()
    {
        return this.activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime)
    {
        this.activityEndTime = activityEndTime;
    }

    public Date getMarketingActivityCTimeStamp()
    {
        return this.marketingActivityCTimeStamp;
    }

    public void setMarketingActivityCTimeStamp(Date marketingActivityCTimeStamp)
    {
        this.marketingActivityCTimeStamp = marketingActivityCTimeStamp;
    }

    public String getIsNominate()
    {
        return this.isNominate;
    }

    public void setIsNominate(String isNominate)
    {
        this.isNominate = isNominate;
    }

    public String getPublishStatus()
    {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    @Override
    public String toString()
    {
        return "NominateActivityBusiness [id=" + this.id + ", shopId=" + this.shopId + ", activityId=" + this.activityId + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", nominateActivityCTimeStamp=" + this.nominateActivityCTimeStamp + ", shopName=" + this.shopName + ", activityName=" + this.activityName + ", title=" + this.title + ", activityStartTime=" + this.activityStartTime + ", activityEndTime=" + this.activityEndTime + ", marketingActivityCTimeStamp=" + this.marketingActivityCTimeStamp + ", isNominate=" + this.isNominate + "]";
    }

}
