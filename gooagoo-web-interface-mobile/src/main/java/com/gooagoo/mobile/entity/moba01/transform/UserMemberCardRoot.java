package com.gooagoo.mobile.entity.moba01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用户会员卡 
 */
public class UserMemberCardRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  用户会员卡  */
	private java.util.List<Usermembercard> usermembercard = null;

	/**  未读通知信息  */
	private java.util.List<Noreadnoticeinfo> noreadnoticeinfo = null;

	/**  已删除的会员卡信息  */
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
	 * 设置 用户会员卡 
	 * @param usermembercard	 用户会员卡 
	 */
	public void setUsermembercard(java.util.List<Usermembercard> usermembercard)
	{
		this.usermembercard = usermembercard;
	}

	/**
	 * 获取 用户会员卡 
	 * @return	 用户会员卡 
	 */
	public java.util.List<Usermembercard> getUsermembercard()
	{
		return this.usermembercard;
	}

	/**
	 * 设置 未读通知信息 
	 * @param noreadnoticeinfo	 未读通知信息 
	 */
	public void setNoreadnoticeinfo(java.util.List<Noreadnoticeinfo> noreadnoticeinfo)
	{
		this.noreadnoticeinfo = noreadnoticeinfo;
	}

	/**
	 * 获取 未读通知信息 
	 * @return	 未读通知信息 
	 */
	public java.util.List<Noreadnoticeinfo> getNoreadnoticeinfo()
	{
		return this.noreadnoticeinfo;
	}

	/**
	 * 设置 已删除的会员卡信息 
	 * @param isdeleted	 已删除的会员卡信息 
	 */
	public void setIsdeleted(Isdeleted isdeleted)
	{
		this.isdeleted = isdeleted;
	}

	/**
	 * 获取 已删除的会员卡信息 
	 * @return	 已删除的会员卡信息 
	 */
	public Isdeleted getIsdeleted()
	{
		return this.isdeleted;
	}

	/**
	 * 添加 用户会员卡 
	 * @return usermembercard	 用户会员卡 
	 */
	public Usermembercard addMoreUsermembercard() {
		Usermembercard usermembercard = new Usermembercard();
		this.usermembercard.add(usermembercard);
		return usermembercard;
	}

	/**
	 * 添加 未读通知信息 
	 * @return noreadnoticeinfo	 未读通知信息 
	 */
	public Noreadnoticeinfo addMoreNoreadnoticeinfo() {
		Noreadnoticeinfo noreadnoticeinfo = new Noreadnoticeinfo();
		this.noreadnoticeinfo.add(noreadnoticeinfo);
		return noreadnoticeinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}