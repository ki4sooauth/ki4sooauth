package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  实体店wifi信息 
 */
public class Shopwifiinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/** wifi编号  */
	private String wifiinfoid = "";

	/** 实体店编号  */
	private String shopentityid = "";

	/** wifi的名称  */
	private String wifissid = "";

	/** wifi的mac地址  */
	private String wifimac = "";

	/** wifi的口令  */
	private String wifipassword = "";

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
	 * 设置wifi编号 
	 * @param wifiinfoid	wifi编号 
	 */
	public void setWifiinfoid(String wifiinfoid)
	{
		this.wifiinfoid = wifiinfoid != null ? wifiinfoid : "";
	}

	/**
	 * 获取wifi编号 
	 * @return	wifi编号 
	 */
	public String getWifiinfoid()
	{
		return this.wifiinfoid;
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
	 * 设置wifi的名称 
	 * @param wifissid	wifi的名称 
	 */
	public void setWifissid(String wifissid)
	{
		this.wifissid = wifissid != null ? wifissid : "";
	}

	/**
	 * 获取wifi的名称 
	 * @return	wifi的名称 
	 */
	public String getWifissid()
	{
		return this.wifissid;
	}

	/**
	 * 设置wifi的mac地址 
	 * @param wifimac	wifi的mac地址 
	 */
	public void setWifimac(String wifimac)
	{
		this.wifimac = wifimac != null ? wifimac : "";
	}

	/**
	 * 获取wifi的mac地址 
	 * @return	wifi的mac地址 
	 */
	public String getWifimac()
	{
		return this.wifimac;
	}

	/**
	 * 设置wifi的口令 
	 * @param wifipassword	wifi的口令 
	 */
	public void setWifipassword(String wifipassword)
	{
		this.wifipassword = wifipassword != null ? wifipassword : "";
	}

	/**
	 * 获取wifi的口令 
	 * @return	wifi的口令 
	 */
	public String getWifipassword()
	{
		return this.wifipassword;
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