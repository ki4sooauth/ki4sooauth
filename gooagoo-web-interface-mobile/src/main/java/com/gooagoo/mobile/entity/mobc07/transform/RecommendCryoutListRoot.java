package com.gooagoo.mobile.entity.mobc07.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  推荐吆喝接口 
 */
public class RecommendCryoutListRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  推荐吆喝  */
	private java.util.List<Recommendcryoutlist> recommendcryoutlist = null;

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
	 * 设置 推荐吆喝 
	 * @param recommendcryoutlist	 推荐吆喝 
	 */
	public void setRecommendcryoutlist(java.util.List<Recommendcryoutlist> recommendcryoutlist)
	{
		this.recommendcryoutlist = recommendcryoutlist;
	}

	/**
	 * 获取 推荐吆喝 
	 * @return	 推荐吆喝 
	 */
	public java.util.List<Recommendcryoutlist> getRecommendcryoutlist()
	{
		return this.recommendcryoutlist;
	}

	/**
	 * 添加 推荐吆喝 
	 * @return recommendcryoutlist	 推荐吆喝 
	 */
	public Recommendcryoutlist addMoreRecommendcryoutlist() {
		Recommendcryoutlist recommendcryoutlist = new Recommendcryoutlist();
		this.recommendcryoutlist.add(recommendcryoutlist);
		return recommendcryoutlist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}