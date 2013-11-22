package com.gooagoo.gas.entity.gase02.transform;

import java.io.Serializable;

/**
 * 商品类别,查出该商品对应的根节点到叶节点的所有类别 
 */
public class Goodscategorylistf implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 品类编号  */
	private String categoryid = "";

	/** 品类名称  */
	private String categoryname = "";

	/**
	 * 设置品类编号 
	 * @param categoryid	品类编号 
	 */
	public void setCategoryid(String categoryid)
	{
		this.categoryid = categoryid != null ? categoryid : "";
	}

	/**
	 * 获取品类编号 
	 * @return	品类编号 
	 */
	public String getCategoryid()
	{
		return this.categoryid;
	}

	/**
	 * 设置品类名称 
	 * @param categoryname	品类名称 
	 */
	public void setCategoryname(String categoryname)
	{
		this.categoryname = categoryname != null ? categoryname : "";
	}

	/**
	 * 获取品类名称 
	 * @return	品类名称 
	 */
	public String getCategoryname()
	{
		return this.categoryname;
	}
}