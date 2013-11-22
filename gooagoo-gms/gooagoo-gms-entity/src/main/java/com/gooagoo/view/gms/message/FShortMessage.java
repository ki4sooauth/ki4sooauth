package com.gooagoo.view.gms.message;

import java.io.Serializable;
import java.util.Date;

/**
 * 短信信息
 * 
 */
public class FShortMessage implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String messageId;//短信编号，UUID

    private String shopId;//商家编号

    private String activityId;//活动编号

    private String messageTitle;//短信标题，用于审核和发布，不发送给用户

    private String content;//短信内容

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String ruleId;//发布规则编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getMessageId()
    {
        return this.messageId;
    }

    public void setMessageId(String messageId)
    {
        this.messageId = messageId;
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

    public String getMessageTitle()
    {
        return this.messageTitle;
    }

    public void setMessageTitle(String messageTitle)
    {
        this.messageTitle = messageTitle;
    }

    public String getContent()
    {
        return this.content;
    }

    public void setContent(String content)
    {
        this.content = content;
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
