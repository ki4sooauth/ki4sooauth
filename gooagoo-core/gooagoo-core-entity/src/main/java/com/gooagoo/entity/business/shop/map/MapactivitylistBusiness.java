package com.gooagoo.entity.business.shop.map;

import java.io.Serializable;

/**
 *  活动列表
 */
public class MapactivitylistBusiness implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 活动名称  */
	private String name = "";

	/** 活动URL  */
	private String url = "";

	/** svg 图上的，x轴坐标  */
	private String px = "";

	/** svg 图上的，y轴坐标  */
	private String py = "";

	/**
	 * 设置活动名称 
	 * @param name	活动名称 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取活动名称 
	 * @return	活动名称 
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置活动URL 
	 * @param url	活动URL 
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取活动URL 
	 * @return	活动URL 
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 设置svg 图上的，x轴坐标 
	 * @param px	svg 图上的，x轴坐标 
	 */
	public void setPx(String px) {
		this.px = px;
	}

	/**
	 * 获取svg 图上的，x轴坐标 
	 * @return	svg 图上的，x轴坐标 
	 */
	public String getPx() {
		return this.px;
	}

	/**
	 * 设置svg 图上的，y轴坐标 
	 * @param py	svg 图上的，y轴坐标 
	 */
	public void setPy(String py) {
		this.py = py;
	}

	/**
	 * 获取svg 图上的，y轴坐标 
	 * @return	svg 图上的，y轴坐标 
	 */
	public String getPy() {
		return this.py;
	}
}