package com.gooagoo.entity.business.marketing.activity;

import java.io.Serializable;

/**
 *  活动列表 
 */
public class ActivitylistBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 活动分类名称，当前只有一种，“当日活动”  */
    private String activitytypename = "";

    /**  活动列表  */
    private java.util.List<ActivityBusiness> activityBusinessList = new java.util.ArrayList<ActivityBusiness>();

    public String getActivitytypename()
    {
        return this.activitytypename;
    }

    public void setActivitytypename(String activitytypename)
    {
        this.activitytypename = activitytypename;
    }

    public java.util.List<ActivityBusiness> getActivityBusinessList()
    {
        return this.activityBusinessList;
    }

    public void setActivityBusinessList(java.util.List<ActivityBusiness> activityBusinessList)
    {
        this.activityBusinessList = activityBusinessList;
    }

    @Override
    public String toString()
    {
        return "ActivitylistBusiness [activitytypename=" + this.activitytypename + ", activityBusinessList=" + this.activityBusinessList.toString() + "]";
    }

}