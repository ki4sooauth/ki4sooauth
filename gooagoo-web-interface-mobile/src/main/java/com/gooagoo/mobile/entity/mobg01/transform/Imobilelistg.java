package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 * 接口地址列表 
 */
public class Imobilelistg implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/**  接口编号  */
	private String icode = "";

	/** 接口地址  */
	private String iurl = "";

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
	 * 设置 接口编号 
	 * @param icode	 接口编号 
	 */
	public void setIcode(String icode)
	{
		this.icode = icode != null ? icode : "";
	}

	/**
	 * 获取 接口编号 
	 * @return	 接口编号 
	 */
	public String getIcode()
	{
		return this.icode;
	}

	/**
	 * 设置接口地址 
	 * @param iurl	接口地址 
	 */
	public void setIurl(String iurl)
	{
		this.iurl = iurl != null ? iurl : "";
	}

	/**
	 * 获取接口地址 
	 * @return	接口地址 
	 */
	public String getIurl()
	{
		return this.iurl;
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