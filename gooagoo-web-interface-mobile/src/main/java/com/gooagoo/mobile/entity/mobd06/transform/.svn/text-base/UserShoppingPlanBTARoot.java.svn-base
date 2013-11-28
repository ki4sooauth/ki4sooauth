package com.gooagoo.mobile.entity.mobd06.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  计划列表与服务器同步 
 */
public class UserShoppingPlanBTARoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 手机修改过的清单编号，包括：新增、修改、删除；以逗号隔开的字符串，例如“123”，“234”  */
	private String mobilechange = null;

	/**  购物计划  */
	private java.util.List<Usershoppingplanmob> usershoppingplanmob = null;

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
	 * 设置手机修改过的清单编号，包括：新增、修改、删除；以逗号隔开的字符串，例如“123”，“234” 
	 * @param mobilechange	手机修改过的清单编号，包括：新增、修改、删除；以逗号隔开的字符串，例如“123”，“234” 
	 */
	public void setMobilechange(String mobilechange)
	{
		this.mobilechange = mobilechange != null ? mobilechange : "";
	}

	/**
	 * 获取手机修改过的清单编号，包括：新增、修改、删除；以逗号隔开的字符串，例如“123”，“234” 
	 * @return	手机修改过的清单编号，包括：新增、修改、删除；以逗号隔开的字符串，例如“123”，“234” 
	 */
	public String getMobilechange()
	{
		return this.mobilechange;
	}

	/**
	 * 设置 购物计划 
	 * @param usershoppingplanmob	 购物计划 
	 */
	public void setUsershoppingplanmob(java.util.List<Usershoppingplanmob> usershoppingplanmob)
	{
		this.usershoppingplanmob = usershoppingplanmob;
	}

	/**
	 * 获取 购物计划 
	 * @return	 购物计划 
	 */
	public java.util.List<Usershoppingplanmob> getUsershoppingplanmob()
	{
		return this.usershoppingplanmob;
	}

	/**
	 * 添加 购物计划 
	 * @return usershoppingplanmob	 购物计划 
	 */
	public Usershoppingplanmob addMoreUsershoppingplanmob() {
		Usershoppingplanmob usershoppingplanmob = new Usershoppingplanmob();
		this.usershoppingplanmob.add(usershoppingplanmob);
		return usershoppingplanmob;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}