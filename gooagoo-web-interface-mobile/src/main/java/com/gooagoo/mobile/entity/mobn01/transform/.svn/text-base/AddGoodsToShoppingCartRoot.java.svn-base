package com.gooagoo.mobile.entity.mobn01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 添加商品到购物车 
 */
public class AddGoodsToShoppingCartRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  商品是否已存在标识，Y-表示添加的商品已经在购物中存在 ，N-表示要添加的商品不在购物车种  */
	private String existflag = null;

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
	 * 设置 商品是否已存在标识，Y-表示添加的商品已经在购物中存在 ，N-表示要添加的商品不在购物车种 
	 * @param existflag	 商品是否已存在标识，Y-表示添加的商品已经在购物中存在 ，N-表示要添加的商品不在购物车种 
	 */
	public void setExistflag(String existflag)
	{
		this.existflag = existflag != null ? existflag : "";
	}

	/**
	 * 获取 商品是否已存在标识，Y-表示添加的商品已经在购物中存在 ，N-表示要添加的商品不在购物车种 
	 * @return	 商品是否已存在标识，Y-表示添加的商品已经在购物中存在 ，N-表示要添加的商品不在购物车种 
	 */
	public String getExistflag()
	{
		return this.existflag;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}