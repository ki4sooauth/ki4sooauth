package com.gooagoo.analysis.entity;

import java.util.Map;

public class RuleData
{

    private static Map<String, Map<String, RuleMatch>> rule = null;//Map第一个key-shopId，Map第二个key-ruleId

    public static Map<String, Map<String, RuleMatch>> getRule()
    {
        return rule;
    }

    public static void setRule(Map<String, Map<String, RuleMatch>> rule)
    {
        RuleData.rule = rule;
    }

}
