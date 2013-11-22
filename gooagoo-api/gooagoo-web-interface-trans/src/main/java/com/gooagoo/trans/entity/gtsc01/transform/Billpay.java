package com.gooagoo.trans.entity.gtsc01.transform;

import java.io.Serializable;

/**
 * 结账通知信息
 */
public class Billpay implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 自动编号，uuid */
	private String id = "";

	/** 会员卡编号，如果没有则填写 "" */
	private String scardno = "";

	/** 申请时间 */
	private String applytime = "";

	/** 桌号 */
	private String deskno = "";

	/** 优惠劵信息（多条）,格式：{[favoriteid:"",couponcontent:""]}  */
	private String couponinfo = "";

	/** 房间名称 */
	private String roomid = "";

	/** 商家订单编号 */
	private String orderid = "";

	/** 原价格 */
	private String originalprice = "";

	/**
	 * 设置自动编号，uuid
	 * @param id	自动编号，uuid
	 */
	public void setId(String id)
	{
		this.id = id != null ? id : "";
	}

	/**
	 * 获取自动编号，uuid
	 * @return	自动编号，uuid
	 */
	public String getId()
	{
		return this.id;
	}

	/**
	 * 设置会员卡编号，如果没有则填写 ""
	 * @param scardno	会员卡编号，如果没有则填写 ""
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取会员卡编号，如果没有则填写 ""
	 * @return	会员卡编号，如果没有则填写 ""
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置申请时间
	 * @param applytime	申请时间
	 */
	public void setApplytime(String applytime)
	{
		this.applytime = applytime != null ? applytime : "";
	}

	/**
	 * 获取申请时间
	 * @return	申请时间
	 */
	public String getApplytime()
	{
		return this.applytime;
	}

	/**
	 * 设置桌号
	 * @param deskno	桌号
	 */
	public void setDeskno(String deskno)
	{
		this.deskno = deskno != null ? deskno : "";
	}

	/**
	 * 获取桌号
	 * @return	桌号
	 */
	public String getDeskno()
	{
		return this.deskno;
	}

	/**
	 * 设置优惠劵信息（多条）,格式：{[favoriteid:"",couponcontent:""]} 
	 * @param couponinfo	优惠劵信息（多条）,格式：{[favoriteid:"",couponcontent:""]} 
	 */
	public void setCouponinfo(String couponinfo)
	{
		this.couponinfo = couponinfo != null ? couponinfo : "";
	}

	/**
	 * 获取优惠劵信息（多条）,格式：{[favoriteid:"",couponcontent:""]} 
	 * @return	优惠劵信息（多条）,格式：{[favoriteid:"",couponcontent:""]} 
	 */
	public String getCouponinfo()
	{
		return this.couponinfo;
	}

	/**
	 * 设置房间名称
	 * @param roomid	房间名称
	 */
	public void setRoomid(String roomid)
	{
		this.roomid = roomid != null ? roomid : "";
	}

	/**
	 * 获取房间名称
	 * @return	房间名称
	 */
	public String getRoomid()
	{
		return this.roomid;
	}

	/**
	 * 设置商家订单编号
	 * @param orderid	商家订单编号
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取商家订单编号
	 * @return	商家订单编号
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置原价格
	 * @param originalprice	原价格
	 */
	public void setOriginalprice(String originalprice)
	{
		this.originalprice = originalprice != null ? originalprice : "";
	}

	/**
	 * 获取原价格
	 * @return	原价格
	 */
	public String getOriginalprice()
	{
		return this.originalprice;
	}
}