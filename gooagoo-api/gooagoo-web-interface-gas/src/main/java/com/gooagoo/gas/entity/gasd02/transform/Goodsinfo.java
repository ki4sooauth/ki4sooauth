package com.gooagoo.gas.entity.gasd02.transform;

import java.io.Serializable;

/**
 * 商品列表信息
 */
public class Goodsinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品id */
	private String goodsid = "";

	/** 商品名称 */
	private String goodsname = "";

	/** 商品价格 */
	private String goodsprice = "";

	/** 商品多个展示图片,以，隔开 */
	private String goodsimg = "";

	/** 品类名称 */
	private String goodscategoryleaf = "";

	/** 品牌名称 */
	private String goodsbrand = "";

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
	 * @param goodsprice	商品价格
	 */
	public void setGoodsprice(String goodsprice)
	{
		this.goodsprice = goodsprice != null ? goodsprice : "";
	}

	/**
	 * 获取商品价格
	 * @return	商品价格
	 */
	public String getGoodsprice()
	{
		return this.goodsprice;
	}

	/**
	 * 设置商品多个展示图片,以，隔开
	 * @param goodsimg	商品多个展示图片,以，隔开
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取商品多个展示图片,以，隔开
	 * @return	商品多个展示图片,以，隔开
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
	}

	/**
	 * 设置品类名称
	 * @param goodscategoryleaf	品类名称
	 */
	public void setGoodscategoryleaf(String goodscategoryleaf)
	{
		this.goodscategoryleaf = goodscategoryleaf != null ? goodscategoryleaf : "";
	}

	/**
	 * 获取品类名称
	 * @return	品类名称
	 */
	public String getGoodscategoryleaf()
	{
		return this.goodscategoryleaf;
	}

	/**
	 * 设置品牌名称
	 * @param goodsbrand	品牌名称
	 */
	public void setGoodsbrand(String goodsbrand)
	{
		this.goodsbrand = goodsbrand != null ? goodsbrand : "";
	}

	/**
	 * 获取品牌名称
	 * @return	品牌名称
	 */
	public String getGoodsbrand()
	{
		return this.goodsbrand;
	}
}