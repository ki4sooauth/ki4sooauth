package com.gooagoo.mobile.entity.mobk01.transform;

import java.io.Serializable;

/**
 *  消费记录信息
 */
public class Consumelists implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 当日订单数目  */
	private String ordernum = "";

	/** 当日账单数目  */
	private String billnum = "";

	/** 当日活动  */
	private String activitynum = "";

	/** 购物清单  */
	private String shopinglistnum = "";

	/**
	 * 设置当日订单数目 
	 * @param ordernum	当日订单数目 
	 */
	public void setOrdernum(String ordernum)
	{
		this.ordernum = ordernum != null ? ordernum : "";
	}

	/**
	 * 获取当日订单数目 
	 * @return	当日订单数目 
	 */
	public String getOrdernum()
	{
		return this.ordernum;
	}

	/**
	 * 设置当日账单数目 
	 * @param billnum	当日账单数目 
	 */
	public void setBillnum(String billnum)
	{
		this.billnum = billnum != null ? billnum : "";
	}

	/**
	 * 获取当日账单数目 
	 * @return	当日账单数目 
	 */
	public String getBillnum()
	{
		return this.billnum;
	}

	/**
	 * 设置当日活动 
	 * @param activitynum	当日活动 
	 */
	public void setActivitynum(String activitynum)
	{
		this.activitynum = activitynum != null ? activitynum : "";
	}

	/**
	 * 获取当日活动 
	 * @return	当日活动 
	 */
	public String getActivitynum()
	{
		return this.activitynum;
	}

	/**
	 * 设置购物清单 
	 * @param shopinglistnum	购物清单 
	 */
	public void setShopinglistnum(String shopinglistnum)
	{
		this.shopinglistnum = shopinglistnum != null ? shopinglistnum : "";
	}

	/**
	 * 获取购物清单 
	 * @return	购物清单 
	 */
	public String getShopinglistnum()
	{
		return this.shopinglistnum;
	}
}