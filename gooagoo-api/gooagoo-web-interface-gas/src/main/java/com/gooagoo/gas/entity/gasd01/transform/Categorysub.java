package com.gooagoo.gas.entity.gasd01.transform;

import java.io.Serializable;

/**
 * 子分类 
 */
public class Categorysub implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 子分类id  */
	private String categorysubid = "";

	/** 子分类名称  */
	private String categorysubname = "";

	/** 子分类图片url  */
	private String categorysuburl = "";

	/**
	 * 设置子分类id 
	 * @param categorysubid	子分类id 
	 */
	public void setCategorysubid(String categorysubid)
	{
		this.categorysubid = categorysubid != null ? categorysubid : "";
	}

	/**
	 * 获取子分类id 
	 * @return	子分类id 
	 */
	public String getCategorysubid()
	{
		return this.categorysubid;
	}

	/**
	 * 设置子分类名称 
	 * @param categorysubname	子分类名称 
	 */
	public void setCategorysubname(String categorysubname)
	{
		this.categorysubname = categorysubname != null ? categorysubname : "";
	}

	/**
	 * 获取子分类名称 
	 * @return	子分类名称 
	 */
	public String getCategorysubname()
	{
		return this.categorysubname;
	}

	/**
	 * 设置子分类图片url 
	 * @param categorysuburl	子分类图片url 
	 */
	public void setCategorysuburl(String categorysuburl)
	{
		this.categorysuburl = categorysuburl != null ? categorysuburl : "";
	}

	/**
	 * 获取子分类图片url 
	 * @return	子分类图片url 
	 */
	public String getCategorysuburl()
	{
		return this.categorysuburl;
	}
}