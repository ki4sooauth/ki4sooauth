package com.gooagoo.gas.entity.gasc01.transform;

import java.io.Serializable;

/**
 * 商品详细返回信息 
 */
public class Goodsinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品id  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品价格  */
	private String price = "";

	/**
	 * 设置商品id 
	 * @param goodsid	商品id 
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取商品id 
	 * @return	商品id 
	 */
	public String getGoodsid()
	{
		return this.goodsid;
	}

	/**
	 * 设置商品名称 
	 * @param goodsname	商品名称 
	 */
	public void setGoodsname(String goodsname)
	{
		this.goodsname = goodsname != null ? goodsname : "";
	}

	/**
	 * 获取商品名称 
	 * @return	商品名称 
	 */
	public String getGoodsname()
	{
		return this.goodsname;
	}

	/**
	 * 设置商品价格 
	 * @param price	商品价格 
	 */
	public void setPrice(String price)
	{
		this.price = price != null ? price : "";
	}

	/**
	 * 获取商品价格 
	 * @return	商品价格 
	 */
	public String getPrice()
	{
		return this.price;
	}
}