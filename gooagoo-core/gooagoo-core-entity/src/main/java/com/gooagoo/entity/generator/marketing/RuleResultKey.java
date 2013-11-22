package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 规结果则表（包括积分规则结果，营销规则结果）
 */

public class RuleResultKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String ruleResultId;//规则结果编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getRuleResultId()
    {
        return ruleResultId;
    }

    public void setRuleResultId(String ruleResultId)
    {
        this.ruleResultId = ruleResultId;
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
