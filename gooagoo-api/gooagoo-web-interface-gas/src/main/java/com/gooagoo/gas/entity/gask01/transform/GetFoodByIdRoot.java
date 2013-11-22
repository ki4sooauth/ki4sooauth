package com.gooagoo.gas.entity.gask01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 按名称编号查询菜品
 */
public class GetFoodByIdRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 餐饮商品详细返回信息 */
	private java.util.List<Foodinfolist> foodinfolist = null;

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
	 * 设置餐饮商品详细返回信息
	 * @param foodinfolist	餐饮商品详细返回信息
	 */
	public void setFoodinfolist(java.util.List<Foodinfolist> foodinfolist)
	{
		this.foodinfolist = foodinfolist;
	}

	/**
	 * 获取餐饮商品详细返回信息
	 * @return	餐饮商品详细返回信息
	 */
	public java.util.List<Foodinfolist> getFoodinfolist()
	{
		return this.foodinfolist;
	}

	/**
	 * 添加餐饮商品详细返回信息
	 * @return foodinfolist	餐饮商品详细返回信息
	 */
	public Foodinfolist addMoreFoodinfolist() {
		Foodinfolist foodinfolist = new Foodinfolist();
		this.foodinfolist.add(foodinfolist);
		return foodinfolist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}