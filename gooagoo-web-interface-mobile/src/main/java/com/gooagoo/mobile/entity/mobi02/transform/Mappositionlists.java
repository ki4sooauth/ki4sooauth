package com.gooagoo.mobile.entity.mobi02.transform;

import java.io.Serializable;

/**
 *  位置信息
 */
public class Mappositionlists implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家\商品编号  */
	private String objid = "";

	/** 商家\商品名称  */
	private String objname = "";

	/** type：S-商家，G-商品 */
	private String type = "";

	/**  地图编号  */
	private String mapid = "";

	/** svg 图上的，x轴坐标  */
	private String px = "";

	/** svg 图上的，y轴坐标  */
	private String py = "";

	/**
	 * 设置商家\商品编号 
	 * @param objid	商家\商品编号 
	 */
	public void setObjid(String objid)
	{
		this.objid = objid != null ? objid : "";
	}

	/**
	 * 获取商家\商品编号 
	 * @return	商家\商品编号 
	 */
	public String getObjid()
	{
		return this.objid;
	}

	/**
	 * 设置商家\商品名称 
	 * @param objname	商家\商品名称 
	 */
	public void setObjname(String objname)
	{
		this.objname = objname != null ? objname : "";
	}

	/**
	 * 获取商家\商品名称 
	 * @return	商家\商品名称 
	 */
	public String getObjname()
	{
		return this.objname;
	}

	/**
	 * 设置type：S-商家，G-商品
	 * @param type	type：S-商家，G-商品
	 */
	public void setType(String type)
	{
		this.type = type != null ? type : "";
	}

	/**
	 * 获取type：S-商家，G-商品
	 * @return	type：S-商家，G-商品
	 */
	public String getType()
	{
		return this.type;
	}

	/**
	 * 设置 地图编号 
	 * @param mapid	 地图编号 
	 */
	public void setMapid(String mapid)
	{
		this.mapid = mapid != null ? mapid : "";
	}

	/**
	 * 获取 地图编号 
	 * @return	 地图编号 
	 */
	public String getMapid()
	{
		return this.mapid;
	}

	/**
	 * 设置svg 图上的，x轴坐标 
	 * @param px	svg 图上的，x轴坐标 
	 */
	public void setPx(String px)
	{
		this.px = px != null ? px : "";
	}

	/**
	 * 获取svg 图上的，x轴坐标 
	 * @return	svg 图上的，x轴坐标 
	 */
	public String getPx()
	{
		return this.px;
	}

	/**
	 * 设置svg 图上的，y轴坐标 
	 * @param py	svg 图上的，y轴坐标 
	 */
	public void setPy(String py)
	{
		this.py = py != null ? py : "";
	}

	/**
	 * 获取svg 图上的，y轴坐标 
	 * @return	svg 图上的，y轴坐标 
	 */
	public String getPy()
	{
		return this.py;
	}
}