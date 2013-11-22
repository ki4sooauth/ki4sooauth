package com.gooagoo.trans.entity.gtsd01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 根据优惠劵编号查询商家优惠劵信息 
 */
public class FindCouponInfoByCouponidRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 优惠凭证相关信息 */
	private Couponinfo couponinfo = null;

	/**
	 * 设置结果编码，true成功，false失败 
	 * @param result	结果编码，true成功，false失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true成功，false失败 
	 * @return	结果编码，true成功，false失败 
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
	 * 设置优惠凭证相关信息
	 * @param couponinfo	优惠凭证相关信息
	 */
	public void setCouponinfo(Couponinfo couponinfo)
	{
		this.couponinfo = couponinfo;
	}

	/**
	 * 获取优惠凭证相关信息
	 * @return	优惠凭证相关信息
	 */
	public Couponinfo getCouponinfo()
	{
		return this.couponinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}