package com.gooagoo.mobile.entity.mobc06.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  商家吆喝（商家服务器） 
 */
public class CryoutListsRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  商家吆喝  */
	private java.util.List<Cryoutlists> cryoutlists = null;

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
	 * 设置 商家吆喝 
	 * @param cryoutlists	 商家吆喝 
	 */
	public void setCryoutlists(java.util.List<Cryoutlists> cryoutlists)
	{
		this.cryoutlists = cryoutlists;
	}

	/**
	 * 获取 商家吆喝 
	 * @return	 商家吆喝 
	 */
	public java.util.List<Cryoutlists> getCryoutlists()
	{
		return this.cryoutlists;
	}

	/**
	 * 添加 商家吆喝 
	 * @return cryoutlists	 商家吆喝 
	 */
	public Cryoutlists addMoreCryoutlists() {
		Cryoutlists cryoutlists = new Cryoutlists();
		this.cryoutlists.add(cryoutlists);
		return cryoutlists;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}