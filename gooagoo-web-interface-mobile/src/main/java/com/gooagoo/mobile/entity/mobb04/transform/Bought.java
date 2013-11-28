package com.gooagoo.mobile.entity.mobb04.transform;

import java.io.Serializable;

/**
 * 买过此商品的还购买过哪些商品 
 */
public class Bought implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品的id  */
	private String goodsid = "";

	/** 店铺id  */
	private String shopid = "";

	/** 商品小图  */
	private String goodsimg = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品价格  */
	private String price = "";

	/** 销售数量 */
	private String salenums = "";

	/**
	 * 设置商品的id 
	 * @param goodsid	商品的id 
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取商品的id 
	 * @return	商品的id 
	 */
	public String getGoodsid()
	{
		return this.goodsid;
	}

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
	 * 设置商品小图 
	 * @param goodsimg	商品小图 
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取商品小图 
	 * @return	商品小图 
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
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

	/**
	 * 设置销售数量
	 * @param salenums	销售数量
	 */
	public void setSalenums(String salenums)
	{
		this.salenums = salenums != null ? salenums : "";
	}

	/**
	 * 获取销售数量
	 * @return	销售数量
	 */
	public String getSalenums()
	{
		return this.salenums;
	}
}