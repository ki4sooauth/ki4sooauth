package com.gooagoo.mobile.entity.mobd03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  活动查询 
 */
public class MarketingactivityRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  活动查询  */
	private java.util.List<Marketingactivity> marketingactivity = null;

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
	 * 设置 活动查询 
	 * @param marketingactivity	 活动查询 
	 */
	public void setMarketingactivity(java.util.List<Marketingactivity> marketingactivity)
	{
		this.marketingactivity = marketingactivity;
	}

	/**
	 * 获取 活动查询 
	 * @return	 活动查询 
	 */
	public java.util.List<Marketingactivity> getMarketingactivity()
	{
		return this.marketingactivity;
	}

	/**
	 * 添加 活动查询 
	 * @return marketingactivity	 活动查询 
	 */
	public Marketingactivity addMoreMarketingactivity() {
		Marketingactivity marketingactivity = new Marketingactivity();
		this.marketingactivity.add(marketingactivity);
		return marketingactivity;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}