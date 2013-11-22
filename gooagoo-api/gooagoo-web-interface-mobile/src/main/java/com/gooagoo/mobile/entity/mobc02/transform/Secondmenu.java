package com.gooagoo.mobile.entity.mobc02.transform;

import java.io.Serializable;

/**
 *  二级菜单 
 */
public class Secondmenu implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  二级菜单编码  */
	private String secondmenucode = "";

	/**  二级菜单名称  */
	private String secondmenuname = "";

	/**
	 * 设置 二级菜单编码 
	 * @param secondmenucode	 二级菜单编码 
	 */
	public void setSecondmenucode(String secondmenucode)
	{
		this.secondmenucode = secondmenucode != null ? secondmenucode : "";
	}

	/**
	 * 获取 二级菜单编码 
	 * @return	 二级菜单编码 
	 */
	public String getSecondmenucode()
	{
		return this.secondmenucode;
	}

	/**
	 * 设置 二级菜单名称 
	 * @param secondmenuname	 二级菜单名称 
	 */
	public void setSecondmenuname(String secondmenuname)
	{
		this.secondmenuname = secondmenuname != null ? secondmenuname : "";
	}

	/**
	 * 获取 二级菜单名称 
	 * @return	 二级菜单名称 
	 */
	public String getSecondmenuname()
	{
		return this.secondmenuname;
	}
}