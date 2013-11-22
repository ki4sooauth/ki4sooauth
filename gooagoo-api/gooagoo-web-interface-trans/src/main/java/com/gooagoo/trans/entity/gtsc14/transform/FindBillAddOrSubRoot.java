package com.gooagoo.trans.entity.gtsc14.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 加菜减菜申请查询 
 */
public class FindBillAddOrSubRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true查询成功，false查询失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 加减菜信息  */
	private java.util.List<OrderAddOrSubbaseinfo> orderAddOrSubbaseinfo = null;

	/**
	 * 设置结果编码，true查询成功，false查询失败 
	 * @param result	结果编码，true查询成功，false查询失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true查询成功，false查询失败 
	 * @return	结果编码，true查询成功，false查询失败 
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置结果描述 
	 * @param msg	结果描述 
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取结果描述 
	 * @return	结果描述 
	 */
	public String getMsg()
	{
		return this.msg;
	}

	/**
	 * 设置 提示信息编号 
	 * @param msgcode	 提示信息编号 
	 */
	public void setMsgcode(String msgcode)
	{
		this.msgcode = msgcode != null ? msgcode : "";
	}

	/**
	 * 获取 提示信息编号 
	 * @return	 提示信息编号 
	 */
	public String getMsgcode()
	{
		return this.msgcode;
	}

	/**
	 * 设置加减菜信息 
	 * @param orderAddOrSubbaseinfo	加减菜信息 
	 */
	public void setOrderAddOrSubbaseinfo(java.util.List<OrderAddOrSubbaseinfo> orderAddOrSubbaseinfo)
	{
		this.orderAddOrSubbaseinfo = orderAddOrSubbaseinfo;
	}

	/**
	 * 获取加减菜信息 
	 * @return	加减菜信息 
	 */
	public java.util.List<OrderAddOrSubbaseinfo> getOrderAddOrSubbaseinfo()
	{
		return this.orderAddOrSubbaseinfo;
	}

	/**
	 * 添加加减菜信息 
	 * @return orderAddOrSubbaseinfo	加减菜信息 
	 */
	public OrderAddOrSubbaseinfo addMoreOrderAddOrSubbaseinfo() {
		OrderAddOrSubbaseinfo orderAddOrSubbaseinfo = new OrderAddOrSubbaseinfo();
		this.orderAddOrSubbaseinfo.add(orderAddOrSubbaseinfo);
		return orderAddOrSubbaseinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}