package com.gooagoo.analysis.entity;

import java.io.Serializable;

/**
 * 条件信息
 */
public class FRuleCondition implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String conditionType;//条件类型　0-历史条件、1-实时条件、2-历史+实时条件

    private FHistoryCondition historyCondition;//历史条件

    private FActionAttribute actionAttribute;//实时条件

    public String getConditionType()
    {
        return this.conditionType;
    }

    public void setConditionType(String conditionType)
    {
        this.conditionType = conditionType;
    }

    public FHistoryCondition getHistoryCondition()
    {
        return this.historyCondition;
    }

    public void setHistoryCondition(FHistoryCondition historyCondition)
    {
        this.historyCondition = historyCondition;
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
