package com.gooagoo.view.gus.web.favorite;

import java.io.Serializable;

public class URecommendActivity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String activityId;//活动ID

    private String image;//活动图片

    private String activityName;//活动名称

    private String activityVisitUrl;//活动访问URL

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getImage()
    {
        return this.image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getActivityVisitUrl()
    {
        return this.activityVisitUrl;
    }

    public void setActivityVisitUrl(String activityVisitUrl)
    {
        this.activityVisitUrl = activityVisitUrl;
    }

    public String getActivityName()
    {
        return this.activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }
}
