package com.gooagoo.trans.entity.gtsc03.transform;

import java.io.Serializable;

/**
 * 所要打印票信息
 */
public class Openinvoiceinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 账单id */
	private String billid = "";

	/** 时间戳 */
	private String ctimestamp = "";

	/** 发票类型 */
	private String invoiceditem = "";

	/** 发票金额 */
	private String invoicedprice = "";

	/** 发票标题 */
	private String invoicedtitle = "";

	/** 申请时间 */
	private String invoicedrequesttime = "";

	/** 商铺id */
	private String shopid = "";

	/** 用户id */
	private String userid = "";

	/**  桌号  */
	private String deskno = "";

	/** 开票时间 */
	private String invoicedtime = "";

	/**  是否需要发票明细，Y-需要，N-不需要 */
	private String needinvoiceddetail = "";

	/**  发票明细详细信息  */
	private java.util.List<Invoiceddetail> invoiceddetail = new java.util.ArrayList<Invoiceddetail>();

	/**
	 * 设置账单id
	 * @param billid	账单id
	 */
	public void setBillid(String billid)
	{
		this.billid = billid != null ? billid : "";
	}

	/**
	 * 获取账单id
	 * @return	账单id
	 */
	public String getBillid()
	{
		return this.billid;
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
	 * 设置发票类型
	 * @param invoiceditem	发票类型
	 */
	public void setInvoiceditem(String invoiceditem)
	{
		this.invoiceditem = invoiceditem != null ? invoiceditem : "";
	}

	/**
	 * 获取发票类型
	 * @return	发票类型
	 */
	public String getInvoiceditem()
	{
		return this.invoiceditem;
	}

	/**
	 * 设置发票金额
	 * @param invoicedprice	发票金额
	 */
	public void setInvoicedprice(String invoicedprice)
	{
		this.invoicedprice = invoicedprice != null ? invoicedprice : "";
	}

	/**
	 * 获取发票金额
	 * @return	发票金额
	 */
	public String getInvoicedprice()
	{
		return this.invoicedprice;
	}

	/**
	 * 设置发票标题
	 * @param invoicedtitle	发票标题
	 */
	public void setInvoicedtitle(String invoicedtitle)
	{
		this.invoicedtitle = invoicedtitle != null ? invoicedtitle : "";
	}

	/**
	 * 获取发票标题
	 * @return	发票标题
	 */
	public String getInvoicedtitle()
	{
		return this.invoicedtitle;
	}

	/**
	 * 设置申请时间
	 * @param invoicedrequesttime	申请时间
	 */
	public void setInvoicedrequesttime(String invoicedrequesttime)
	{
		this.invoicedrequesttime = invoicedrequesttime != null ? invoicedrequesttime : "";
	}

	/**
	 * 获取申请时间
	 * @return	申请时间
	 */
	public String getInvoicedrequesttime()
	{
		return this.invoicedrequesttime;
	}

	/**
	 * 设置商铺id
	 * @param shopid	商铺id
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商铺id
	 * @return	商铺id
	 */
	public String getShopid()
	{
		return this.shopid;
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
	 * 设置 桌号 
	 * @param deskno	 桌号 
	 */
	public void setDeskno(String deskno)
	{
		this.deskno = deskno != null ? deskno : "";
	}

	/**
	 * 获取 桌号 
	 * @return	 桌号 
	 */
	public String getDeskno()
	{
		return this.deskno;
	}

	/**
	 * 设置开票时间
	 * @param invoicedtime	开票时间
	 */
	public void setInvoicedtime(String invoicedtime)
	{
		this.invoicedtime = invoicedtime != null ? invoicedtime : "";
	}

	/**
	 * 获取开票时间
	 * @return	开票时间
	 */
	public String getInvoicedtime()
	{
		return this.invoicedtime;
	}

	/**
	 * 设置 是否需要发票明细，Y-需要，N-不需要
	 * @param needinvoiceddetail	 是否需要发票明细，Y-需要，N-不需要
	 */
	public void setNeedinvoiceddetail(String needinvoiceddetail)
	{
		this.needinvoiceddetail = needinvoiceddetail != null ? needinvoiceddetail : "";
	}

	/**
	 * 获取 是否需要发票明细，Y-需要，N-不需要
	 * @return	 是否需要发票明细，Y-需要，N-不需要
	 */
	public String getNeedinvoiceddetail()
	{
		return this.needinvoiceddetail;
	}

	/**
	 * 设置 发票明细详细信息 
	 * @param invoiceddetail	 发票明细详细信息 
	 */
	public void setInvoiceddetail(java.util.List<Invoiceddetail> invoiceddetail)
	{
		this.invoiceddetail = invoiceddetail;
	}

	/**
	 * 获取 发票明细详细信息 
	 * @return	 发票明细详细信息 
	 */
	public java.util.List<Invoiceddetail> getInvoiceddetail()
	{
		return this.invoiceddetail;
	}

	/**
	 * 添加 发票明细详细信息 
	 * @return invoiceddetail	 发票明细详细信息 
	 */
	public Invoiceddetail addMoreInvoiceddetail() {
		Invoiceddetail invoiceddetail = new Invoiceddetail();
		this.invoiceddetail.add(invoiceddetail);
		return invoiceddetail;
	}
}