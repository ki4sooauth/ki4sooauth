package com.gooagoo.trans.entity.gtsc01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 结账申请信息查询
 */
public class BillPayRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true查询成功，false查询失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 结账通知信息 */
	private java.util.List<Billpay> billpay = null;

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
	 * 设置结账通知信息
	 * @param billpay	结账通知信息
	 */
	public void setBillpay(java.util.List<Billpay> billpay)
	{
		this.billpay = billpay;
	}

	/**
	 * 获取结账通知信息
	 * @return	结账通知信息
	 */
	public java.util.List<Billpay> getBillpay()
	{
		return this.billpay;
	}

	/**
	 * 添加结账通知信息
	 * @return billpay	结账通知信息
	 */
	public Billpay addMoreBillpay() {
		Billpay billpay = new Billpay();
		this.billpay.add(billpay);
		return billpay;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}