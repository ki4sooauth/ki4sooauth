package com.gooagoo.mobile.entity.mobp01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  獲取用户未删除的用户发票抬头信息
 */
public class GetReceiptInfoRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  用户发票抬头信息 */
	private java.util.List<Receiptinfo> receiptinfo = null;

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
	 * 设置 用户发票抬头信息
	 * @param receiptinfo	 用户发票抬头信息
	 */
	public void setReceiptinfo(java.util.List<Receiptinfo> receiptinfo)
	{
		this.receiptinfo = receiptinfo;
	}

	/**
	 * 获取 用户发票抬头信息
	 * @return	 用户发票抬头信息
	 */
	public java.util.List<Receiptinfo> getReceiptinfo()
	{
		return this.receiptinfo;
	}

	/**
	 * 添加 用户发票抬头信息
	 * @return receiptinfo	 用户发票抬头信息
	 */
	public Receiptinfo addMoreReceiptinfo() {
		Receiptinfo receiptinfo = new Receiptinfo();
		this.receiptinfo.add(receiptinfo);
		return receiptinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}