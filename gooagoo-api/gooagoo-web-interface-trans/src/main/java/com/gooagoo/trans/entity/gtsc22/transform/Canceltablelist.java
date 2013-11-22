package com.gooagoo.trans.entity.gtsc22.transform;

import java.io.Serializable;

/**
 *  撤台信息 
 */
public class Canceltablelist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  撤台信息单编号  */
	private String cancelid = "";

	/**  餐桌桌号  */
	private String tablename = "";

	/**  时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置 撤台信息单编号 
	 * @param cancelid	 撤台信息单编号 
	 */
	public void setCancelid(String cancelid)
	{
		this.cancelid = cancelid != null ? cancelid : "";
	}

	/**
	 * 获取 撤台信息单编号 
	 * @return	 撤台信息单编号 
	 */
	public String getCancelid()
	{
		return this.cancelid;
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
}