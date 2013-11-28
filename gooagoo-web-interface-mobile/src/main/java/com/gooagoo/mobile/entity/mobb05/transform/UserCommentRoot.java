package com.gooagoo.mobile.entity.mobb05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  获取商品所有评论 
 */
public class UserCommentRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 总评论数目  */
	private String totalrec = null;

	/**  评论信息  */
	private java.util.List<Usercomment> usercomment = null;

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
	 * 设置总评论数目 
	 * @param totalrec	总评论数目 
	 */
	public void setTotalrec(String totalrec)
	{
		this.totalrec = totalrec != null ? totalrec : "";
	}

	/**
	 * 获取总评论数目 
	 * @return	总评论数目 
	 */
	public String getTotalrec()
	{
		return this.totalrec;
	}

	/**
	 * 设置 评论信息 
	 * @param usercomment	 评论信息 
	 */
	public void setUsercomment(java.util.List<Usercomment> usercomment)
	{
		this.usercomment = usercomment;
	}

	/**
	 * 获取 评论信息 
	 * @return	 评论信息 
	 */
	public java.util.List<Usercomment> getUsercomment()
	{
		return this.usercomment;
	}

	/**
	 * 添加 评论信息 
	 * @return usercomment	 评论信息 
	 */
	public Usercomment addMoreUsercomment() {
		Usercomment usercomment = new Usercomment();
		this.usercomment.add(usercomment);
		return usercomment;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}