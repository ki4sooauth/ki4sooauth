package com.gooagoo.gas.entity.gasl02.transform;

import java.io.Serializable;

/**
 *  餐桌号 
 */
public class Desklist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  餐桌号  */
	private String deskno = "";

	/** 餐桌类型编码   */
	private String desktypecode = "";

	/** 餐桌类型名称   */
	private String desktypename = "";

	/** 餐桌上客户类型 0-会员 1-非会员  */
	private String isvip = "";

	/**  会员卡音频编号  */
	private String scardno = "";

	/** 餐桌状态:0-已开台 1-空闲, 2-已点餐  ，3正在结账 */
	private String deskstate = "";

	/**  用户提交订单时间  */
	private String userordertime = "";

	/** 用户用餐时长 ,返回时间格式为: HH:mm:ss */
	private String mealtime = "";

	/**
	 * 设置 餐桌号 
	 * @param deskno	 餐桌号 
	 */
	public void setDeskno(String deskno)
	{
		this.deskno = deskno != null ? deskno : "";
	}

	/**
	 * 获取 餐桌号 
	 * @return	 餐桌号 
	 */
	public String getDeskno()
	{
		return this.deskno;
	}

	/**
	 * 设置餐桌类型编码  
	 * @param desktypecode	餐桌类型编码  
	 */
	public void setDesktypecode(String desktypecode)
	{
		this.desktypecode = desktypecode != null ? desktypecode : "";
	}

	/**
	 * 获取餐桌类型编码  
	 * @return	餐桌类型编码  
	 */
	public String getDesktypecode()
	{
		return this.desktypecode;
	}

	/**
	 * 设置餐桌类型名称  
	 * @param desktypename	餐桌类型名称  
	 */
	public void setDesktypename(String desktypename)
	{
		this.desktypename = desktypename != null ? desktypename : "";
	}

	/**
	 * 获取餐桌类型名称  
	 * @return	餐桌类型名称  
	 */
	public String getDesktypename()
	{
		return this.desktypename;
	}

	/**
	 * 设置餐桌上客户类型 0-会员 1-非会员 
	 * @param isvip	餐桌上客户类型 0-会员 1-非会员 
	 */
	public void setIsvip(String isvip)
	{
		this.isvip = isvip != null ? isvip : "";
	}

	/**
	 * 获取餐桌上客户类型 0-会员 1-非会员 
	 * @return	餐桌上客户类型 0-会员 1-非会员 
	 */
	public String getIsvip()
	{
		return this.isvip;
	}

	/**
	 * 设置 会员卡音频编号 
	 * @param scardno	 会员卡音频编号 
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取 会员卡音频编号 
	 * @return	 会员卡音频编号 
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置餐桌状态:0-已开台 1-空闲, 2-已点餐  ，3正在结账
	 * @param deskstate	餐桌状态:0-已开台 1-空闲, 2-已点餐  ，3正在结账
	 */
	public void setDeskstate(String deskstate)
	{
		this.deskstate = deskstate != null ? deskstate : "";
	}

	/**
	 * 获取餐桌状态:0-已开台 1-空闲, 2-已点餐  ，3正在结账
	 * @return	餐桌状态:0-已开台 1-空闲, 2-已点餐  ，3正在结账
	 */
	public String getDeskstate()
	{
		return this.deskstate;
	}

	/**
	 * 设置 用户提交订单时间 
	 * @param userordertime	 用户提交订单时间 
	 */
	public void setUserordertime(String userordertime)
	{
		this.userordertime = userordertime != null ? userordertime : "";
	}

	/**
	 * 获取 用户提交订单时间 
	 * @return	 用户提交订单时间 
	 */
	public String getUserordertime()
	{
		return this.userordertime;
	}

	/**
	 * 设置用户用餐时长 ,返回时间格式为: HH:mm:ss
	 * @param mealtime	用户用餐时长 ,返回时间格式为: HH:mm:ss
	 */
	public void setMealtime(String mealtime)
	{
		this.mealtime = mealtime != null ? mealtime : "";
	}

	/**
	 * 获取用户用餐时长 ,返回时间格式为: HH:mm:ss
	 * @return	用户用餐时长 ,返回时间格式为: HH:mm:ss
	 */
	public String getMealtime()
	{
		return this.mealtime;
	}
}