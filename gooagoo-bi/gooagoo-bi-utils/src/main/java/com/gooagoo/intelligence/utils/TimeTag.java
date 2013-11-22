package com.gooagoo.intelligence.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTag
{
    private final String year;
    private final String month;
    private final String week;
    private final String day;
    private final String hour;
    private final long currentTimeMillis;

    public TimeTag()
    {
        DecimalFormat df = new DecimalFormat("00");
        Calendar now = Calendar.getInstance();
        this.year = String.valueOf(now.get(Calendar.YEAR));
        this.month = df.format(now.get(Calendar.MONTH) + 1);
        this.day = df.format(now.get(Calendar.DAY_OF_MONTH));
        this.hour = df.format(now.get(Calendar.HOUR_OF_DAY));

        now.setFirstDayOfWeek(Calendar.MONDAY);
        now.setMinimalDaysInFirstWeek(7);
        this.week = df.format(now.get(Calendar.WEEK_OF_YEAR));
        this.currentTimeMillis = System.currentTimeMillis();
    }

    public TimeTag(Date time)
    {
        DecimalFormat df = new DecimalFormat("00");
        Calendar now = Calendar.getInstance();
        now.setTime(time);
        this.year = String.valueOf(now.get(Calendar.YEAR));
        this.month = df.format(now.get(Calendar.MONTH) + 1);
        this.day = df.format(now.get(Calendar.DAY_OF_MONTH));
        this.hour = df.format(now.get(Calendar.HOUR_OF_DAY));

        now.setFirstDayOfWeek(Calendar.MONDAY);
        now.setMinimalDaysInFirstWeek(7);
        this.week = df.format(now.get(Calendar.WEEK_OF_YEAR));
        this.currentTimeMillis = System.currentTimeMillis();
    }

    /**
     * 
     * @param time 格式yyyy-MM-dd
     */
    public TimeTag(String time)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("00");
        Calendar now = Calendar.getInstance();
        try
        {
            now.setTime(sdf.parse(time));
        }
        catch (Exception e)
        {
        }
        this.year = String.valueOf(now.get(Calendar.YEAR));
        this.month = df.format(now.get(Calendar.MONTH) + 1);
        this.day = df.format(now.get(Calendar.DAY_OF_MONTH));
        this.hour = df.format(now.get(Calendar.HOUR_OF_DAY));

        now.setFirstDayOfWeek(Calendar.MONDAY);
        now.setMinimalDaysInFirstWeek(7);
        this.week = df.format(now.get(Calendar.WEEK_OF_YEAR));
        this.currentTimeMillis = System.currentTimeMillis();
    }

    public String year()
    {
        return "_Y" + this.year;
    }

    public String month()
    {
        return "M" + this.month;
    }

    public String week()
    {
        return "W" + this.week;
    }

    public String day()
    {
        return "D" + this.day;
    }

    public String hour()
    {
        return "H" + this.hour;
    }

    public String getYear()
    {
        return this.year;
    }

    public String getMonth()
    {
        return this.month;
    }

    public String getWeek()
    {
        return this.week;
    }

    public String getDay()
    {
        return this.day;
    }

    public String getHour()
    {
        return this.hour;
    }

    public long timestamp()
    {
        return this.currentTimeMillis;
    }
}
