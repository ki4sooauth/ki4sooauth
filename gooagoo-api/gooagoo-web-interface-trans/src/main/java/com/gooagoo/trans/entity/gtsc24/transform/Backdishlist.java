package com.gooagoo.trans.entity.gtsc24.transform;

import java.io.Serializable;

/**
 *  退菜信息 
 */
public class Backdishlist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 时间戳  */
	private String ctimestamp = "";

	/** 订单编号  */
	private String orderid = "";

	/** 桌号  */
	private String tablename = "";

	/**  商品自定义序列号  */
	private String itemserial = "";

	/**  商品数量  */
	private String goodsnum = "";

	/**  单位  */
	private String onepairnumber = "";

	/**  退菜理由  */
	private String backdishreason = "";

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
	 * 设置 商品自定义序列号 
	 * @param itemserial	 商品自定义序列号 
	 */
	public void setItemserial(String itemserial)
	{
		this.itemserial = itemserial != null ? itemserial : "";
	}

	/**
	 * 获取 商品自定义序列号 
	 * @return	 商品自定义序列号 
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

	/**
	 * 设置 单位 
	 * @param onepairnumber	 单位 
	 */
	public void setOnepairnumber(String onepairnumber)
	{
		this.onepairnumber = onepairnumber != null ? onepairnumber : "";
	}

	/**
	 * 获取 单位 
	 * @return	 单位 
	 */
	public String getOnepairnumber()
	{
		return this.onepairnumber;
	}

	/**
	 * 设置 退菜理由 
	 * @param backdishreason	 退菜理由 
	 */
	public void setBackdishreason(String backdishreason)
	{
		this.backdishreason = backdishreason != null ? backdishreason : "";
	}

	/**
	 * 获取 退菜理由 
	 * @return	 退菜理由 
	 */
	public String getBackdishreason()
	{
		return this.backdishreason;
	}
}