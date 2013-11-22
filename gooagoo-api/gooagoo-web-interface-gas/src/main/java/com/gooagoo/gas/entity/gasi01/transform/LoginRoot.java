package com.gooagoo.gas.entity.gasi01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 店员登录
 */
public class LoginRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-登录成功，false-登录失败 */
	private String result = null;

	/** 查询失败描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 用户id，对应店员登录账号 */
	private String shopuserid = null;

	/** 用户姓名 */
	private String realname = null;

	/** 店铺id */
	private String shopid = null;

	/**
	 * 设置查询结果编码，true-登录成功，false-登录失败
	 * @param result	查询结果编码，true-登录成功，false-登录失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取查询结果编码，true-登录成功，false-登录失败
	 * @return	查询结果编码，true-登录成功，false-登录失败
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
	 * 设置用户id，对应店员登录账号
	 * @param shopuserid	用户id，对应店员登录账号
	 */
	public void setShopuserid(String shopuserid)
	{
		this.shopuserid = shopuserid != null ? shopuserid : "";
	}

	/**
	 * 获取用户id，对应店员登录账号
	 * @return	用户id，对应店员登录账号
	 */
	public String getShopuserid()
	{
		return this.shopuserid;
	}

	/**
	 * 设置用户姓名
	 * @param realname	用户姓名
	 */
	public void setRealname(String realname)
	{
		this.realname = realname != null ? realname : "";
	}

	/**
	 * 获取用户姓名
	 * @return	用户姓名
	 */
	public String getRealname()
	{
		return this.realname;
	}

	/**
	 * 设置店铺id
	 * @param shopid	店铺id
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取店铺id
	 * @return	店铺id
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}