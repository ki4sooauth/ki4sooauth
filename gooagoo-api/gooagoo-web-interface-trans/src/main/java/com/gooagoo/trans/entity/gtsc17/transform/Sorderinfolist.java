package com.gooagoo.trans.entity.gtsc17.transform;

import java.io.Serializable;

/**
 *  缓菜信息 
 */
public class Sorderinfolist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 时间戳  */
	private String ctimestamp = "";

	/** 订单编号  */
	private String orderid = "";

	/** 桌号  */
	private String tablename = "";

	/**  商品条形码（自定义序列号）  */
	private String itemserial = "";

	/**  商品数量  */
	private String goodsnum = "";

	/**
	 * 设置时间戳 
	 * @param ctimestamp	时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取时间戳 
	 * @return	时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 设置订单编号 
	 * @param orderid	订单编号 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取订单编号 
	 * @return	订单编号 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置桌号 
	 * @param tablename	桌号 
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取桌号 
	 * @return	桌号 
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置 商品条形码（自定义序列号） 
	 * @param itemserial	 商品条形码（自定义序列号） 
	 */
	public void setItemserial(String itemserial)
	{
		this.itemserial = itemserial != null ? itemserial : "";
	}

	/**
	 * 获取 商品条形码（自定义序列号） 
	 * @return	 商品条形码（自定义序列号） 
	 */
	public String getItemserial()
	{
		return this.itemserial;
	}

	/**
	 * 设置 商品数量 
	 * @param goodsnum	 商品数量 
	 */
	public void setGoodsnum(String goodsnum)
	{
		this.goodsnum = goodsnum != null ? goodsnum : "";
	}

	/**
	 * 获取 商品数量 
	 * @return	 商品数量 
	 */
	public String getGoodsnum()
	{
		return this.goodsnum;
	}
}