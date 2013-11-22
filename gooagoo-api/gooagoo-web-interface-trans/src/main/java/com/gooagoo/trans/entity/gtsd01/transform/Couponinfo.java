package com.gooagoo.trans.entity.gtsd01.transform;

import java.io.Serializable;

/**
 * 优惠凭证相关信息
 */
public class Couponinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  桌号 （零售无，餐饮有） */
	private String tablename = "";

	/**  订单编号  */
	private String orderid = "";

	/**  优惠凭证与用户关联编号，UUID  */
	private String couponuserid = "";

	/**  优惠劵权限说明   */
	private String couponcontent = "";

	/**  优惠凭证类型，参考通用字典表的coupon_type   */
	private String coupontype = "";

	/**  优惠券数值   */
	private String couponvalue = "";

	/**  最大时间戳   */
	private String ctimestamp = "";

	/**
	 * 设置 桌号 （零售无，餐饮有）
	 * @param tablename	 桌号 （零售无，餐饮有）
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取 桌号 （零售无，餐饮有）
	 * @return	 桌号 （零售无，餐饮有）
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置 订单编号 
	 * @param orderid	 订单编号 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取 订单编号 
	 * @return	 订单编号 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置 优惠凭证与用户关联编号，UUID 
	 * @param couponuserid	 优惠凭证与用户关联编号，UUID 
	 */
	public void setCouponuserid(String couponuserid)
	{
		this.couponuserid = couponuserid != null ? couponuserid : "";
	}

	/**
	 * 获取 优惠凭证与用户关联编号，UUID 
	 * @return	 优惠凭证与用户关联编号，UUID 
	 */
	public String getCouponuserid()
	{
		return this.couponuserid;
	}

	/**
	 * 设置 优惠劵权限说明  
	 * @param couponcontent	 优惠劵权限说明  
	 */
	public void setCouponcontent(String couponcontent)
	{
		this.couponcontent = couponcontent != null ? couponcontent : "";
	}

	/**
	 * 获取 优惠劵权限说明  
	 * @return	 优惠劵权限说明  
	 */
	public String getCouponcontent()
	{
		return this.couponcontent;
	}

	/**
	 * 设置 优惠凭证类型，参考通用字典表的coupon_type  
	 * @param coupontype	 优惠凭证类型，参考通用字典表的coupon_type  
	 */
	public void setCoupontype(String coupontype)
	{
		this.coupontype = coupontype != null ? coupontype : "";
	}

	/**
	 * 获取 优惠凭证类型，参考通用字典表的coupon_type  
	 * @return	 优惠凭证类型，参考通用字典表的coupon_type  
	 */
	public String getCoupontype()
	{
		return this.coupontype;
	}

	/**
	 * 设置 优惠券数值  
	 * @param couponvalue	 优惠券数值  
	 */
	public void setCouponvalue(String couponvalue)
	{
		this.couponvalue = couponvalue != null ? couponvalue : "";
	}

	/**
	 * 获取 优惠券数值  
	 * @return	 优惠券数值  
	 */
	public String getCouponvalue()
	{
		return this.couponvalue;
	}

	/**
	 * 设置 最大时间戳  
	 * @param ctimestamp	 最大时间戳  
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取 最大时间戳  
	 * @return	 最大时间戳  
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}