package com.gooagoo.mobile.entity.mobe01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户根据账单信息开发票 
 */
public class BillListgRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 账单信息  */
	private java.util.List<Billlistg> billlistg = null;

	/** 平台已删除的账单编号信息  */
	private Isdeleted isdeleted = null;

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
	 * @param billlistg	账单信息 
	 */
	public void setBilllistg(java.util.List<Billlistg> billlistg)
	{
		this.billlistg = billlistg;
	}

	/**
	 * 获取账单信息 
	 * @return	账单信息 
	 */
	public java.util.List<Billlistg> getBilllistg()
	{
		return this.billlistg;
	}

	/**
	 * 设置平台已删除的账单编号信息 
	 * @param isdeleted	平台已删除的账单编号信息 
	 */
	public void setIsdeleted(Isdeleted isdeleted)
	{
		this.isdeleted = isdeleted;
	}

	/**
	 * 获取平台已删除的账单编号信息 
	 * @return	平台已删除的账单编号信息 
	 */
	public Isdeleted getIsdeleted()
	{
		return this.isdeleted;
	}

	/**
	 * 添加账单信息 
	 * @return billlistg	账单信息 
	 */
	public Billlistg addMoreBilllistg() {
		Billlistg billlistg = new Billlistg();
		this.billlistg.add(billlistg);
		return billlistg;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}