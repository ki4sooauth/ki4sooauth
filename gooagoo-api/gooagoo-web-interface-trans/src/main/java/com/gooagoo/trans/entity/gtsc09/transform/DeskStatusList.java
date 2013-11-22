package com.gooagoo.trans.entity.gtsc09.transform;

import java.io.Serializable;

/**
 *  餐桌状态列表 
 */
public class DeskStatusList implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 餐桌编号名称,对应desk_no  */
	private String deskno = "";

	/** 餐桌状态,1-空闲 2-点餐 3-正在结账  */
	private String deskstate = "";

	/** 建议最小人数  */
	private String minnums = "";

	/** 建议最大人数 */
	private String maxnums = "";

	/** 当前状态出现时间  */
	private String mealtime = "";

	/**
	 * 设置餐桌编号名称,对应desk_no 
	 * @param deskno	餐桌编号名称,对应desk_no 
	 */
	public void setDeskno(String deskno)
	{
		this.deskno = deskno != null ? deskno : "";
	}

	/**
	 * 获取餐桌编号名称,对应desk_no 
	 * @return	餐桌编号名称,对应desk_no 
	 */
	public String getDeskno()
	{
		return this.deskno;
	}

	/**
	 * 设置餐桌状态,1-空闲 2-点餐 3-正在结账 
	 * @param deskstate	餐桌状态,1-空闲 2-点餐 3-正在结账 
	 */
	public void setDeskstate(String deskstate)
	{
		this.deskstate = deskstate != null ? deskstate : "";
	}

	/**
	 * 获取餐桌状态,1-空闲 2-点餐 3-正在结账 
	 * @return	餐桌状态,1-空闲 2-点餐 3-正在结账 
	 */
	public String getDeskstate()
	{
		return this.deskstate;
	}

	/**
	 * 设置建议最小人数 
	 * @param minnums	建议最小人数 
	 */
	public void setMinnums(String minnums)
	{
		this.minnums = minnums != null ? minnums : "";
	}

	/**
	 * 获取建议最小人数 
	 * @return	建议最小人数 
	 */
	public String getMinnums()
	{
		return this.minnums;
	}

	/**
	 * 设置建议最大人数
	 * @param maxnums	建议最大人数
	 */
	public void setMaxnums(String maxnums)
	{
		this.maxnums = maxnums != null ? maxnums : "";
	}

	/**
	 * 获取建议最大人数
	 * @return	建议最大人数
	 */
	public String getMaxnums()
	{
		return this.maxnums;
	}

	/**
	 * 设置当前状态出现时间 
	 * @param mealtime	当前状态出现时间 
	 */
	public void setMealtime(String mealtime)
	{
		this.mealtime = mealtime != null ? mealtime : "";
	}

	/**
	 * 获取当前状态出现时间 
	 * @return	当前状态出现时间 
	 */
	public String getMealtime()
	{
		return this.mealtime;
	}
}