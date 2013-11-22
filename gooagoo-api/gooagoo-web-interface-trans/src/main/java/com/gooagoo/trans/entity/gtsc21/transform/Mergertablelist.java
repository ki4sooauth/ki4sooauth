package com.gooagoo.trans.entity.gtsc21.transform;

import java.io.Serializable;

/**
 *  并台信息 
 */
public class Mergertablelist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  并台信息单编号  */
	private String mergerid = "";

	/**  目标餐桌桌号  */
	private String tablename = "";

	/**  被合并餐桌桌号  */
	private String othertablename = "";

	/**  时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置 并台信息单编号 
	 * @param mergerid	 并台信息单编号 
	 */
	public void setMergerid(String mergerid)
	{
		this.mergerid = mergerid != null ? mergerid : "";
	}

	/**
	 * 获取 并台信息单编号 
	 * @return	 并台信息单编号 
	 */
	public String getMergerid()
	{
		return this.mergerid;
	}

	/**
	 * 设置 目标餐桌桌号 
	 * @param tablename	 目标餐桌桌号 
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取 目标餐桌桌号 
	 * @return	 目标餐桌桌号 
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置 被合并餐桌桌号 
	 * @param othertablename	 被合并餐桌桌号 
	 */
	public void setOthertablename(String othertablename)
	{
		this.othertablename = othertablename != null ? othertablename : "";
	}

	/**
	 * 获取 被合并餐桌桌号 
	 * @return	 被合并餐桌桌号 
	 */
	public String getOthertablename()
	{
		return this.othertablename;
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