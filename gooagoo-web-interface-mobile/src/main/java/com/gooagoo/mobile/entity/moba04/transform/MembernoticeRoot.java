package com.gooagoo.mobile.entity.moba04.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户得到"通知" 
 */
public class MembernoticeRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 通知  */
	private java.util.List<Membernotice> membernotice = null;

	/** 平台已删除的通知编号信息  */
	private Isdeleted isdeleted = null;

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
	 * 设置通知 
	 * @param membernotice	通知 
	 */
	public void setMembernotice(java.util.List<Membernotice> membernotice)
	{
		this.membernotice = membernotice;
	}

	/**
	 * 获取通知 
	 * @return	通知 
	 */
	public java.util.List<Membernotice> getMembernotice()
	{
		return this.membernotice;
	}

	/**
	 * 设置平台已删除的通知编号信息 
	 * @param isdeleted	平台已删除的通知编号信息 
	 */
	public void setIsdeleted(Isdeleted isdeleted)
	{
		this.isdeleted = isdeleted;
	}

	/**
	 * 获取平台已删除的通知编号信息 
	 * @return	平台已删除的通知编号信息 
	 */
	public Isdeleted getIsdeleted()
	{
		return this.isdeleted;
	}

	/**
	 * 添加通知 
	 * @return membernotice	通知 
	 */
	public Membernotice addMoreMembernotice() {
		Membernotice membernotice = new Membernotice();
		this.membernotice.add(membernotice);
		return membernotice;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}