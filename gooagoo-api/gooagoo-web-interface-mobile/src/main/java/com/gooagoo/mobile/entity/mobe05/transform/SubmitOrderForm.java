package com.gooagoo.mobile.entity.mobe05.transform;

import java.io.Serializable;

/**
 * 订单 
 */
public class SubmitOrderForm implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 订单号 */
	private String orderid = "";

	/**
	 * 设置订单号
	 * @param orderid	订单号
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取订单号
	 * @return	订单号
	 */
	public String getOrderid()
	{
		return this.orderid;
	}
}