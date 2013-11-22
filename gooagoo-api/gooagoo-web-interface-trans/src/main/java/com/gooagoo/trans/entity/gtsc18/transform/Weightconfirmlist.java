package com.gooagoo.trans.entity.gtsc18.transform;

import java.io.Serializable;

/**
 *  重量确认信息 
 */
public class Weightconfirmlist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  订单id  */
	private String orderid = "";

	/**  餐桌桌号  */
	private String tablename = "";

	/**  菜品自定义序列号  */
	private String itemserial = "";

	/**  时间戳  */
	private String ctimestamp = "";

	/**  重量  */
	private String weightnum = "";

	/**
	 * 设置 订单id 
	 * @param orderid	 订单id 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取 订单id 
	 * @return	 订单id 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置 餐桌桌号 
	 * @param tablename	 餐桌桌号 
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取 餐桌桌号 
	 * @return	 餐桌桌号 
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置 菜品自定义序列号 
	 * @param itemserial	 菜品自定义序列号 
	 */
	public void setItemserial(String itemserial)
	{
		this.itemserial = itemserial != null ? itemserial : "";
	}

	/**
	 * 获取 菜品自定义序列号 
	 * @return	 菜品自定义序列号 
	 */
	public String getItemserial()
	{
		return this.itemserial;
	}

	/**
	 * 设置 时间戳 
	 * @param ctimestamp	 时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取 时间戳 
	 * @return	 时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 设置 重量 
	 * @param weightnum	 重量 
	 */
	public void setWeightnum(String weightnum)
	{
		this.weightnum = weightnum != null ? weightnum : "";
	}

	/**
	 * 获取 重量 
	 * @return	 重量 
	 */
	public String getWeightnum()
	{
		return this.weightnum;
	}
}