package com.gooagoo.gas.entity.gasc04.transform;

import java.io.Serializable;

/**
 * 用户的基本信息
 */
public class CouponBaseInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 用户id */
	private String userId = "";

	/** 真实姓名 */
	private String realName = "";

	/** 优惠凭证音频编码 */
	private String couponCode = "";

	/** 优惠凭证名称 */
	private String couponName = "";

	/**
	 * 设置用户id
	 * @param userId	用户id
	 */
	public void setUserId(String userId)
	{
		this.userId = userId != null ? userId : "";
	}

	/**
	 * 获取用户id
	 * @return	用户id
	 */
	public String getUserId()
	{
		return this.userId;
	}

	/**
	 * 设置真实姓名
	 * @param realName	真实姓名
	 */
	public void setRealName(String realName)
	{
		this.realName = realName != null ? realName : "";
	}

	/**
	 * 获取真实姓名
	 * @return	真实姓名
	 */
	public String getRealName()
	{
		return this.realName;
	}

	/**
	 * 设置优惠凭证音频编码
	 * @param couponCode	优惠凭证音频编码
	 */
	public void setCouponCode(String couponCode)
	{
		this.couponCode = couponCode != null ? couponCode : "";
	}

	/**
	 * 获取优惠凭证音频编码
	 * @return	优惠凭证音频编码
	 */
	public String getCouponCode()
	{
		return this.couponCode;
	}

	/**
	 * 设置优惠凭证名称
	 * @param couponName	优惠凭证名称
	 */
	public void setCouponName(String couponName)
	{
		this.couponName = couponName != null ? couponName : "";
	}

	/**
	 * 获取优惠凭证名称
	 * @return	优惠凭证名称
	 */
	public String getCouponName()
	{
		return this.couponName;
	}
}