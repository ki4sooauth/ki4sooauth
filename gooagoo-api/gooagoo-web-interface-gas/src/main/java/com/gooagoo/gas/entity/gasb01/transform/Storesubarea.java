package com.gooagoo.gas.entity.gasb01.transform;

import java.io.Serializable;

/**
 * 子区域
 */
public class Storesubarea implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 子区域id */
	private String storesubareaid = "";

	/** 子区域名称 */
	private String storesubareaname = "";

	/**  区域人数  */
	private String storeareacount = "";

	/**
	 * 设置子区域id
	 * @param storesubareaid	子区域id
	 */
	public void setStoresubareaid(String storesubareaid)
	{
		this.storesubareaid = storesubareaid != null ? storesubareaid : "";
	}

	/**
	 * 获取子区域id
	 * @return	子区域id
	 */
	public String getStoresubareaid()
	{
		return this.storesubareaid;
	}

	/**
	 * 设置子区域名称
	 * @param storesubareaname	子区域名称
	 */
	public void setStoresubareaname(String storesubareaname)
	{
		this.storesubareaname = storesubareaname != null ? storesubareaname : "";
	}

	/**
	 * 获取子区域名称
	 * @return	子区域名称
	 */
	public String getStoresubareaname()
	{
		return this.storesubareaname;
	}

	/**
	 * 设置 区域人数 
	 * @param storeareacount	 区域人数 
	 */
	public void setStoreareacount(String storeareacount)
	{
		this.storeareacount = storeareacount != null ? storeareacount : "";
	}

	/**
	 * 获取 区域人数 
	 * @return	 区域人数 
	 */
	public String getStoreareacount()
	{
		return this.storeareacount;
	}
}