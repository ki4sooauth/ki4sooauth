package com.gooagoo.mobile.entity.mobk02.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  消费记录 
 */
public class GetConsumeRecordByMonthRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  消费日 */
	private java.util.List<Daylist> daylist = null;

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
	 * 设置 消费日
	 * @param daylist	 消费日
	 */
	public void setDaylist(java.util.List<Daylist> daylist)
	{
		this.daylist = daylist;
	}

	/**
	 * 获取 消费日
	 * @return	 消费日
	 */
	public java.util.List<Daylist> getDaylist()
	{
		return this.daylist;
	}

	/**
	 * 添加 消费日
	 * @return daylist	 消费日
	 */
	public Daylist addMoreDaylist() {
		Daylist daylist = new Daylist();
		this.daylist.add(daylist);
		return daylist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}