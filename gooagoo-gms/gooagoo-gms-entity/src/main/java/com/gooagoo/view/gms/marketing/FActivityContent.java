package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 *
 */
public class FActivityContent implements Serializable
{

    /**
     * 营销活动内容实体类
     */
    private static final long serialVersionUID = 1L;

    private String id;//活动内容编号

    private String contentType;//活动类型，0-事件、1-吆喝 、2-通知、3-短信 

    private String channelCode;//

    private String shopId;//商家编号

    private String activityId;//活动id

    private String activityName;//活动名称

    private String title;//内容标题

    private String contentUrl;//事件访问路径

    private String publishStatus;//状态（审核与发布）

    private String ruleId;//发布规则编号

    private String isDel;//是否删除,Y-是、N-否

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getContentType()
    {
        return this.contentType;
    }

    public void setContentType(String contentType)
    {
        this.contentType = contentType;
    }

    public String getChannelCode()
    {
        return this.channelCode;
    }

    public void setChannelCode(String channelCode)
    {
        this.channelCode = channelCode;
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

    public String getContentUrl()
    {
        return this.contentUrl;
    }

    public void setContentUrl(String contentUrl)
    {
        this.contentUrl = contentUrl;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public String getRuleId()
    {
        return this.ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
