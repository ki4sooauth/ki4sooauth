package com.gooagoo.trans.entity.gtsc19.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 开台信息 
 */
public class OpenTableRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  开台信息  */
	private java.util.List<Opentablelist> opentablelist = null;

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
	 * 设置 开台信息 
	 * @param opentablelist	 开台信息 
	 */
	public void setOpentablelist(java.util.List<Opentablelist> opentablelist)
	{
		this.opentablelist = opentablelist;
	}

	/**
	 * 获取 开台信息 
	 * @return	 开台信息 
	 */
	public java.util.List<Opentablelist> getOpentablelist()
	{
		return this.opentablelist;
	}

	/**
	 * 添加 开台信息 
	 * @return opentablelist	 开台信息 
	 */
	public Opentablelist addMoreOpentablelist() {
		Opentablelist opentablelist = new Opentablelist();
		this.opentablelist.add(opentablelist);
		return opentablelist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}