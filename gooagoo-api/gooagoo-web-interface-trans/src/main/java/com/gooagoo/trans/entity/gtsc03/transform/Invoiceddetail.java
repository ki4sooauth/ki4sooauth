package com.gooagoo.trans.entity.gtsc03.transform;

import java.io.Serializable;

/**
 *  发票明细详细信息 
 */
public class Invoiceddetail implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  商品名称  */
	private String goodsname = "";

	/**  商品数量  */
	private String goodsnum = "";

	/**  商品单价  */
	private String goodsprice = "";

	/**  商品总价  */
	private String payprice = "";

	/**
	 * 设置 商品名称 
	 * @param goodsname	 商品名称 
	 */
	public void setGoodsname(String goodsname)
	{
		this.goodsname = goodsname != null ? goodsname : "";
	}

	/**
	 * 获取 商品名称 
	 * @return	 商品名称 
	 */
	public String getGoodsname()
	{
		return this.goodsname;
	}

	/**
	 * 设置 商品数量 
	 * @param goodsnum	 商品数量 
	 */
	public void setGoodsnum(String goodsnum)
	{
		this.goodsnum = goodsnum != null ? goodsnum : "";
	}

	/**
	 * 获取 商品数量 
	 * @return	 商品数量 
	 */
	public String getGoodsnum()
	{
		return this.goodsnum;
	}

	/**
	 * 设置 商品单价 
	 * @param goodsprice	 商品单价 
	 */
	public void setGoodsprice(String goodsprice)
	{
		this.goodsprice = goodsprice != null ? goodsprice : "";
	}

	/**
	 * 获取 商品单价 
	 * @return	 商品单价 
	 */
	public String getGoodsprice()
	{
		return this.goodsprice;
	}

	/**
	 * 设置 商品总价 
	 * @param payprice	 商品总价 
	 */
	public void setPayprice(String payprice)
	{
		this.payprice = payprice != null ? payprice : "";
	}

	/**
	 * 获取 商品总价 
	 * @return	 商品总价 
	 */
	public String getPayprice()
	{
		return this.payprice;
	}
}