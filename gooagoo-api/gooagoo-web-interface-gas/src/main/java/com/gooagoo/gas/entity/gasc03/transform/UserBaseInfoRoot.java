package com.gooagoo.gas.entity.gasc03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 会员信息查询 
 */
public class UserBaseInfoRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 会员信息 */
	private Userbaseinfo userbaseinfo = null;

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
	 * 设置会员信息
	 * @param userbaseinfo	会员信息
	 */
	public void setUserbaseinfo(Userbaseinfo userbaseinfo)
	{
		this.userbaseinfo = userbaseinfo;
	}

	/**
	 * 获取会员信息
	 * @return	会员信息
	 */
	public Userbaseinfo getUserbaseinfo()
	{
		return this.userbaseinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}