package com.gooagoo.gas.entity.gase03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 消费记录查询
 */
public class UserBillRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 消费记录 */
	private java.util.List<Userbillinfo> userbillinfo = null;

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
	 * 设置消费记录
	 * @param userbillinfo	消费记录
	 */
	public void setUserbillinfo(java.util.List<Userbillinfo> userbillinfo)
	{
		this.userbillinfo = userbillinfo;
	}

	/**
	 * 获取消费记录
	 * @return	消费记录
	 */
	public java.util.List<Userbillinfo> getUserbillinfo()
	{
		return this.userbillinfo;
	}

	/**
	 * 添加消费记录
	 * @return userbillinfo	消费记录
	 */
	public Userbillinfo addMoreUserbillinfo() {
		Userbillinfo userbillinfo = new Userbillinfo();
		this.userbillinfo.add(userbillinfo);
		return userbillinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}