package com.gooagoo.mobile.entity.mobb08.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  商家精品查询 
 */
public class ChoiceListRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  商家信息  */
	private Shopinfo shopinfo = null;

	/**  精品信息  */
	private java.util.List<Objinfo> objinfo = null;

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
	 * 设置 商家信息 
	 * @param shopinfo	 商家信息 
	 */
	public void setShopinfo(Shopinfo shopinfo)
	{
		this.shopinfo = shopinfo;
	}

	/**
	 * 获取 商家信息 
	 * @return	 商家信息 
	 */
	public Shopinfo getShopinfo()
	{
		return this.shopinfo;
	}

	/**
	 * 设置 精品信息 
	 * @param objinfo	 精品信息 
	 */
	public void setObjinfo(java.util.List<Objinfo> objinfo)
	{
		this.objinfo = objinfo;
	}

	/**
	 * 获取 精品信息 
	 * @return	 精品信息 
	 */
	public java.util.List<Objinfo> getObjinfo()
	{
		return this.objinfo;
	}

	/**
	 * 添加 精品信息 
	 * @return objinfo	 精品信息 
	 */
	public Objinfo addMoreObjinfo() {
		Objinfo objinfo = new Objinfo();
		this.objinfo.add(objinfo);
		return objinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}