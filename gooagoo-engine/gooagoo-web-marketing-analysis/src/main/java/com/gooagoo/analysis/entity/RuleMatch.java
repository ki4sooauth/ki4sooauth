package com.gooagoo.analysis.entity;

import java.io.Serializable;

import com.gooagoo.entity.generator.marketing.RuleInfo;

public class RuleMatch implements Serializable
{
    private static final long serialVersionUID = 1L;

    private RuleInfo ruleInfo;//发布规则

    private FActionAttribute actionAttribute;//实时条件;

    public RuleInfo getRuleInfo()
    {
        return this.ruleInfo;
    }

    public void setRuleInfo(RuleInfo ruleInfo)
    {
        this.ruleInfo = ruleInfo;
    }

    public FActionAttribute getActionAttribute()
    {
        return this.actionAttribute;
    }

    public void setActionAttribute(FActionAttribute actionAttribute)
    {
        this.actionAttribute = actionAttribute;
    }

}
