package com.gooagoo.trans.entity.gtsc20.transform;

import java.io.Serializable;

/**
 *  换台信息 
 */
public class Exchangetablelist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  换台信息单编号  */
	private String exchangeid = "";

	/**  原餐桌桌号  */
	private String oldtablename = "";

	/**  新餐桌桌号  */
	private String newtablename = "";

	/**  时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置 换台信息单编号 
	 * @param exchangeid	 换台信息单编号 
	 */
	public void setExchangeid(String exchangeid)
	{
		this.exchangeid = exchangeid != null ? exchangeid : "";
	}

	/**
	 * 获取 换台信息单编号 
	 * @return	 换台信息单编号 
	 */
	public String getExchangeid()
	{
		return this.exchangeid;
	}

	/**
	 * 设置 原餐桌桌号 
	 * @param oldtablename	 原餐桌桌号 
	 */
	public void setOldtablename(String oldtablename)
	{
		this.oldtablename = oldtablename != null ? oldtablename : "";
	}

	/**
	 * 获取 原餐桌桌号 
	 * @return	 原餐桌桌号 
	 */
	public String getOldtablename()
	{
		return this.oldtablename;
	}

	/**
	 * 设置 新餐桌桌号 
	 * @param newtablename	 新餐桌桌号 
	 */
	public void setNewtablename(String newtablename)
	{
		this.newtablename = newtablename != null ? newtablename : "";
	}

	/**
	 * 获取 新餐桌桌号 
	 * @return	 新餐桌桌号 
	 */
	public String getNewtablename()
	{
		return this.newtablename;
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