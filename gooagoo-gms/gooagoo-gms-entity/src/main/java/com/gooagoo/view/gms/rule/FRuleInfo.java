package com.gooagoo.view.gms.rule;

import java.io.Serializable;
import java.util.Date;

/**
 * 发布规则信息表
 * @author Administrator
 *
 */
public class FRuleInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String ruleId;//规则编号，UUID

    private String ruleName;//规则名称

    private String shopId;//商家编号

    private String activityId;//活动编号

    private String ruleType;//规则类型，参考通用字典表的rule_type

    private String ruleActiveType;//规则生效类型，参考通用字典表的rule_active_type

    private String objectId;//规则对象编号，指事件、吆喝、通知等发布内容的编号

    private String isActiveForever;//是否永久生效，Y-是，N-否

    private Date startTime;//规则生效时间

    private Date endTime;//规则失效时间

    private String crowdType;//发布人群类型，0-历史人群，1-即时人群，2-两者全有

    private String isPublishImmediately;//是否立即发布，Y-是，N-否

    private Date expectPublishTime;//预期发布时间

    private Date actualPublishTime;//实际发布时间

    private String ruleContent;//规则内容，保存的是规则的json串

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    private Date startTime_FE;//规则生效时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date startTime_TE;//规则生效时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date endTime_FE;//规则失效时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date endTime_TE;//规则失效时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    public String getRuleId()
    {
        return this.ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getRuleName()
    {
        return this.ruleName;
    }

    public void setRuleName(String ruleName)
    {
        this.ruleName = ruleName;
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

    public String getRuleType()
    {
        return this.ruleType;
    }

    public void setRuleType(String ruleType)
    {
        this.ruleType = ruleType;
    }

    public String getRuleActiveType()
    {
        return this.ruleActiveType;
    }

    public void setRuleActiveType(String ruleActiveType)
    {
        this.ruleActiveType = ruleActiveType;
    }

    public String getObjectId()
    {
        return this.objectId;
    }

    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

    public String getIsActiveForever()
    {
        return this.isActiveForever;
    }

    public void setIsActiveForever(String isActiveForever)
    {
        this.isActiveForever = isActiveForever;
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

    public String getCrowdType()
    {
        return this.crowdType;
    }

    public void setCrowdType(String crowdType)
    {
        this.crowdType = crowdType;
    }

    public String getIsPublishImmediately()
    {
        return this.isPublishImmediately;
    }

    public void setIsPublishImmediately(String isPublishImmediately)
    {
        this.isPublishImmediately = isPublishImmediately;
    }

    public Date getExpectPublishTime()
    {
        return this.expectPublishTime;
    }

    public void setExpectPublishTime(Date expectPublishTime)
    {
        this.expectPublishTime = expectPublishTime;
    }

    public Date getActualPublishTime()
    {
        return this.actualPublishTime;
    }

    public void setActualPublishTime(Date actualPublishTime)
    {
        this.actualPublishTime = actualPublishTime;
    }

    public String getRuleContent()
    {
        return this.ruleContent;
    }

    public void setRuleContent(String ruleContent)
    {
        this.ruleContent = ruleContent;
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

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public Date getStartTime_FE()
    {
        return this.startTime_FE;
    }

    public void setStartTime_FE(Date startTime_FE)
    {
        this.startTime_FE = startTime_FE;
    }

    public Date getStartTime_TE()
    {
        return this.startTime_TE;
    }

    public void setStartTime_TE(Date startTime_TE)
    {
        this.startTime_TE = startTime_TE;
    }

    public Date getEndTime_FE()
    {
        return this.endTime_FE;
    }

    public void setEndTime_FE(Date endTime_FE)
    {
        this.endTime_FE = endTime_FE;
    }

    public Date getEndTime_TE()
    {
        return this.endTime_TE;
    }

    public void setEndTime_TE(Date endTime_TE)
    {
        this.endTime_TE = endTime_TE;
    }

}
