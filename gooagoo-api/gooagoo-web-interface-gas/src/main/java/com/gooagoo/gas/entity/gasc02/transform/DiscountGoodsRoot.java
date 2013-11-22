package com.gooagoo.gas.entity.gasc02.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 品类优惠查询
 */
public class DiscountGoodsRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 品类优惠信息 */
	private java.util.List<Discountgoods> discountgoods = null;

	/**
	 * 设置查询结果编码，true-查询成功，false-查询失败
	 * @param result	查询结果编码，true-查询成功，false-查询失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取查询结果编码，true-查询成功，false-查询失败
	 * @return	查询结果编码，true-查询成功，false-查询失败
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置查询结果描述
	 * @param msg	查询结果描述
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取查询结果描述
	 * @return	查询结果描述
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
	 * 设置品类优惠信息
	 * @param discountgoods	品类优惠信息
	 */
	public void setDiscountgoods(java.util.List<Discountgoods> discountgoods)
	{
		this.discountgoods = discountgoods;
	}

	/**
	 * 获取品类优惠信息
	 * @return	品类优惠信息
	 */
	public java.util.List<Discountgoods> getDiscountgoods()
	{
		return this.discountgoods;
	}

	/**
	 * 添加品类优惠信息
	 * @return discountgoods	品类优惠信息
	 */
	public Discountgoods addMoreDiscountgoods() {
		Discountgoods discountgoods = new Discountgoods();
		this.discountgoods.add(discountgoods);
		return discountgoods;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}