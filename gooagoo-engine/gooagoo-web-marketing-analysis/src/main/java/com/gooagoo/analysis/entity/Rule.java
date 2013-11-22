package com.gooagoo.analysis.entity;

import java.io.Serializable;

/**
 * 规则表，为事件、吆喝、通知、邮件、短信、积分、优惠、发卡制定发布规则。此表为发布规则的索引信息，发布规则的详细信息参考n
 */

public class Rule implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String ruleMatchType;//规则匹配类型

    public String getRuleMatchType()
    {
        return this.ruleMatchType;
    }

    public void setRuleMatchType(String ruleMatchType)
    {
        this.ruleMatchType = ruleMatchType;
    }

}
