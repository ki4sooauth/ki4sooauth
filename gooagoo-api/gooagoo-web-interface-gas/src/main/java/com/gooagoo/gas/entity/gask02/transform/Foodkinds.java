package com.gooagoo.gas.entity.gask02.transform;

import java.io.Serializable;

/**
 * 品类信息
 */
public class Foodkinds implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 分类id */
	private String foodkindid = "";

	/** 分类名称 */
	private String foodkindname = "";

	/**  示例图片地址 */
	private String url = "";

	/**
	 * 设置分类id
	 * @param foodkindid	分类id
	 */
	public void setFoodkindid(String foodkindid)
	{
		this.foodkindid = foodkindid != null ? foodkindid : "";
	}

	/**
	 * 获取分类id
	 * @return	分类id
	 */
	public String getFoodkindid()
	{
		return this.foodkindid;
	}

	/**
	 * 设置分类名称
	 * @param foodkindname	分类名称
	 */
	public void setFoodkindname(String foodkindname)
	{
		this.foodkindname = foodkindname != null ? foodkindname : "";
	}

	/**
	 * 获取分类名称
	 * @return	分类名称
	 */
	public String getFoodkindname()
	{
		return this.foodkindname;
	}

	/**
	 * 设置 示例图片地址
	 * @param url	 示例图片地址
	 */
	public void setUrl(String url)
	{
		this.url = url != null ? url : "";
	}

	/**
	 * 获取 示例图片地址
	 * @return	 示例图片地址
	 */
	public String getUrl()
	{
		return this.url;
	}
}