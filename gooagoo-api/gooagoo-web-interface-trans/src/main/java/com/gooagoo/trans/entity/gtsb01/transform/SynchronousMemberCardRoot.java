package com.gooagoo.trans.entity.gtsb01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 需要同步的会员卡和用户关联信息查询
 */
public class SynchronousMemberCardRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 会员信息 */
	private java.util.List<Memberofcard> memberofcard = null;

	/**
	 * 设置结果编码，true-查询成功，false-查询失败
	 * @param result	结果编码，true-查询成功，false-查询失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true-查询成功，false-查询失败
	 * @return	结果编码，true-查询成功，false-查询失败
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
	 * 设置会员信息
	 * @param memberofcard	会员信息
	 */
	public void setMemberofcard(java.util.List<Memberofcard> memberofcard)
	{
		this.memberofcard = memberofcard;
	}

	/**
	 * 获取会员信息
	 * @return	会员信息
	 */
	public java.util.List<Memberofcard> getMemberofcard()
	{
		return this.memberofcard;
	}

	/**
	 * 添加会员信息
	 * @return memberofcard	会员信息
	 */
	public Memberofcard addMoreMemberofcard() {
		Memberofcard memberofcard = new Memberofcard();
		this.memberofcard.add(memberofcard);
		return memberofcard;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}