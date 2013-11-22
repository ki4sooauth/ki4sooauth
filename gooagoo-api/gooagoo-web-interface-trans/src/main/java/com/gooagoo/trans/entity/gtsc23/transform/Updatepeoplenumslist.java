package com.gooagoo.trans.entity.gtsc23.transform;

import java.io.Serializable;

/**
 *  修改台头信息 
 */
public class Updatepeoplenumslist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  修改台头信息单编号  */
	private String updateheaderid = "";

	/**  餐桌桌号  */
	private String tablename = "";

	/**  客人人数  */
	private String guestsnumber = "";

	/**  时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置 修改台头信息单编号 
	 * @param updateheaderid	 修改台头信息单编号 
	 */
	public void setUpdateheaderid(String updateheaderid)
	{
		this.updateheaderid = updateheaderid != null ? updateheaderid : "";
	}

	/**
	 * 获取 修改台头信息单编号 
	 * @return	 修改台头信息单编号 
	 */
	public String getUpdateheaderid()
	{
		return this.updateheaderid;
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