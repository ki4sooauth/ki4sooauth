package com.gooagoo.trans.entity.gtsd03.transform;

import java.io.Serializable;

/**
 * 订单信息 
 */
public class Voucherorderbaseinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 会员卡号  */
	private String scardno = "";

	/** 时间戳  */
	private String ctimestamp = "";

	/** 商品总数  */
	private String goodstotalnum = "";

	/** 消费金额  */
	private String payprice = "";

	/** 订单编号  */
	private String orderid = "";

	/** 申请时间  */
	private String createtime = "";

	/** 桌号  */
	private String tablename = "";

	/** 客人数  */
	private String guestsnumber = "";

	/** 用户id  */
	private String userid = "";

	/**  订单详细信息  */
	private java.util.List<Voucherorderorderdetailinfo> voucherorderorderdetailinfo = new java.util.ArrayList<Voucherorderorderdetailinfo>();

	/**
	 * 设置会员卡号 
	 * @param scardno	会员卡号 
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取会员卡号 
	 * @return	会员卡号 
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置时间戳 
	 * @param ctimestamp	时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取时间戳 
	 * @return	时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 设置商品总数 
	 * @param goodstotalnum	商品总数 
	 */
	public void setGoodstotalnum(String goodstotalnum)
	{
		this.goodstotalnum = goodstotalnum != null ? goodstotalnum : "";
	}

	/**
	 * 获取商品总数 
	 * @return	商品总数 
	 */
	public String getGoodstotalnum()
	{
		return this.goodstotalnum;
	}

	/**
	 * 设置消费金额 
	 * @param payprice	消费金额 
	 */
	public void setPayprice(String payprice)
	{
		this.payprice = payprice != null ? payprice : "";
	}

	/**
	 * 获取消费金额 
	 * @return	消费金额 
	 */
	public String getPayprice()
	{
		return this.payprice;
	}

	/**
	 * 设置订单编号 
	 * @param orderid	订单编号 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取订单编号 
	 * @return	订单编号 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置申请时间 
	 * @param createtime	申请时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取申请时间 
	 * @return	申请时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}

	/**
	 * 设置桌号 
	 * @param tablename	桌号 
	 */
	public void setTablename(String tablename)
	{
		this.tablename = tablename != null ? tablename : "";
	}

	/**
	 * 获取桌号 
	 * @return	桌号 
	 */
	public String getTablename()
	{
		return this.tablename;
	}

	/**
	 * 设置客人数 
	 * @param guestsnumber	客人数 
	 */
	public void setGuestsnumber(String guestsnumber)
	{
		this.guestsnumber = guestsnumber != null ? guestsnumber : "";
	}

	/**
	 * 获取客人数 
	 * @return	客人数 
	 */
	public String getGuestsnumber()
	{
		return this.guestsnumber;
	}

	/**
	 * 设置用户id 
	 * @param userid	用户id 
	 */
	public void setUserid(String userid)
	{
		this.userid = userid != null ? userid : "";
	}

	/**
	 * 获取用户id 
	 * @return	用户id 
	 */
	public String getUserid()
	{
		return this.userid;
	}

	/**
	 * 设置 订单详细信息 
	 * @param voucherorderorderdetailinfo	 订单详细信息 
	 */
	public void setVoucherorderorderdetailinfo(java.util.List<Voucherorderorderdetailinfo> voucherorderorderdetailinfo)
	{
		this.voucherorderorderdetailinfo = voucherorderorderdetailinfo;
	}

	/**
	 * 获取 订单详细信息 
	 * @return	 订单详细信息 
	 */
	public java.util.List<Voucherorderorderdetailinfo> getVoucherorderorderdetailinfo()
	{
		return this.voucherorderorderdetailinfo;
	}

	/**
	 * 添加 订单详细信息 
	 * @return voucherorderorderdetailinfo	 订单详细信息 
	 */
	public Voucherorderorderdetailinfo addMoreVoucherorderorderdetailinfo() {
		Voucherorderorderdetailinfo voucherorderorderdetailinfo = new Voucherorderorderdetailinfo();
		this.voucherorderorderdetailinfo.add(voucherorderorderdetailinfo);
		return voucherorderorderdetailinfo;
	}
}