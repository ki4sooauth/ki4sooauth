package com.gooagoo.gas.entity.gasb01.transform;

import java.io.Serializable;

/**
 * 区域
 */
public class Storearealist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 店铺id */
	private String storeid = "";

	/** 区域id */
	private String storeareaid = "";

	/** 区域名称 */
	private String storeareaname = "";

	/** 区域人数  */
	private String storeareacount = "";

	/** 子区域 */
	private java.util.List<Storesubarea> storesubarea = new java.util.ArrayList<Storesubarea>();

	/**
	 * 设置店铺id
	 * @param storeid	店铺id
	 */
	public void setStoreid(String storeid)
	{
		this.storeid = storeid != null ? storeid : "";
	}

	/**
	 * 获取店铺id
	 * @return	店铺id
	 */
	public String getStoreid()
	{
		return this.storeid;
	}

	/**
	 * 设置区域id
	 * @param storeareaid	区域id
	 */
	public void setStoreareaid(String storeareaid)
	{
		this.storeareaid = storeareaid != null ? storeareaid : "";
	}

	/**
	 * 获取区域id
	 * @return	区域id
	 */
	public String getStoreareaid()
	{
		return this.storeareaid;
	}

	/**
	 * 设置区域名称
	 * @param storeareaname	区域名称
	 */
	public void setStoreareaname(String storeareaname)
	{
		this.storeareaname = storeareaname != null ? storeareaname : "";
	}

	/**
	 * 获取区域名称
	 * @return	区域名称
	 */
	public String getStoreareaname()
	{
		return this.storeareaname;
	}

	/**
	 * 设置区域人数 
	 * @param storeareacount	区域人数 
	 */
	public void setStoreareacount(String storeareacount)
	{
		this.storeareacount = storeareacount != null ? storeareacount : "";
	}

	/**
	 * 获取区域人数 
	 * @return	区域人数 
	 */
	public String getStoreareacount()
	{
		return this.storeareacount;
	}

	/**
	 * 设置子区域
	 * @param storesubarea	子区域
	 */
	public void setStoresubarea(java.util.List<Storesubarea> storesubarea)
	{
		this.storesubarea = storesubarea;
	}

	/**
	 * 获取子区域
	 * @return	子区域
	 */
	public java.util.List<Storesubarea> getStoresubarea()
	{
		return this.storesubarea;
	}

	/**
	 * 添加子区域
	 * @return storesubarea	子区域
	 */
	public Storesubarea addMoreStoresubarea() {
		Storesubarea storesubarea = new Storesubarea();
		this.storesubarea.add(storesubarea);
		return storesubarea;
	}
}