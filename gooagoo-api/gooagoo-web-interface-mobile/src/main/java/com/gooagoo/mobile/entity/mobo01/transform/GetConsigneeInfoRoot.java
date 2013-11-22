package com.gooagoo.mobile.entity.mobo01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  獲取未删除收货人地址信息 
 */
public class GetConsigneeInfoRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  收货人地址信息 */
	private java.util.List<Consigneeinfo> consigneeinfo = null;

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
	 * 设置 收货人地址信息
	 * @param consigneeinfo	 收货人地址信息
	 */
	public void setConsigneeinfo(java.util.List<Consigneeinfo> consigneeinfo)
	{
		this.consigneeinfo = consigneeinfo;
	}

	/**
	 * 获取 收货人地址信息
	 * @return	 收货人地址信息
	 */
	public java.util.List<Consigneeinfo> getConsigneeinfo()
	{
		return this.consigneeinfo;
	}

	/**
	 * 添加 收货人地址信息
	 * @return consigneeinfo	 收货人地址信息
	 */
	public Consigneeinfo addMoreConsigneeinfo() {
		Consigneeinfo consigneeinfo = new Consigneeinfo();
		this.consigneeinfo.add(consigneeinfo);
		return consigneeinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}