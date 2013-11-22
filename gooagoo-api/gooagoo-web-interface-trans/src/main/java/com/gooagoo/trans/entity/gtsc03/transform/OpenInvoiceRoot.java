package com.gooagoo.trans.entity.gtsc03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 打印发票申请
 */
public class OpenInvoiceRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true查询成功，false查询失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 所要打印票信息 */
	private java.util.List<Openinvoiceinfo> openinvoiceinfo = null;

	/**
	 * 设置结果编码，true查询成功，false查询失败
	 * @param result	结果编码，true查询成功，false查询失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true查询成功，false查询失败
	 * @return	结果编码，true查询成功，false查询失败
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
	 * 设置所要打印票信息
	 * @param openinvoiceinfo	所要打印票信息
	 */
	public void setOpeninvoiceinfo(java.util.List<Openinvoiceinfo> openinvoiceinfo)
	{
		this.openinvoiceinfo = openinvoiceinfo;
	}

	/**
	 * 获取所要打印票信息
	 * @return	所要打印票信息
	 */
	public java.util.List<Openinvoiceinfo> getOpeninvoiceinfo()
	{
		return this.openinvoiceinfo;
	}

	/**
	 * 添加所要打印票信息
	 * @return openinvoiceinfo	所要打印票信息
	 */
	public Openinvoiceinfo addMoreOpeninvoiceinfo() {
		Openinvoiceinfo openinvoiceinfo = new Openinvoiceinfo();
		this.openinvoiceinfo.add(openinvoiceinfo);
		return openinvoiceinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}