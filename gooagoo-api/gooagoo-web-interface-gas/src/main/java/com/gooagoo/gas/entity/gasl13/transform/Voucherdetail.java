package com.gooagoo.gas.entity.gasl13.transform;

import java.io.Serializable;

/**
 *  优惠劵信息 
 */
public class Voucherdetail implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 店铺id  */
	private String shopid = "";

	/** 优惠凭证与用户关联编号，UUID */
	private String couponuserid = "";

	/** 优惠劵名称  */
	private String couponname = "";

	/** 优惠劵正面图  */
	private String couponurl = "";

	/** 优惠劵开始时间  */
	private String publishstarttime = "";

	/** 优惠劵结束时间  */
	private String publishendtime = "";

	/** 优惠劵权限说明  */
	private String couponcontent = "";

	/** 优惠凭证类型，参考通用字典表的coupon_type  */
	private String coupontype = "";

	/** 优惠券数值  */
	private String couponvalue = "";

	/**
	 * 设置店铺id 
	 * @param shopid	店铺id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取店铺id 
	 * @return	店铺id 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置优惠凭证与用户关联编号，UUID
	 * @param couponuserid	优惠凭证与用户关联编号，UUID
	 */
	public void setCouponuserid(String couponuserid)
	{
		this.couponuserid = couponuserid != null ? couponuserid : "";
	}

	/**
	 * 获取优惠凭证与用户关联编号，UUID
	 * @return	优惠凭证与用户关联编号，UUID
	 */
	public String getCouponuserid()
	{
		return this.couponuserid;
	}

	/**
	 * 设置优惠劵名称 
	 * @param couponname	优惠劵名称 
	 */
	public void setCouponname(String couponname)
	{
		this.couponname = couponname != null ? couponname : "";
	}

	/**
	 * 获取优惠劵名称 
	 * @return	优惠劵名称 
	 */
	public String getCouponname()
	{
		return this.couponname;
	}

	/**
	 * 设置优惠劵正面图 
	 * @param couponurl	优惠劵正面图 
	 */
	public void setCouponurl(String couponurl)
	{
		this.couponurl = couponurl != null ? couponurl : "";
	}

	/**
	 * 获取优惠劵正面图 
	 * @return	优惠劵正面图 
	 */
	public String getCouponurl()
	{
		return this.couponurl;
	}

	/**
	 * 设置优惠劵开始时间 
	 * @param publishstarttime	优惠劵开始时间 
	 */
	public void setPublishstarttime(String publishstarttime)
	{
		this.publishstarttime = publishstarttime != null ? publishstarttime : "";
	}

	/**
	 * 获取优惠劵开始时间 
	 * @return	优惠劵开始时间 
	 */
	public String getPublishstarttime()
	{
		return this.publishstarttime;
	}

	/**
	 * 设置优惠劵结束时间 
	 * @param publishendtime	优惠劵结束时间 
	 */
	public void setPublishendtime(String publishendtime)
	{
		this.publishendtime = publishendtime != null ? publishendtime : "";
	}

	/**
	 * 获取优惠劵结束时间 
	 * @return	优惠劵结束时间 
	 */
	public String getPublishendtime()
	{
		return this.publishendtime;
	}

	/**
	 * 设置优惠劵权限说明 
	 * @param couponcontent	优惠劵权限说明 
	 */
	public void setCouponcontent(String couponcontent)
	{
		this.couponcontent = couponcontent != null ? couponcontent : "";
	}

	/**
	 * 获取优惠劵权限说明 
	 * @return	优惠劵权限说明 
	 */
	public String getCouponcontent()
	{
		return this.couponcontent;
	}

	/**
	 * 设置优惠凭证类型，参考通用字典表的coupon_type 
	 * @param coupontype	优惠凭证类型，参考通用字典表的coupon_type 
	 */
	public void setCoupontype(String coupontype)
	{
		this.coupontype = coupontype != null ? coupontype : "";
	}

	/**
	 * 获取优惠凭证类型，参考通用字典表的coupon_type 
	 * @return	优惠凭证类型，参考通用字典表的coupon_type 
	 */
	public String getCoupontype()
	{
		return this.coupontype;
	}

	/**
	 * 设置优惠券数值 
	 * @param couponvalue	优惠券数值 
	 */
	public void setCouponvalue(String couponvalue)
	{
		this.couponvalue = couponvalue != null ? couponvalue : "";
	}

	/**
	 * 获取优惠券数值 
	 * @return	优惠券数值 
	 */
	public String getCouponvalue()
	{
		return this.couponvalue;
	}
}