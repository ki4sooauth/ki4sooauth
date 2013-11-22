package com.gooagoo.trans.entity.gtsc16.transform;

import java.io.Serializable;

/**
 *  催菜信息 
 */
public class Horderinfolist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 时间戳  */
	private String ctimestamp = "";

	/** 订单编号  */
	private String orderid = "";

	/** 催菜种类 ***整桌：0，按菜品类别催菜：1，按菜品催菜：2  */
	private String type = "";

	/** 桌号 */
	private String tablename = "";

	/**  商品条形码（自定义序列号）  */
	private String itemserial = "";

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
	 * 设置催菜种类 ***整桌：0，按菜品类别催菜：1，按菜品催菜：2 
	 * @param type	催菜种类 ***整桌：0，按菜品类别催菜：1，按菜品催菜：2 
	 */
	public void setType(String type)
	{
		this.type = type != null ? type : "";
	}

	/**
	 * 获取催菜种类 ***整桌：0，按菜品类别催菜：1，按菜品催菜：2 
	 * @return	催菜种类 ***整桌：0，按菜品类别催菜：1，按菜品催菜：2 
	 */
	public String getType()
	{
		return this.type;
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
}