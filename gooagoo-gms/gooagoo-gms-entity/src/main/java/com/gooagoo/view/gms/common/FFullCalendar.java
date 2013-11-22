package com.gooagoo.view.gms.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FFullCalendar implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id;
    private List<String> mothNames = new ArrayList<String>();//月份显示名称（如：一月）
    private List<String> mothNamesShort = new ArrayList<String>();//月份显示名称简称（如：一月）
    private List<String> dayNames = new ArrayList<String>();//星期显示名称（如：周一）
    private List<String> dayNamesShort = new ArrayList<String>();//星期显示名称简称（如：周一）
    private List<String> today = new ArrayList<String>();//今日显示名称（如：今天）
    private Map<String, String> titleFormat = new HashMap<String, String>();//标题样式，map中的属性： month: 'yyyy M月'等
    private Map<String, String> buttonText = new HashMap<String, String>();//按钮显示文字，map中的属性：today: '今天', month: '月'等
    private List<Map<String, Object>> events = new ArrayList<Map<String, Object>>();//日期数据，map中的属性：title,start,end,allDay,id等
    private List<Map<String, String>> data = new ArrayList<Map<String, String>>();//按钮显示文字

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public List<String> getMothNames()
    {
        return this.mothNames;
    }

    public void setMothNames(List<String> mothNames)
    {
        this.mothNames = mothNames;
    }

    public List<String> getMothNamesShort()
    {
        return this.mothNamesShort;
    }

    public void setMothNamesShort(List<String> mothNamesShort)
    {
        this.mothNamesShort = mothNamesShort;
    }

    public List<String> getDayNames()
    {
        return this.dayNames;
    }

    public void setDayNames(List<String> dayNames)
    {
        this.dayNames = dayNames;
    }

    public List<String> getDayNamesShort()
    {
        return this.dayNamesShort;
    }

    public void setDayNamesShort(List<String> dayNamesShort)
    {
        this.dayNamesShort = dayNamesShort;
    }

    public List<String> getToday()
    {
        return this.today;
    }

    public void setToday(List<String> today)
    {
        this.today = today;
    }

    public Map<String, String> getTitleFormat()
    {
        return this.titleFormat;
    }

    public void setTitleFormat(Map<String, String> titleFormat)
    {
        this.titleFormat = titleFormat;
    }

    public Map<String, String> getButtonText()
    {
        return this.buttonText;
    }

    public void setButtonText(Map<String, String> buttonText)
    {
        this.buttonText = buttonText;
    }

    public List<Map<String, Object>> getEvents()
    {
        return this.events;
    }

    public void setEvents(List<Map<String, Object>> events)
    {
        this.events = events;
    }

    public List<Map<String, String>> getData()
    {
        return this.data;
    }

    public void setData(List<Map<String, String>> data)
    {
        this.data = data;
    }

}
