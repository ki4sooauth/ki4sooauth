package com.gooagoo.trans.entity.gtsc14.transform;

import java.io.Serializable;

/**
 * 加减菜信息 
 */
public class OrderAddOrSubbaseinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 桌号  */
	private String deskno = "";

	/**  订单详细信息  */
	private java.util.List<OrderAddOrSubdetailinfo> orderAddOrSubdetailinfo = new java.util.ArrayList<OrderAddOrSubdetailinfo>();

	/**
	 * 设置桌号 
	 * @param deskno	桌号 
	 */
	public void setDeskno(String deskno)
	{
		this.deskno = deskno != null ? deskno : "";
	}

	/**
	 * 获取桌号 
	 * @return	桌号 
	 */
	public String getDeskno()
	{
		return this.deskno;
	}

	/**
	 * 设置 订单详细信息 
	 * @param orderAddOrSubdetailinfo	 订单详细信息 
	 */
	public void setOrderAddOrSubdetailinfo(java.util.List<OrderAddOrSubdetailinfo> orderAddOrSubdetailinfo)
	{
		this.orderAddOrSubdetailinfo = orderAddOrSubdetailinfo;
	}

	/**
	 * 获取 订单详细信息 
	 * @return	 订单详细信息 
	 */
	public java.util.List<OrderAddOrSubdetailinfo> getOrderAddOrSubdetailinfo()
	{
		return this.orderAddOrSubdetailinfo;
	}

	/**
	 * 添加 订单详细信息 
	 * @return orderAddOrSubdetailinfo	 订单详细信息 
	 */
	public OrderAddOrSubdetailinfo addMoreOrderAddOrSubdetailinfo() {
		OrderAddOrSubdetailinfo orderAddOrSubdetailinfo = new OrderAddOrSubdetailinfo();
		this.orderAddOrSubdetailinfo.add(orderAddOrSubdetailinfo);
		return orderAddOrSubdetailinfo;
	}
}