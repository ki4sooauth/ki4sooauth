package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动表
 */

public class MarketingActivity implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String activityId;//活动编号，UUID

    private String shopId;//商家编号

    private String activityName;//活动名称

    private String title;//活动主题

    private Date startTime;//活动开始时间

    private Date endTime;//活动结束时间

    private String imgUrl;//活动图片URL

    private String content;//活动内容

    private String purpose;//活动目的

    private String description;//活动描述

    private String templateId;//模板编号

    private String templateData;//'模板数据，保存的是html代码'

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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

    public String getImgUrl()
    {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getPurpose()
    {
        return this.purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateData()
    {
        return this.templateData;
    }

    public void setTemplateData(String templateData)
    {
        this.templateData = templateData;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
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

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.activityId + "^" + this.shopId + "^" + this.activityName + "^" + this.title + "^" + this.startTime + "^" + this.endTime + "^" + this.imgUrl + "^" + this.content + "^" + this.purpose + "^" + this.description + "^" + this.templateId + "^" + this.templateData + "^" + this.publishStatus + "^" + this.auditNote + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
