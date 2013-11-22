package com.gooagoo.mobile.entity.mobc03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 吆喝广场商家查询:输入参数:分类编码 |关键字 
 */
public class CryoutPlazaShopListRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 吆喝广场商家查询  */
	private java.util.List<Shoplist> shoplist = null;

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
	 * 设置吆喝广场商家查询 
	 * @param shoplist	吆喝广场商家查询 
	 */
	public void setShoplist(java.util.List<Shoplist> shoplist)
	{
		this.shoplist = shoplist;
	}

	/**
	 * 获取吆喝广场商家查询 
	 * @return	吆喝广场商家查询 
	 */
	public java.util.List<Shoplist> getShoplist()
	{
		return this.shoplist;
	}

	/**
	 * 添加吆喝广场商家查询 
	 * @return shoplist	吆喝广场商家查询 
	 */
	public Shoplist addMoreShoplist() {
		Shoplist shoplist = new Shoplist();
		this.shoplist.add(shoplist);
		return shoplist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}