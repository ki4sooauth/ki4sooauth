package com.gooagoo.mobile.entity.mobd04.transform;

import java.io.Serializable;

/**
 *  活动列表 
 */
public class Activitylist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 活动分类名称，当前只有一种，“当日活动”  */
	private String activitytypename = "";

	/**  活动列表  */
	private java.util.List<Activity> activity = new java.util.ArrayList<Activity>();

	/**
	 * 设置活动分类名称，当前只有一种，“当日活动” 
	 * @param activitytypename	活动分类名称，当前只有一种，“当日活动” 
	 */
	public void setActivitytypename(String activitytypename)
	{
		this.activitytypename = activitytypename != null ? activitytypename : "";
	}

	/**
	 * 获取活动分类名称，当前只有一种，“当日活动” 
	 * @return	活动分类名称，当前只有一种，“当日活动” 
	 */
	public String getActivitytypename()
	{
		return this.activitytypename;
	}

	/**
	 * 设置 活动列表 
	 * @param activity	 活动列表 
	 */
	public void setActivity(java.util.List<Activity> activity)
	{
		this.activity = activity;
	}

	/**
	 * 获取 活动列表 
	 * @return	 活动列表 
	 */
	public java.util.List<Activity> getActivity()
	{
		return this.activity;
	}

	/**
	 * 添加 活动列表 
	 * @return activity	 活动列表 
	 */
	public Activity addMoreActivity() {
		Activity activity = new Activity();
		this.activity.add(activity);
		return activity;
	}
}