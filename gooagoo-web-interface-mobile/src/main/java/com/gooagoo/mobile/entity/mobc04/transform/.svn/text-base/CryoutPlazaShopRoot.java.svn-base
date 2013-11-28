package com.gooagoo.mobile.entity.mobc04.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 吆喝广场商家查询（输入参数：商家Id和用户Id） 
 */
public class CryoutPlazaShopRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  查询结果编码，Y-成功，N-失败  */
	private String result = null;

	/**  查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 吆喝广场商家查询（输入参数：商家id和用户id  */
	private Shopdetail shopdetail = null;

	/**
	 * 设置 查询结果编码，Y-成功，N-失败 
	 * @param result	 查询结果编码，Y-成功，N-失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取 查询结果编码，Y-成功，N-失败 
	 * @return	 查询结果编码，Y-成功，N-失败 
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置 查询失败描述 
	 * @param msg	 查询失败描述 
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取 查询失败描述 
	 * @return	 查询失败描述 
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
	 * 设置吆喝广场商家查询（输入参数：商家id和用户id 
	 * @param shopdetail	吆喝广场商家查询（输入参数：商家id和用户id 
	 */
	public void setShopdetail(Shopdetail shopdetail)
	{
		this.shopdetail = shopdetail;
	}

	/**
	 * 获取吆喝广场商家查询（输入参数：商家id和用户id 
	 * @return	吆喝广场商家查询（输入参数：商家id和用户id 
	 */
	public Shopdetail getShopdetail()
	{
		return this.shopdetail;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}