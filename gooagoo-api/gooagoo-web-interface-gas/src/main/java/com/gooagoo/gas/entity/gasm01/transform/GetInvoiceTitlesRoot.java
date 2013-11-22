package com.gooagoo.gas.entity.gasm01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 获取会员发票抬头常用信息
 */
public class GetInvoiceTitlesRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码,true-查询成功,false-查询失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  常用发票抬头信息列表  */
	private java.util.List<Invoicetitles> invoicetitles = null;

	/**
	 * 设置结果编码,true-查询成功,false-查询失败
	 * @param result	结果编码,true-查询成功,false-查询失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码,true-查询成功,false-查询失败
	 * @return	结果编码,true-查询成功,false-查询失败
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
	 * 设置 常用发票抬头信息列表 
	 * @param invoicetitles	 常用发票抬头信息列表 
	 */
	public void setInvoicetitles(java.util.List<Invoicetitles> invoicetitles)
	{
		this.invoicetitles = invoicetitles;
	}

	/**
	 * 获取 常用发票抬头信息列表 
	 * @return	 常用发票抬头信息列表 
	 */
	public java.util.List<Invoicetitles> getInvoicetitles()
	{
		return this.invoicetitles;
	}

	/**
	 * 添加 常用发票抬头信息列表 
	 * @return invoicetitles	 常用发票抬头信息列表 
	 */
	public Invoicetitles addMoreInvoicetitles() {
		Invoicetitles invoicetitles = new Invoicetitles();
		this.invoicetitles.add(invoicetitles);
		return invoicetitles;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}