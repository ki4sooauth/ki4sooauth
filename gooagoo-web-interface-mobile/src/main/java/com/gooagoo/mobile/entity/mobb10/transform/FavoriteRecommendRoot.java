package com.gooagoo.mobile.entity.mobb10.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  搜索收藏推荐 
 */
public class FavoriteRecommendRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  收藏信息  */
	private java.util.List<Favoriterecommend> favoriterecommend = null;

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
	 * 设置 收藏信息 
	 * @param favoriterecommend	 收藏信息 
	 */
	public void setFavoriterecommend(java.util.List<Favoriterecommend> favoriterecommend)
	{
		this.favoriterecommend = favoriterecommend;
	}

	/**
	 * 获取 收藏信息 
	 * @return	 收藏信息 
	 */
	public java.util.List<Favoriterecommend> getFavoriterecommend()
	{
		return this.favoriterecommend;
	}

	/**
	 * 添加 收藏信息 
	 * @return favoriterecommend	 收藏信息 
	 */
	public Favoriterecommend addMoreFavoriterecommend() {
		Favoriterecommend favoriterecommend = new Favoriterecommend();
		this.favoriterecommend.add(favoriterecommend);
		return favoriterecommend;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}