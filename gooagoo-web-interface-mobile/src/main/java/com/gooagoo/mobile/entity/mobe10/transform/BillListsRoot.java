package com.gooagoo.mobile.entity.mobe10.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户根据账单信息开发票 
 */
public class BillListsRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 账单信息  */
	private java.util.List<Billlists> billlists = null;

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
	 * 设置账单信息 
	 * @param billlists	账单信息 
	 */
	public void setBilllists(java.util.List<Billlists> billlists)
	{
		this.billlists = billlists;
	}

	/**
	 * 获取账单信息 
	 * @return	账单信息 
	 */
	public java.util.List<Billlists> getBilllists()
	{
		return this.billlists;
	}

	/**
	 * 添加账单信息 
	 * @return billlists	账单信息 
	 */
	public Billlists addMoreBilllists() {
		Billlists billlists = new Billlists();
		this.billlists.add(billlists);
		return billlists;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}