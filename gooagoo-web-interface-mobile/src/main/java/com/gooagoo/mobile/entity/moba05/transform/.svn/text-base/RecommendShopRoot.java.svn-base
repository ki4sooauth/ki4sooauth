package com.gooagoo.mobile.entity.moba05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户搜索卡时，得到系统推荐的卡 
 */
public class RecommendShopRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  商家信息  */
	private java.util.List<Recommendshop> recommendshop = null;

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
	 * 设置 商家信息 
	 * @param recommendshop	 商家信息 
	 */
	public void setRecommendshop(java.util.List<Recommendshop> recommendshop)
	{
		this.recommendshop = recommendshop;
	}

	/**
	 * 获取 商家信息 
	 * @return	 商家信息 
	 */
	public java.util.List<Recommendshop> getRecommendshop()
	{
		return this.recommendshop;
	}

	/**
	 * 添加 商家信息 
	 * @return recommendshop	 商家信息 
	 */
	public Recommendshop addMoreRecommendshop() {
		Recommendshop recommendshop = new Recommendshop();
		this.recommendshop.add(recommendshop);
		return recommendshop;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}