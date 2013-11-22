package com.gooagoo.view.gms.rule;

import java.io.Serializable;
import java.util.Date;

/**
 * 规则结果信息
 * @author Administrator
 *
 */
public class FRuleResult implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String ruleResultId;//规则结果编号，UUID

    private String activityId;//活动编号

    private Double addConsumeMoney;//追加金额：规则结果

    private String ruleResultType;//规则结果类型：参见表sys_dictionary

    private String ruleResultValue;//规则结果：积分/金额/商品ID

    private String ruleResultName;//规则结果名称，当规则结果类型为商品或优惠凭证时，为商品或优惠凭证的名称

    private String ruleDesc;//规则描述，用文字描述规则内容，便于给用户展示

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String ruleId;//发布规则编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getRuleResultId()
    {
        return this.ruleResultId;
    }

    public void setRuleResultId(String ruleResultId)
    {
        this.ruleResultId = ruleResultId;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public Double getAddConsumeMoney()
    {
        return this.addConsumeMoney;
    }

    public void setAddConsumeMoney(Double addConsumeMoney)
    {
        this.addConsumeMoney = addConsumeMoney;
    }

    public String getRuleResultType()
    {
        return this.ruleResultType;
    }

    public void setRuleResultType(String ruleResultType)
    {
        this.ruleResultType = ruleResultType;
    }

    public String getRuleResultValue()
    {
        return this.ruleResultValue;
    }

    public void setRuleResultValue(String ruleResultValue)
    {
        this.ruleResultValue = ruleResultValue;
    }

    public String getRuleResultName()
    {
        return this.ruleResultName;
    }

    public void setRuleResultName(String ruleResultName)
    {
        this.ruleResultName = ruleResultName;
    }

    public String getRuleDesc()
    {
        return this.ruleDesc;
    }

    public void setRuleDesc(String ruleDesc)
    {
        this.ruleDesc = ruleDesc;
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
