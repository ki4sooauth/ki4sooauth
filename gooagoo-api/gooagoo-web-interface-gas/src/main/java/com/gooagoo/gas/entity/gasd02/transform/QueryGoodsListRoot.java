package com.gooagoo.gas.entity.gasd02.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 商品列表
 */
public class QueryGoodsListRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 商品列表信息 */
	private java.util.List<Goodsinfo> goodsinfo = null;

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
	 * 设置查询结果描述
	 * @param msg	查询结果描述
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取查询结果描述
	 * @return	查询结果描述
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
	 * 设置商品列表信息
	 * @param goodsinfo	商品列表信息
	 */
	public void setGoodsinfo(java.util.List<Goodsinfo> goodsinfo)
	{
		this.goodsinfo = goodsinfo;
	}

	/**
	 * 获取商品列表信息
	 * @return	商品列表信息
	 */
	public java.util.List<Goodsinfo> getGoodsinfo()
	{
		return this.goodsinfo;
	}

	/**
	 * 添加商品列表信息
	 * @return goodsinfo	商品列表信息
	 */
	public Goodsinfo addMoreGoodsinfo() {
		Goodsinfo goodsinfo = new Goodsinfo();
		this.goodsinfo.add(goodsinfo);
		return goodsinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}