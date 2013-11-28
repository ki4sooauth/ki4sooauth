package com.gooagoo.mobile.entity.mobb06.transform;

import java.io.Serializable;

/**
 *  一级菜单 
 */
public class Firstmenu implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  一级菜单编码  */
	private String firstmenucode = "";

	/**  一级菜单名称  */
	private String firstmenuname = "";

	/**  二级菜单  */
	private java.util.List<Secondmenu> secondmenu = new java.util.ArrayList<Secondmenu>();

	/**
	 * 设置 一级菜单编码 
	 * @param firstmenucode	 一级菜单编码 
	 */
	public void setFirstmenucode(String firstmenucode)
	{
		this.firstmenucode = firstmenucode != null ? firstmenucode : "";
	}

	/**
	 * 获取 一级菜单编码 
	 * @return	 一级菜单编码 
	 */
	public String getFirstmenucode()
	{
		return this.firstmenucode;
	}

	/**
	 * 设置 一级菜单名称 
	 * @param firstmenuname	 一级菜单名称 
	 */
	public void setFirstmenuname(String firstmenuname)
	{
		this.firstmenuname = firstmenuname != null ? firstmenuname : "";
	}

	/**
	 * 获取 一级菜单名称 
	 * @return	 一级菜单名称 
	 */
	public String getFirstmenuname()
	{
		return this.firstmenuname;
	}

	/**
	 * 设置 二级菜单 
	 * @param secondmenu	 二级菜单 
	 */
	public void setSecondmenu(java.util.List<Secondmenu> secondmenu)
	{
		this.secondmenu = secondmenu;
	}

	/**
	 * 获取 二级菜单 
	 * @return	 二级菜单 
	 */
	public java.util.List<Secondmenu> getSecondmenu()
	{
		return this.secondmenu;
	}

	/**
	 * 添加 二级菜单 
	 * @return secondmenu	 二级菜单 
	 */
	public Secondmenu addMoreSecondmenu() {
		Secondmenu secondmenu = new Secondmenu();
		this.secondmenu.add(secondmenu);
		return secondmenu;
	}
}