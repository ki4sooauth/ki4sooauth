package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销事件信息
 */
public class FEvent implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String eventId;//事件编号，UUID

    private String shopId;//商家编号

    private String activityId;//活动编号

    private String eventName;//事件名称

    private String eventTarget;//目的

    private String channelRoot;//模板渠道编码（根节点）

    private String channelLeaf;//模板渠道编码（叶节点）

    private String templateId;//模板编号

    private String channelLeafName;//-事件发布渠道名称（叶节点）

    private String channelName;//事件发布渠道名称

    private String templateHtml;//模板HTML

    private String templateData;//模板数据，保存的是json串

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String ruleId;//发布规则编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getEventId()
    {
        return this.eventId;
    }

    public void setEventId(String eventId)
    {
        this.eventId = eventId;
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

    public String getEventName()
    {
        return this.eventName;
    }

    public void setEventName(String eventName)
    {
        this.eventName = eventName;
    }

    public String getEventTarget()
    {
        return this.eventTarget;
    }

    public void setEventTarget(String eventTarget)
    {
        this.eventTarget = eventTarget;
    }

    public String getChannelRoot()
    {
        return this.channelRoot;
    }

    public void setChannelRoot(String channelRoot)
    {
        this.channelRoot = channelRoot;
    }

    public String getChannelLeaf()
    {
        return this.channelLeaf;
    }

    public void setChannelLeaf(String channelLeaf)
    {
        this.channelLeaf = channelLeaf;
    }

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getChannelLeafName()
    {
        return this.channelLeafName;
    }

    public void setChannelLeafName(String channelLeafName)
    {
        this.channelLeafName = channelLeafName;
    }

    public String getChannelName()
    {
        return this.channelName;
    }

    public void setChannelName(String channelName)
    {
        this.channelName = channelName;
    }

    public String getTemplateHtml()
    {
        return this.templateHtml;
    }

    public void setTemplateHtml(String templateHtml)
    {
        this.templateHtml = templateHtml;
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
