package com.gooagoo.gas.entity.gasj03.transform;

import java.io.Serializable;

/**
 *  餐桌状态列表 
 */
public class Desklist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 餐桌类型  */
	private String tabletypecode = "";

	/** 餐桌上客户类型 0-会员 1-非会员  */
	private String isvip = "";

	/**  餐桌名称 */
	private String tablename = "";

	/**  餐桌状态:0-已开台 1-空闲, 2-已点餐  ,3-正在结账 */
	private String tablestate = "";

	/**  订单编号 */
	private String orderid = "";

	/** 用户用餐时长,返回时间格式为: HH:mm:ss空闲显示00：00：00  */
	private String mealtime = "";

	/** 如果是会员，则表示会员卡号 */
	private String scardno = "";

	/** HH:MM:SS用户提交订单时间 */
	private String userordertime = "";

	/** 商品总数 */
	private String goodsnums = "";

	/**  已上菜品数  */
	private String ischecknum = "";

	/** 未上菜品数  */
	private String notchecknum = "";

	/**
	 * 设置餐桌类型 
	 * @param tabletypecode	餐桌类型 
	 */
	public void setTabletypecode(String tabletypecode)
	{
		this.tabletypecode = tabletypecode != null ? tabletypecode : "";
	}

	/**
	 * 获取餐桌类型 
	 * @return	餐桌类型 
	 */
	public String getTabletypecode()
	{
		return this.tabletypecode;
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
	 * 设置 餐桌名称
	 * @param tablename	 餐桌名称
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取 餐桌名称
	 * @return	 餐桌名称
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置 餐桌状态:0-已开台 1-空闲, 2-已点餐  ,3-正在结账
	 * @param tablestate	 餐桌状态:0-已开台 1-空闲, 2-已点餐  ,3-正在结账
	 */
	public void setTablestate(String tablestate)
	{
		this.tablestate = tablestate != null ? tablestate : "";
	}

	/**
	 * 获取 餐桌状态:0-已开台 1-空闲, 2-已点餐  ,3-正在结账
	 * @return	 餐桌状态:0-已开台 1-空闲, 2-已点餐  ,3-正在结账
	 */
	public String getTablestate()
	{
		return this.tablestate;
	}

	/**
	 * 设置 订单编号
	 * @param orderid	 订单编号
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取 订单编号
	 * @return	 订单编号
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置用户用餐时长,返回时间格式为: HH:mm:ss空闲显示00：00：00 
	 * @param mealtime	用户用餐时长,返回时间格式为: HH:mm:ss空闲显示00：00：00 
	 */
	public void setMealtime(String mealtime)
	{
		this.mealtime = mealtime != null ? mealtime : "";
	}

	/**
	 * 获取用户用餐时长,返回时间格式为: HH:mm:ss空闲显示00：00：00 
	 * @return	用户用餐时长,返回时间格式为: HH:mm:ss空闲显示00：00：00 
	 */
	public String getMealtime()
	{
		return this.mealtime;
	}

	/**
	 * 设置如果是会员，则表示会员卡号
	 * @param scardno	如果是会员，则表示会员卡号
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取如果是会员，则表示会员卡号
	 * @return	如果是会员，则表示会员卡号
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置HH:MM:SS用户提交订单时间
	 * @param userordertime	HH:MM:SS用户提交订单时间
	 */
	public void setUserordertime(String userordertime)
	{
		this.userordertime = userordertime != null ? userordertime : "";
	}

	/**
	 * 获取HH:MM:SS用户提交订单时间
	 * @return	HH:MM:SS用户提交订单时间
	 */
	public String getUserordertime()
	{
		return this.userordertime;
	}

	/**
	 * 设置商品总数
	 * @param goodsnums	商品总数
	 */
	public void setGoodsnums(String goodsnums)
	{
		this.goodsnums = goodsnums != null ? goodsnums : "";
	}

	/**
	 * 获取商品总数
	 * @return	商品总数
	 */
	public String getGoodsnums()
	{
		return this.goodsnums;
	}

	/**
	 * 设置 已上菜品数 
	 * @param ischecknum	 已上菜品数 
	 */
	public void setIschecknum(String ischecknum)
	{
		this.ischecknum = ischecknum != null ? ischecknum : "";
	}

	/**
	 * 获取 已上菜品数 
	 * @return	 已上菜品数 
	 */
	public String getIschecknum()
	{
		return this.ischecknum;
	}

	/**
	 * 设置未上菜品数 
	 * @param notchecknum	未上菜品数 
	 */
	public void setNotchecknum(String notchecknum)
	{
		this.notchecknum = notchecknum != null ? notchecknum : "";
	}

	/**
	 * 获取未上菜品数 
	 * @return	未上菜品数 
	 */
	public String getNotchecknum()
	{
		return this.notchecknum;
	}
}