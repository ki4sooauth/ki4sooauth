package com.gooagoo.trans.entity.gtsd05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 根据会员卡号查询会员卡信息
 */
public class FindMemberOfCardInfoByScardNoRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 会员卡背景图片信息 */
	private Membercard membercard = null;

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
	 * 设置会员卡背景图片信息
	 * @param membercard	会员卡背景图片信息
	 */
	public void setMembercard(Membercard membercard)
	{
		this.membercard = membercard;
	}

	/**
	 * 获取会员卡背景图片信息
	 * @return	会员卡背景图片信息
	 */
	public Membercard getMembercard()
	{
		return this.membercard;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}