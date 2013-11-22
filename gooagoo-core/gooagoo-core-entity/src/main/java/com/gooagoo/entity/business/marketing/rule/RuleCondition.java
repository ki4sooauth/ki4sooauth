package com.gooagoo.entity.business.marketing.rule;

import java.io.Serializable;

/**
 * 条件信息
 */
public class RuleCondition implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String conditionType;//条件类型 ，0-历史人群，1-即时人群，2-两者全有

    private HistoryCondition historyCondition;//历史条件

    private ActionAttribute actionAttribute;//实时条件

    public String getConditionType()
    {
        return this.conditionType;
    }

    public void setConditionType(String conditionType)
    {
        this.conditionType = conditionType;
    }

    public HistoryCondition getHistoryCondition()
    {
        return this.historyCondition;
    }

    public void setHistoryCondition(HistoryCondition historyCondition)
    {
        this.historyCondition = historyCondition;
    }

    public ActionAttribute getActionAttribute()
    {
        return this.actionAttribute;
    }

    public void setActionAttribute(ActionAttribute actionAttribute)
    {
        this.actionAttribute = actionAttribute;
    }

}
