package com.gooagoo.trans.entity.gtsa01.transform;

import java.io.Serializable;

/**
 * 商家id 
 */
public class Shopinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家id  */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 实体店编号  */
	private String shopentityid = "";

	/** 实体店名称  */
	private String shopentityname = "";

	/** 转发器设备型号  */
	private String devicetype = "";

	/**  对应的操作系统,0-dos，1-windows，2-linux  */
	private String systemtype = "";

	/**  对应的解析格式 ,A-飞天餐饮娱乐管理系统,B-PosPal收银系统,此处不返回字母A\B,返回其对应的中文解析，如：飞天餐饮娱乐管理系统 */
	private String billparse = "";

	/**  对应的解析格式,A-向POS机传递第三方订单号,B-向POS机传递商品序列号  */
	private String stservice = "";

	/**
	 * 设置商家id 
	 * @param shopid	商家id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家id 
	 * @return	商家id 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置商家名称 
	 * @param shopname	商家名称 
	 */
	public void setShopname(String shopname)
	{
		this.shopname = shopname != null ? shopname : "";
	}

	/**
	 * 获取商家名称 
	 * @return	商家名称 
	 */
	public String getShopname()
	{
		return this.shopname;
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
	 * 设置实体店名称 
	 * @param shopentityname	实体店名称 
	 */
	public void setShopentityname(String shopentityname)
	{
		this.shopentityname = shopentityname != null ? shopentityname : "";
	}

	/**
	 * 获取实体店名称 
	 * @return	实体店名称 
	 */
	public String getShopentityname()
	{
		return this.shopentityname;
	}

	/**
	 * 设置转发器设备型号 
	 * @param devicetype	转发器设备型号 
	 */
	public void setDevicetype(String devicetype)
	{
		this.devicetype = devicetype != null ? devicetype : "";
	}

	/**
	 * 获取转发器设备型号 
	 * @return	转发器设备型号 
	 */
	public String getDevicetype()
	{
		return this.devicetype;
	}

	/**
	 * 设置 对应的操作系统,0-dos，1-windows，2-linux 
	 * @param systemtype	 对应的操作系统,0-dos，1-windows，2-linux 
	 */
	public void setSystemtype(String systemtype)
	{
		this.systemtype = systemtype != null ? systemtype : "";
	}

	/**
	 * 获取 对应的操作系统,0-dos，1-windows，2-linux 
	 * @return	 对应的操作系统,0-dos，1-windows，2-linux 
	 */
	public String getSystemtype()
	{
		return this.systemtype;
	}

	/**
	 * 设置 对应的解析格式 ,A-飞天餐饮娱乐管理系统,B-PosPal收银系统,此处不返回字母A\B,返回其对应的中文解析，如：飞天餐饮娱乐管理系统
	 * @param billparse	 对应的解析格式 ,A-飞天餐饮娱乐管理系统,B-PosPal收银系统,此处不返回字母A\B,返回其对应的中文解析，如：飞天餐饮娱乐管理系统
	 */
	public void setBillparse(String billparse)
	{
		this.billparse = billparse != null ? billparse : "";
	}

	/**
	 * 获取 对应的解析格式 ,A-飞天餐饮娱乐管理系统,B-PosPal收银系统,此处不返回字母A\B,返回其对应的中文解析，如：飞天餐饮娱乐管理系统
	 * @return	 对应的解析格式 ,A-飞天餐饮娱乐管理系统,B-PosPal收银系统,此处不返回字母A\B,返回其对应的中文解析，如：飞天餐饮娱乐管理系统
	 */
	public String getBillparse()
	{
		return this.billparse;
	}

	/**
	 * 设置 对应的解析格式,A-向POS机传递第三方订单号,B-向POS机传递商品序列号 
	 * @param stservice	 对应的解析格式,A-向POS机传递第三方订单号,B-向POS机传递商品序列号 
	 */
	public void setStservice(String stservice)
	{
		this.stservice = stservice != null ? stservice : "";
	}

	/**
	 * 获取 对应的解析格式,A-向POS机传递第三方订单号,B-向POS机传递商品序列号 
	 * @return	 对应的解析格式,A-向POS机传递第三方订单号,B-向POS机传递商品序列号 
	 */
	public String getStservice()
	{
		return this.stservice;
	}
}