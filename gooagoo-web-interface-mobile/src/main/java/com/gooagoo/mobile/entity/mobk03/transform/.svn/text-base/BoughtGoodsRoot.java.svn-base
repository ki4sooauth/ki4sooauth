package com.gooagoo.mobile.entity.mobk03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  已购买过的商品 
 */
public class BoughtGoodsRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  购买够商品信息 */
	private java.util.List<BoughtGoodslist> boughtGoodslist = null;

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
	 * 设置 购买够商品信息
	 * @param boughtGoodslist	 购买够商品信息
	 */
	public void setBoughtGoodslist(java.util.List<BoughtGoodslist> boughtGoodslist)
	{
		this.boughtGoodslist = boughtGoodslist;
	}

	/**
	 * 获取 购买够商品信息
	 * @return	 购买够商品信息
	 */
	public java.util.List<BoughtGoodslist> getBoughtGoodslist()
	{
		return this.boughtGoodslist;
	}

	/**
	 * 添加 购买够商品信息
	 * @return boughtGoodslist	 购买够商品信息
	 */
	public BoughtGoodslist addMoreBoughtGoodslist() {
		BoughtGoodslist boughtGoodslist = new BoughtGoodslist();
		this.boughtGoodslist.add(boughtGoodslist);
		return boughtGoodslist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}