package com.gooagoo.view.gus.web.calendar;

import java.io.Serializable;

public class UActivity implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String title;//活动的标题

    private String startDate;//开始时间

    private String endDate;//结束时间

    private String url;//活动的访问地址

    public String getUrl()
    {
        return this.url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getStartDate()
    {
        return this.startDate;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getEndDate()
    {
        return this.endDate;
    }

    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
    }

}
