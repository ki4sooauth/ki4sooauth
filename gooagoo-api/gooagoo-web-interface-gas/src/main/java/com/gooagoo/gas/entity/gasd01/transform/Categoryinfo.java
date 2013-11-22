package com.gooagoo.gas.entity.gasd01.transform;

import java.io.Serializable;

/**
 * 品类信息 
 */
public class Categoryinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 分类id  */
	private String categoryid = "";

	/** 分类名称  */
	private String categoryname = "";

	/** 分类图片url  */
	private String categoryurl = "";

	/** 子分类  */
	private java.util.List<Categorysub> categorysub = new java.util.ArrayList<Categorysub>();

	/**
	 * 设置分类id 
	 * @param categoryid	分类id 
	 */
	public void setCategoryid(String categoryid)
	{
		this.categoryid = categoryid != null ? categoryid : "";
	}

	/**
	 * 获取分类id 
	 * @return	分类id 
	 */
	public String getCategoryid()
	{
		return this.categoryid;
	}

	/**
	 * 设置分类名称 
	 * @param categoryname	分类名称 
	 */
	public void setCategoryname(String categoryname)
	{
		this.categoryname = categoryname != null ? categoryname : "";
	}

	/**
	 * 获取分类名称 
	 * @return	分类名称 
	 */
	public String getCategoryname()
	{
		return this.categoryname;
	}

	/**
	 * 设置分类图片url 
	 * @param categoryurl	分类图片url 
	 */
	public void setCategoryurl(String categoryurl)
	{
		this.categoryurl = categoryurl != null ? categoryurl : "";
	}

	/**
	 * 获取分类图片url 
	 * @return	分类图片url 
	 */
	public String getCategoryurl()
	{
		return this.categoryurl;
	}

	/**
	 * 设置子分类 
	 * @param categorysub	子分类 
	 */
	public void setCategorysub(java.util.List<Categorysub> categorysub)
	{
		this.categorysub = categorysub;
	}

	/**
	 * 获取子分类 
	 * @return	子分类 
	 */
	public java.util.List<Categorysub> getCategorysub()
	{
		return this.categorysub;
	}

	/**
	 * 添加子分类 
	 * @return categorysub	子分类 
	 */
	public Categorysub addMoreCategorysub() {
		Categorysub categorysub = new Categorysub();
		this.categorysub.add(categorysub);
		return categorysub;
	}
}