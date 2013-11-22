package com.gooagoo.gas.entity.gasm01.transform;

import java.io.Serializable;

/**
 *  常用发票抬头信息列表 
 */
public class Invoicetitles implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  发票抬头  */
	private String title = "";

	/**
	 * 设置 发票抬头 
	 * @param title	 发票抬头 
	 */
	public void setTitle(String title)
	{
		this.title = title != null ? title : "";
	}

	/**
	 * 获取 发票抬头 
	 * @return	 发票抬头 
	 */
	public String getTitle()
	{
		return this.title;
	}
}