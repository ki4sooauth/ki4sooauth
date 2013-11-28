package com.gooagoo.mobile.entity.moba09.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  获取店铺的会员卡信息列表 
 */
public class ShopCardInfoRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  店铺新卡信息  */
	private java.util.List<Shopcardinfo> shopcardinfo = null;

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
	 * 设置 店铺新卡信息 
	 * @param shopcardinfo	 店铺新卡信息 
	 */
	public void setShopcardinfo(java.util.List<Shopcardinfo> shopcardinfo)
	{
		this.shopcardinfo = shopcardinfo;
	}

	/**
	 * 获取 店铺新卡信息 
	 * @return	 店铺新卡信息 
	 */
	public java.util.List<Shopcardinfo> getShopcardinfo()
	{
		return this.shopcardinfo;
	}

	/**
	 * 添加 店铺新卡信息 
	 * @return shopcardinfo	 店铺新卡信息 
	 */
	public Shopcardinfo addMoreShopcardinfo() {
		Shopcardinfo shopcardinfo = new Shopcardinfo();
		this.shopcardinfo.add(shopcardinfo);
		return shopcardinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}