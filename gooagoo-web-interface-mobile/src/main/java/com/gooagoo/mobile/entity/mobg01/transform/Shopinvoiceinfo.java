package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  实体店开发票项目 
 */
public class Shopinvoiceinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/** 实体店编号  */
	private String shopentityid = "";

	/** 个人发票  */
	private java.util.List<Invoicetypep> invoicetypep = new java.util.ArrayList<Invoicetypep>();

	/** 公司发票  */
	private java.util.List<Invoicetypec> invoicetypec = new java.util.ArrayList<Invoicetypec>();

	/** 最后一次修改时间  */
	private String ctimestamp = "";

	/**
	 * 设置商家编号 
	 * @param shopid	商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家编号 
	 * @return	商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置实体店编号 
	 * @param shopentityid	实体店编号 
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取实体店编号 
	 * @return	实体店编号 
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置个人发票 
	 * @param invoicetypep	个人发票 
	 */
	public void setInvoicetypep(java.util.List<Invoicetypep> invoicetypep)
	{
		this.invoicetypep = invoicetypep;
	}

	/**
	 * 获取个人发票 
	 * @return	个人发票 
	 */
	public java.util.List<Invoicetypep> getInvoicetypep()
	{
		return this.invoicetypep;
	}

	/**
	 * 设置公司发票 
	 * @param invoicetypec	公司发票 
	 */
	public void setInvoicetypec(java.util.List<Invoicetypec> invoicetypec)
	{
		this.invoicetypec = invoicetypec;
	}

	/**
	 * 获取公司发票 
	 * @return	公司发票 
	 */
	public java.util.List<Invoicetypec> getInvoicetypec()
	{
		return this.invoicetypec;
	}

	/**
	 * 设置最后一次修改时间 
	 * @param ctimestamp	最后一次修改时间 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取最后一次修改时间 
	 * @return	最后一次修改时间 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 添加个人发票 
	 * @return invoicetypep	个人发票 
	 */
	public Invoicetypep addMoreInvoicetypep() {
		Invoicetypep invoicetypep = new Invoicetypep();
		this.invoicetypep.add(invoicetypep);
		return invoicetypep;
	}

	/**
	 * 添加公司发票 
	 * @return invoicetypec	公司发票 
	 */
	public Invoicetypec addMoreInvoicetypec() {
		Invoicetypec invoicetypec = new Invoicetypec();
		this.invoicetypec.add(invoicetypec);
		return invoicetypec;
	}
}