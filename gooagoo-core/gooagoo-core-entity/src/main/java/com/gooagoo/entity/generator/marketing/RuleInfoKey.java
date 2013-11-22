package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 规则表，为事件、吆喝、通知、邮件、短信、积分、优惠、发卡制定发布规则。此表为发布规则的索引信息，发布规则的详细信息参考n
 */

public class RuleInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String ruleId;//规则编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getRuleId()
    {
        return ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
