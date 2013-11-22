package com.gooagoo.trans.entity.gtsc24.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 退菜信息 
 */
public class BackDishRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  退菜信息  */
	private java.util.List<Backdishlist> backdishlist = null;

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
	 * 设置 退菜信息 
	 * @param backdishlist	 退菜信息 
	 */
	public void setBackdishlist(java.util.List<Backdishlist> backdishlist)
	{
		this.backdishlist = backdishlist;
	}

	/**
	 * 获取 退菜信息 
	 * @return	 退菜信息 
	 */
	public java.util.List<Backdishlist> getBackdishlist()
	{
		return this.backdishlist;
	}

	/**
	 * 添加 退菜信息 
	 * @return backdishlist	 退菜信息 
	 */
	public Backdishlist addMoreBackdishlist() {
		Backdishlist backdishlist = new Backdishlist();
		this.backdishlist.add(backdishlist);
		return backdishlist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}