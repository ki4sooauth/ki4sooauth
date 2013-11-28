package com.gooagoo.mobile.entity.mobd01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  计划列表与服务器同步 
 */
public class UserShoppingPlanSRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  数据状态标识，A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的  */
	private String flag = null;

	/**  当flag为A(手机端新增数据)时,此节点会返回，其它情况不返回  */
	private String newshoppinglistid = null;

	/**  购物计划  */
	private Usershoppingplansinglemob usershoppingplansinglemob = null;

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
	 * 设置 数据状态标识，A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的 
	 * @param flag	 数据状态标识，A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的 
	 */
	public void setFlag(String flag)
	{
		this.flag = flag != null ? flag : "";
	}

	/**
	 * 获取 数据状态标识，A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的 
	 * @return	 数据状态标识，A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的 
	 */
	public String getFlag()
	{
		return this.flag;
	}

	/**
	 * 设置 当flag为A(手机端新增数据)时,此节点会返回，其它情况不返回 
	 * @param newshoppinglistid	 当flag为A(手机端新增数据)时,此节点会返回，其它情况不返回 
	 */
	public void setNewshoppinglistid(String newshoppinglistid)
	{
		this.newshoppinglistid = newshoppinglistid != null ? newshoppinglistid : "";
	}

	/**
	 * 获取 当flag为A(手机端新增数据)时,此节点会返回，其它情况不返回 
	 * @return	 当flag为A(手机端新增数据)时,此节点会返回，其它情况不返回 
	 */
	public String getNewshoppinglistid()
	{
		return this.newshoppinglistid;
	}

	/**
	 * 设置 购物计划 
	 * @param usershoppingplansinglemob	 购物计划 
	 */
	public void setUsershoppingplansinglemob(Usershoppingplansinglemob usershoppingplansinglemob)
	{
		this.usershoppingplansinglemob = usershoppingplansinglemob;
	}

	/**
	 * 获取 购物计划 
	 * @return	 购物计划 
	 */
	public Usershoppingplansinglemob getUsershoppingplansinglemob()
	{
		return this.usershoppingplansinglemob;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}