package com.gooagoo.mobile.entity.mobb06.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  收藏广场分类接口 
 */
public class FavoritePlazaMenuRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  一级菜单  */
	private java.util.List<Firstmenu> firstmenu = null;

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
	 * @param firstmenu	 一级菜单 
	 */
	public void setFirstmenu(java.util.List<Firstmenu> firstmenu)
	{
		this.firstmenu = firstmenu;
	}

	/**
	 * 获取 一级菜单 
	 * @return	 一级菜单 
	 */
	public java.util.List<Firstmenu> getFirstmenu()
	{
		return this.firstmenu;
	}

	/**
	 * 添加 一级菜单 
	 * @return firstmenu	 一级菜单 
	 */
	public Firstmenu addMoreFirstmenu() {
		Firstmenu firstmenu = new Firstmenu();
		this.firstmenu.add(firstmenu);
		return firstmenu;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}