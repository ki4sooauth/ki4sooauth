package com.gooagoo.gas.entity.gase02.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * TA的收藏商品查询 
 */
public class UserFavRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-查询成功，false-查询失败  */
	private String result = null;

	/** 查询结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** TA的收藏商品信息  */
	private java.util.List<UserFavInfo> userFavInfo = null;

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
	 * 设置TA的收藏商品信息 
	 * @param userFavInfo	TA的收藏商品信息 
	 */
	public void setUserFavInfo(java.util.List<UserFavInfo> userFavInfo)
	{
		this.userFavInfo = userFavInfo;
	}

	/**
	 * 获取TA的收藏商品信息 
	 * @return	TA的收藏商品信息 
	 */
	public java.util.List<UserFavInfo> getUserFavInfo()
	{
		return this.userFavInfo;
	}

	/**
	 * 添加TA的收藏商品信息 
	 * @return userFavInfo	TA的收藏商品信息 
	 */
	public UserFavInfo addMoreUserFavInfo() {
		UserFavInfo userFavInfo = new UserFavInfo();
		this.userFavInfo.add(userFavInfo);
		return userFavInfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}