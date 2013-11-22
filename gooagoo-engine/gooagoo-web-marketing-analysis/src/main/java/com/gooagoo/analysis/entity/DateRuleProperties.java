package com.gooagoo.analysis.entity;

import java.io.Serializable;
import java.util.Date;

public class DateRuleProperties implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int eventWeek;
    private Date eventTime;
    private Date eventDate;

    public int getEventWeek()
    {
        return this.eventWeek;
    }

    public void setEventWeek(int eventWeek)
    {
        this.eventWeek = eventWeek;
    }

    public Date getEventTime()
    {
        return this.eventTime;
    }

    public void setEventTime(Date eventTime)
    {
        this.eventTime = eventTime;
    }

    public Date getEventDate()
    {
        return this.eventDate;
    }

    public void setEventDate(Date eventDate)
    {
        this.eventDate = eventDate;
    }

}
