package com.gooagoo.gas.entity.gasj01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 餐桌状态
 */
public class DeskStatusRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 餐桌状态 */
	private java.util.List<Deskstatuslist> deskstatuslist = null;

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
	 * 设置餐桌状态
	 * @param deskstatuslist	餐桌状态
	 */
	public void setDeskstatuslist(java.util.List<Deskstatuslist> deskstatuslist)
	{
		this.deskstatuslist = deskstatuslist;
	}

	/**
	 * 获取餐桌状态
	 * @return	餐桌状态
	 */
	public java.util.List<Deskstatuslist> getDeskstatuslist()
	{
		return this.deskstatuslist;
	}

	/**
	 * 添加餐桌状态
	 * @return deskstatuslist	餐桌状态
	 */
	public Deskstatuslist addMoreDeskstatuslist() {
		Deskstatuslist deskstatuslist = new Deskstatuslist();
		this.deskstatuslist.add(deskstatuslist);
		return deskstatuslist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}