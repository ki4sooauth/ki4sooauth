package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 * 个人发票 
 */
public class Invoicetypep implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 发票项目类型(个人)  */
	private String name = "";

	/**
	 * 设置发票项目类型(个人) 
	 * @param name	发票项目类型(个人) 
	 */
	public void setName(String name)
	{
		this.name = name != null ? name : "";
	}

	/**
	 * 获取发票项目类型(个人) 
	 * @return	发票项目类型(个人) 
	 */
	public String getName()
	{
		return this.name;
	}
}