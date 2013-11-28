package com.gooagoo.mobile.entity.mobc01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  吆喝广场分类接口 
 */
public class CryoutListgRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  一级菜单  */
	private java.util.List<Cryoutlistg> cryoutlistg = null;

	/** 平台已删除的吆喝吆喝编号信息  */
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
	 * 设置 一级菜单 
	 * @param cryoutlistg	 一级菜单 
	 */
	public void setCryoutlistg(java.util.List<Cryoutlistg> cryoutlistg)
	{
		this.cryoutlistg = cryoutlistg;
	}

	/**
	 * 获取 一级菜单 
	 * @return	 一级菜单 
	 */
	public java.util.List<Cryoutlistg> getCryoutlistg()
	{
		return this.cryoutlistg;
	}

	/**
	 * 设置平台已删除的吆喝吆喝编号信息 
	 * @param isdeleted	平台已删除的吆喝吆喝编号信息 
	 */
	public void setIsdeleted(Isdeleted isdeleted)
	{
		this.isdeleted = isdeleted;
	}

	/**
	 * 获取平台已删除的吆喝吆喝编号信息 
	 * @return	平台已删除的吆喝吆喝编号信息 
	 */
	public Isdeleted getIsdeleted()
	{
		return this.isdeleted;
	}

	/**
	 * 添加 一级菜单 
	 * @return cryoutlistg	 一级菜单 
	 */
	public Cryoutlistg addMoreCryoutlistg() {
		Cryoutlistg cryoutlistg = new Cryoutlistg();
		this.cryoutlistg.add(cryoutlistg);
		return cryoutlistg;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}