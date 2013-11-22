package com.gooagoo.mobile.entity.mobc05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 吆喝广场下精品推荐  
 */
public class BoutiqueRecommendRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 信息  */
	private java.util.List<Boutiquerecommend> boutiquerecommend = null;

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
	 * 设置信息 
	 * @param boutiquerecommend	信息 
	 */
	public void setBoutiquerecommend(java.util.List<Boutiquerecommend> boutiquerecommend)
	{
		this.boutiquerecommend = boutiquerecommend;
	}

	/**
	 * 获取信息 
	 * @return	信息 
	 */
	public java.util.List<Boutiquerecommend> getBoutiquerecommend()
	{
		return this.boutiquerecommend;
	}

	/**
	 * 添加信息 
	 * @return boutiquerecommend	信息 
	 */
	public Boutiquerecommend addMoreBoutiquerecommend() {
		Boutiquerecommend boutiquerecommend = new Boutiquerecommend();
		this.boutiquerecommend.add(boutiquerecommend);
		return boutiquerecommend;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}