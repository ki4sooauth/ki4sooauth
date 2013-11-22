package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

/**
 * 营销活动信息,在svg图上 的展示活动对象
 */
public class FActivityOnSvg implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name;//活动名称
    private String activityUrl;//活动图片URL
    private double px;// svg 图上的，x轴坐标
    private double py;// svg 图上的，y轴坐标

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getActivityUrl()
    {
        return this.activityUrl;
    }

    public void setActivityUrl(String activityUrl)
    {
        this.activityUrl = activityUrl;
    }

    public double getPx()
    {
        return this.px;
    }

    public void setPx(double px)
    {
        this.px = px;
    }

    public double getPy()
    {
        return this.py;
    }

    public void setPy(double py)
    {
        this.py = py;
    }
}
