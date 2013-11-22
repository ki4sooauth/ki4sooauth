package com.gooagoo.mobile.entity.moba03.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户会员卡关联卡头信息标签表 
 */
public class UserMemberCardHeadRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 卡头信息  */
	private java.util.List<Usermembercardhead> usermembercardhead = null;

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
	 * 设置卡头信息 
	 * @param usermembercardhead	卡头信息 
	 */
	public void setUsermembercardhead(java.util.List<Usermembercardhead> usermembercardhead)
	{
		this.usermembercardhead = usermembercardhead;
	}

	/**
	 * 获取卡头信息 
	 * @return	卡头信息 
	 */
	public java.util.List<Usermembercardhead> getUsermembercardhead()
	{
		return this.usermembercardhead;
	}

	/**
	 * 添加卡头信息 
	 * @return usermembercardhead	卡头信息 
	 */
	public Usermembercardhead addMoreUsermembercardhead() {
		Usermembercardhead usermembercardhead = new Usermembercardhead();
		this.usermembercardhead.add(usermembercardhead);
		return usermembercardhead;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}