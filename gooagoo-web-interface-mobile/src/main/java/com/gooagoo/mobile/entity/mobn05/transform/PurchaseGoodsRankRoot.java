package com.gooagoo.mobile.entity.mobn05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 查询用户购过商品次数排行 
 */
public class PurchaseGoodsRankRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  已经购买过商品次数排行信息 */
	private java.util.List<Boughtgoodsrankinfo> boughtgoodsrankinfo = null;

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
	 * 设置 已经购买过商品次数排行信息
	 * @param boughtgoodsrankinfo	 已经购买过商品次数排行信息
	 */
	public void setBoughtgoodsrankinfo(java.util.List<Boughtgoodsrankinfo> boughtgoodsrankinfo)
	{
		this.boughtgoodsrankinfo = boughtgoodsrankinfo;
	}

	/**
	 * 获取 已经购买过商品次数排行信息
	 * @return	 已经购买过商品次数排行信息
	 */
	public java.util.List<Boughtgoodsrankinfo> getBoughtgoodsrankinfo()
	{
		return this.boughtgoodsrankinfo;
	}

	/**
	 * 添加 已经购买过商品次数排行信息
	 * @return boughtgoodsrankinfo	 已经购买过商品次数排行信息
	 */
	public Boughtgoodsrankinfo addMoreBoughtgoodsrankinfo() {
		Boughtgoodsrankinfo boughtgoodsrankinfo = new Boughtgoodsrankinfo();
		this.boughtgoodsrankinfo.add(boughtgoodsrankinfo);
		return boughtgoodsrankinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}