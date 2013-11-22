package com.gooagoo.trans.entity.gtsc16.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 催菜 
 */
public class HurryOrderRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  催菜信息  */
	private java.util.List<Horderinfolist> horderinfolist = null;

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
	 * 设置 催菜信息 
	 * @param horderinfolist	 催菜信息 
	 */
	public void setHorderinfolist(java.util.List<Horderinfolist> horderinfolist)
	{
		this.horderinfolist = horderinfolist;
	}

	/**
	 * 获取 催菜信息 
	 * @return	 催菜信息 
	 */
	public java.util.List<Horderinfolist> getHorderinfolist()
	{
		return this.horderinfolist;
	}

	/**
	 * 添加 催菜信息 
	 * @return horderinfolist	 催菜信息 
	 */
	public Horderinfolist addMoreHorderinfolist() {
		Horderinfolist horderinfolist = new Horderinfolist();
		this.horderinfolist.add(horderinfolist);
		return horderinfolist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}