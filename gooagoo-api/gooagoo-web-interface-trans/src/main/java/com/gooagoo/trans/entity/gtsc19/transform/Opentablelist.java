package com.gooagoo.trans.entity.gtsc19.transform;

import java.io.Serializable;

/**
 *  开台信息 
 */
public class Opentablelist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  开台信息单编号  */
	private String openid = "";

	/**  餐桌桌号  */
	private String tablename = "";

	/**  客人人数  */
	private String guestsnumber = "";

	/**  时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置 开台信息单编号 
	 * @param openid	 开台信息单编号 
	 */
	public void setOpenid(String openid)
	{
		this.openid = openid != null ? openid : "";
	}

	/**
	 * 获取 开台信息单编号 
	 * @return	 开台信息单编号 
	 */
	public String getOpenid()
	{
		return this.openid;
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
	 * 设置 客人人数 
	 * @param guestsnumber	 客人人数 
	 */
	public void setGuestsnumber(String guestsnumber)
	{
		this.guestsnumber = guestsnumber != null ? guestsnumber : "";
	}

	/**
	 * 获取 客人人数 
	 * @return	 客人人数 
	 */
	public String getGuestsnumber()
	{
		return this.guestsnumber;
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