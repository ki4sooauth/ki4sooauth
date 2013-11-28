package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  实体店gps信息 
 */
public class Shopgpsinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/** 实体店编号  */
	private String shopentityid = "";

	/** gps百度的x坐标  */
	private String shopgpsbaidux = "";

	/** gps百度的y坐标  */
	private String shopgpsbaiduy = "";

	/** gpsgoogle的x坐标  */
	private String shopgpsgooglex = "";

	/** gpsgoogle的y坐标  */
	private String shopgpsgoogley = "";

	/** 备注  */
	private String note = "";

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
	 * 设置gps百度的x坐标 
	 * @param shopgpsbaidux	gps百度的x坐标 
	 */
	public void setShopgpsbaidux(String shopgpsbaidux)
	{
		this.shopgpsbaidux = shopgpsbaidux != null ? shopgpsbaidux : "";
	}

	/**
	 * 获取gps百度的x坐标 
	 * @return	gps百度的x坐标 
	 */
	public String getShopgpsbaidux()
	{
		return this.shopgpsbaidux;
	}

	/**
	 * 设置gps百度的y坐标 
	 * @param shopgpsbaiduy	gps百度的y坐标 
	 */
	public void setShopgpsbaiduy(String shopgpsbaiduy)
	{
		this.shopgpsbaiduy = shopgpsbaiduy != null ? shopgpsbaiduy : "";
	}

	/**
	 * 获取gps百度的y坐标 
	 * @return	gps百度的y坐标 
	 */
	public String getShopgpsbaiduy()
	{
		return this.shopgpsbaiduy;
	}

	/**
	 * 设置gpsgoogle的x坐标 
	 * @param shopgpsgooglex	gpsgoogle的x坐标 
	 */
	public void setShopgpsgooglex(String shopgpsgooglex)
	{
		this.shopgpsgooglex = shopgpsgooglex != null ? shopgpsgooglex : "";
	}

	/**
	 * 获取gpsgoogle的x坐标 
	 * @return	gpsgoogle的x坐标 
	 */
	public String getShopgpsgooglex()
	{
		return this.shopgpsgooglex;
	}

	/**
	 * 设置gpsgoogle的y坐标 
	 * @param shopgpsgoogley	gpsgoogle的y坐标 
	 */
	public void setShopgpsgoogley(String shopgpsgoogley)
	{
		this.shopgpsgoogley = shopgpsgoogley != null ? shopgpsgoogley : "";
	}

	/**
	 * 获取gpsgoogle的y坐标 
	 * @return	gpsgoogle的y坐标 
	 */
	public String getShopgpsgoogley()
	{
		return this.shopgpsgoogley;
	}

	/**
	 * 设置备注 
	 * @param note	备注 
	 */
	public void setNote(String note)
	{
		this.note = note != null ? note : "";
	}

	/**
	 * 获取备注 
	 * @return	备注 
	 */
	public String getNote()
	{
		return this.note;
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