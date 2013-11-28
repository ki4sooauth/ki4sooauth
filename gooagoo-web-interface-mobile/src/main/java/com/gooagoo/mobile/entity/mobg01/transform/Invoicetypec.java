package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 * 公司发票 
 */
public class Invoicetypec implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 发票项目类型(公司)  */
	private String name = "";

	/**
	 * 设置发票项目类型(公司) 
	 * @param name	发票项目类型(公司) 
	 */
	public void setName(String name)
	{
		this.name = name != null ? name : "";
	}

	/**
	 * 获取发票项目类型(公司) 
	 * @return	发票项目类型(公司) 
	 */
	public String getName()
	{
		return this.name;
	}
}