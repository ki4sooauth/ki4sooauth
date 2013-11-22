package com.gooagoo.gas.entity.gasj02.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 排队
 */
public class QueueRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  当前排队号码  */
	private String present = null;

	/** 已到排队号码   */
	private String alreadyno = null;

	/**
	 * 设置结果编码，true成功，false失败
	 * @param result	结果编码，true成功，false失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true成功，false失败
	 * @return	结果编码，true成功，false失败
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置结果描述
	 * @param msg	结果描述
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取结果描述
	 * @return	结果描述
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
	 * 设置 当前排队号码 
	 * @param present	 当前排队号码 
	 */
	public void setPresent(String present)
	{
		this.present = present != null ? present : "";
	}

	/**
	 * 获取 当前排队号码 
	 * @return	 当前排队号码 
	 */
	public String getPresent()
	{
		return this.present;
	}

	/**
	 * 设置已到排队号码  
	 * @param alreadyno	已到排队号码  
	 */
	public void setAlreadyno(String alreadyno)
	{
		this.alreadyno = alreadyno != null ? alreadyno : "";
	}

	/**
	 * 获取已到排队号码  
	 * @return	已到排队号码  
	 */
	public String getAlreadyno()
	{
		return this.alreadyno;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}