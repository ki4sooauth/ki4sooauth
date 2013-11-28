package com.gooagoo.mobile.entity.mobe03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  根据接收到的LID信息，返回对应的信息 
 */
public class InfoFromLidRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 店铺id  */
	private String shopid = null;

	/**  系统分类  */
	private java.util.List<Infofromlid> infofromlid = null;

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
	 * 设置 系统分类 
	 * @param infofromlid	 系统分类 
	 */
	public void setInfofromlid(java.util.List<Infofromlid> infofromlid)
	{
		this.infofromlid = infofromlid;
	}

	/**
	 * 获取 系统分类 
	 * @return	 系统分类 
	 */
	public java.util.List<Infofromlid> getInfofromlid()
	{
		return this.infofromlid;
	}

	/**
	 * 添加 系统分类 
	 * @return infofromlid	 系统分类 
	 */
	public Infofromlid addMoreInfofromlid() {
		Infofromlid infofromlid = new Infofromlid();
		this.infofromlid.add(infofromlid);
		return infofromlid;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}