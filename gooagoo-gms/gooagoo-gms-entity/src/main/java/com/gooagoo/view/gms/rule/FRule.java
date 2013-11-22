package com.gooagoo.view.gms.rule;

import java.io.Serializable;

/**
 * 规则信息
 * @author Administrator
 *
 */
public class FRule implements Serializable
{

    private static final long serialVersionUID = 1L;

    private FRuleInfo ruleInfo;

    private FRuleResult ruleResult;

    public FRuleInfo getRuleInfo()
    {
        return this.ruleInfo;
    }

    public void setRuleInfo(FRuleInfo ruleInfo)
    {
        this.ruleInfo = ruleInfo;
    }

    public FRuleResult getRuleResult()
    {
        return this.ruleResult;
    }

    public void setRuleResult(FRuleResult ruleResult)
    {
        this.ruleResult = ruleResult;
    }
}
