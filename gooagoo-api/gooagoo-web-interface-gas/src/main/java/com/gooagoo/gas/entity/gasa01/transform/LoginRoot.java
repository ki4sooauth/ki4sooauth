package com.gooagoo.gas.entity.gasa01.transform;

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

	/** 用户id */
	private String shopuserid = null;

	/** 用户姓名 */
	private String realname = null;

	/** 商家编号 */
	private String shopid = null;

	/** 实体店编号 */
	private String shopentityid = null;

	/**  店员助理头像  */
	private String headpic = null;

	/**  店员所属区域信息  */
	private java.util.List<Shopuserposition> shopuserposition = null;

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
	 * 设置用户id
	 * @param shopuserid	用户id
	 */
	public void setShopuserid(String shopuserid)
	{
		this.shopuserid = shopuserid != null ? shopuserid : "";
	}

	/**
	 * 获取用户id
	 * @return	用户id
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
	 * 设置商家编号
	 * @param shopid	商家编号
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家编号
	 * @return	商家编号
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置实体店编号
	 * @param shopentityid	实体店编号
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取实体店编号
	 * @return	实体店编号
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置 店员助理头像 
	 * @param headpic	 店员助理头像 
	 */
	public void setHeadpic(String headpic)
	{
		this.headpic = headpic != null ? headpic : "";
	}

	/**
	 * 获取 店员助理头像 
	 * @return	 店员助理头像 
	 */
	public String getHeadpic()
	{
		return this.headpic;
	}

	/**
	 * 设置 店员所属区域信息 
	 * @param shopuserposition	 店员所属区域信息 
	 */
	public void setShopuserposition(java.util.List<Shopuserposition> shopuserposition)
	{
		this.shopuserposition = shopuserposition;
	}

	/**
	 * 获取 店员所属区域信息 
	 * @return	 店员所属区域信息 
	 */
	public java.util.List<Shopuserposition> getShopuserposition()
	{
		return this.shopuserposition;
	}

	/**
	 * 添加 店员所属区域信息 
	 * @return shopuserposition	 店员所属区域信息 
	 */
	public Shopuserposition addMoreShopuserposition() {
		Shopuserposition shopuserposition = new Shopuserposition();
		this.shopuserposition.add(shopuserposition);
		return shopuserposition;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}