package com.gooagoo.gas.entity.gase03.transform;

import java.io.Serializable;

/**
 * 消费记录
 */
public class Userbillinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 总金额 */
	private String payprice = "";

	/**  订单编号  */
	private String orderid = "";

	/** 消费时间 */
	private String requesttime = "";

	/**
	 * 设置总金额
	 * @param payprice	总金额
	 */
	public void setPayprice(String payprice)
	{
		this.payprice = payprice != null ? payprice : "";
	}

	/**
	 * 获取总金额
	 * @return	总金额
	 */
	public String getPayprice()
	{
		return this.payprice;
	}

	/**
	 * 设置 订单编号 
	 * @param orderid	 订单编号 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取 订单编号 
	 * @return	 订单编号 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置消费时间
	 * @param requesttime	消费时间
	 */
	public void setRequesttime(String requesttime)
	{
		this.requesttime = requesttime != null ? requesttime : "";
	}

	/**
	 * 获取消费时间
	 * @return	消费时间
	 */
	public String getRequesttime()
	{
		return this.requesttime;
	}
}