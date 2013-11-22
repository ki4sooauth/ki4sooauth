package com.gooagoo.gas.entity.gase05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 店内踪迹查询
 */
public class UserTrackRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 店内踪迹信息 */
	private java.util.List<UserTrackInfo> userTrackInfo = null;

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
	 * 设置店内踪迹信息
	 * @param userTrackInfo	店内踪迹信息
	 */
	public void setUserTrackInfo(java.util.List<UserTrackInfo> userTrackInfo)
	{
		this.userTrackInfo = userTrackInfo;
	}

	/**
	 * 获取店内踪迹信息
	 * @return	店内踪迹信息
	 */
	public java.util.List<UserTrackInfo> getUserTrackInfo()
	{
		return this.userTrackInfo;
	}

	/**
	 * 添加店内踪迹信息
	 * @return userTrackInfo	店内踪迹信息
	 */
	public UserTrackInfo addMoreUserTrackInfo() {
		UserTrackInfo userTrackInfo = new UserTrackInfo();
		this.userTrackInfo.add(userTrackInfo);
		return userTrackInfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}