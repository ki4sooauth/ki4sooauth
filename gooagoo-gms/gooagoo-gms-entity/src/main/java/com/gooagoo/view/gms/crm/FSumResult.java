package com.gooagoo.view.gms.crm;

import java.io.Serializable;

public class FSumResult implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String timeValue; // 统计时间
    private Double sumValue; // 统计结果

    public String getTimeValue()
    {
        return this.timeValue;
    }

    public void setTimeValue(String timeValue)
    {
        this.timeValue = timeValue;
    }

    public Double getSumValue()
    {
        return this.sumValue;
    }

    public void setSumValue(Double sumValue)
    {
        this.sumValue = sumValue;
    }
}
