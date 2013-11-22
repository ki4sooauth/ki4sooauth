package com.gooagoo.gas.entity.gase01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 店里所有会员列表查询
 */
public class UserListRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 店里所有会员列表信息 */
	private java.util.List<UserInfo> userInfo = null;

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
	 * 设置店里所有会员列表信息
	 * @param userInfo	店里所有会员列表信息
	 */
	public void setUserInfo(java.util.List<UserInfo> userInfo)
	{
		this.userInfo = userInfo;
	}

	/**
	 * 获取店里所有会员列表信息
	 * @return	店里所有会员列表信息
	 */
	public java.util.List<UserInfo> getUserInfo()
	{
		return this.userInfo;
	}

	/**
	 * 添加店里所有会员列表信息
	 * @return userInfo	店里所有会员列表信息
	 */
	public UserInfo addMoreUserInfo() {
		UserInfo userInfo = new UserInfo();
		this.userInfo.add(userInfo);
		return userInfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}