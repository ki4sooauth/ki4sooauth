package com.gooagoo.trans.entity.gtsc27.transform;

import java.io.Serializable;

/**
 *  勾挑信息 
 */
public class Hookuplist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 餐桌桌号  */
	private String tablename = "";

	/** 时间戳  */
	private String ctimestamp = "";

	/** 订单id  */
	private String orderid = "";

	/** 菜品自定义序列号 */
	private String itemseriallis = "";

	/**
	 * 设置餐桌桌号 
	 * @param tablename	餐桌桌号 
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取餐桌桌号 
	 * @return	餐桌桌号 
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置时间戳 
	 * @param ctimestamp	时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取时间戳 
	 * @return	时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 设置订单id 
	 * @param orderid	订单id 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取订单id 
	 * @return	订单id 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置菜品自定义序列号
	 * @param itemseriallis	菜品自定义序列号
	 */
	public void setItemseriallis(String itemseriallis)
	{
		this.itemseriallis = itemseriallis != null ? itemseriallis : "";
	}

	/**
	 * 获取菜品自定义序列号
	 * @return	菜品自定义序列号
	 */
	public String getItemseriallis()
	{
		return this.itemseriallis;
	}
}