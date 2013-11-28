package com.gooagoo.mobile.entity.mobi04.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  导航（起点{x,y}，实体店编号或商品编号） 
 */
public class NavigationBRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  导航信息 */
	private java.util.List<Navigationtoshoporgoods> navigationtoshoporgoods = null;

	/**
	 * 设置查询结果编码，true-成功，false-失败 
	 * @param result	查询结果编码，true-成功，false-失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取查询结果编码，true-成功，false-失败 
	 * @return	查询结果编码，true-成功，false-失败 
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置查询失败描述 
	 * @param msg	查询失败描述 
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取查询失败描述 
	 * @return	查询失败描述 
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
	 * 设置 导航信息
	 * @param navigationtoshoporgoods	 导航信息
	 */
	public void setNavigationtoshoporgoods(java.util.List<Navigationtoshoporgoods> navigationtoshoporgoods)
	{
		this.navigationtoshoporgoods = navigationtoshoporgoods;
	}

	/**
	 * 获取 导航信息
	 * @return	 导航信息
	 */
	public java.util.List<Navigationtoshoporgoods> getNavigationtoshoporgoods()
	{
		return this.navigationtoshoporgoods;
	}

	/**
	 * 添加 导航信息
	 * @return navigationtoshoporgoods	 导航信息
	 */
	public Navigationtoshoporgoods addMoreNavigationtoshoporgoods() {
		Navigationtoshoporgoods navigationtoshoporgoods = new Navigationtoshoporgoods();
		this.navigationtoshoporgoods.add(navigationtoshoporgoods);
		return navigationtoshoporgoods;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}