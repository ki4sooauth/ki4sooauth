package com.gooagoo.mobile.entity.moba12.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户是否同意发卡
 */
public class AgreeCardRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 操作结果编码，true-成功，false-失败  */
	private String result = null;

	/** 操作失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  用户会员卡信息  */
	private Usermembercard usermembercard = null;

	/**
	 * 设置操作结果编码，true-成功，false-失败 
	 * @param result	操作结果编码，true-成功，false-失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取操作结果编码，true-成功，false-失败 
	 * @return	操作结果编码，true-成功，false-失败 
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置操作失败描述 
	 * @param msg	操作失败描述 
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取操作失败描述 
	 * @return	操作失败描述 
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
	 * 设置 用户会员卡信息 
	 * @param usermembercard	 用户会员卡信息 
	 */
	public void setUsermembercard(Usermembercard usermembercard)
	{
		this.usermembercard = usermembercard;
	}

	/**
	 * 获取 用户会员卡信息 
	 * @return	 用户会员卡信息 
	 */
	public Usermembercard getUsermembercard()
	{
		return this.usermembercard;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}