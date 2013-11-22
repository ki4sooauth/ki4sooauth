package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  实体店svg图信息 
 */
public class Shopsvginfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/** 实体店编号  */
	private String shopentityid = "";

	/** 地图编码  */
	private String mapid = "";

	/** 地图名称  */
	private String mapname = "";

	/** html图URL手机导航使用此节点  */
	private String htmlurl = "";

	/** 是否可以停车  */
	private String ispark = "";

	/** 是否删除  */
	private String isdel = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

	/**
	 * 设置商家编号 
	 * @param shopid	商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家编号 
	 * @return	商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置实体店编号 
	 * @param shopentityid	实体店编号 
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取实体店编号 
	 * @return	实体店编号 
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置地图编码 
	 * @param mapid	地图编码 
	 */
	public void setMapid(String mapid)
	{
		this.mapid = mapid != null ? mapid : "";
	}

	/**
	 * 获取地图编码 
	 * @return	地图编码 
	 */
	public String getMapid()
	{
		return this.mapid;
	}

	/**
	 * 设置地图名称 
	 * @param mapname	地图名称 
	 */
	public void setMapname(String mapname)
	{
		this.mapname = mapname != null ? mapname : "";
	}

	/**
	 * 获取地图名称 
	 * @return	地图名称 
	 */
	public String getMapname()
	{
		return this.mapname;
	}

	/**
	 * 设置html图URL手机导航使用此节点 
	 * @param htmlurl	html图URL手机导航使用此节点 
	 */
	public void setHtmlurl(String htmlurl)
	{
		this.htmlurl = htmlurl != null ? htmlurl : "";
	}

	/**
	 * 获取html图URL手机导航使用此节点 
	 * @return	html图URL手机导航使用此节点 
	 */
	public String getHtmlurl()
	{
		return this.htmlurl;
	}

	/**
	 * 设置是否可以停车 
	 * @param ispark	是否可以停车 
	 */
	public void setIspark(String ispark)
	{
		this.ispark = ispark != null ? ispark : "";
	}

	/**
	 * 获取是否可以停车 
	 * @return	是否可以停车 
	 */
	public String getIspark()
	{
		return this.ispark;
	}

	/**
	 * 设置是否删除 
	 * @param isdel	是否删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除 
	 * @return	是否删除 
	 */
	public String getIsdel()
	{
		return this.isdel;
	}

	/**
	 * 设置最后一次修改时间 
	 * @param ctimestamp	最后一次修改时间 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取最后一次修改时间 
	 * @return	最后一次修改时间 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}