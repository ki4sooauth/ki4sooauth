package com.gooagoo.mobile.entity.mobe01.transform;

import java.io.Serializable;

/**
 * 账单商品列表 
 */
public class Goodslistg implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品id  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品价格  */
	private String goodsprice = "";

	/** 商品图片  */
	private String goodsimg = "";

	/** 促销价格  */
	private String promotionprice = "";

	/** 商品数量  */
	private String goodsnum = "";

	/**  商品详情url,商品详情介绍url  */
	private String introduceurl = "";

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
	 * 设置商品图片 
	 * @param goodsimg	商品图片 
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取商品图片 
	 * @return	商品图片 
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
	}

	/**
	 * 设置促销价格 
	 * @param promotionprice	促销价格 
	 */
	public void setPromotionprice(String promotionprice)
	{
		this.promotionprice = promotionprice != null ? promotionprice : "";
	}

	/**
	 * 获取促销价格 
	 * @return	促销价格 
	 */
	public String getPromotionprice()
	{
		return this.promotionprice;
	}

	/**
	 * 设置商品数量 
	 * @param goodsnum	商品数量 
	 */
	public void setGoodsnum(String goodsnum)
	{
		this.goodsnum = goodsnum != null ? goodsnum : "";
	}

	/**
	 * 获取商品数量 
	 * @return	商品数量 
	 */
	public String getGoodsnum()
	{
		return this.goodsnum;
	}

	/**
	 * 设置 商品详情url,商品详情介绍url 
	 * @param introduceurl	 商品详情url,商品详情介绍url 
	 */
	public void setIntroduceurl(String introduceurl)
	{
		this.introduceurl = introduceurl != null ? introduceurl : "";
	}

	/**
	 * 获取 商品详情url,商品详情介绍url 
	 * @return	 商品详情url,商品详情介绍url 
	 */
	public String getIntroduceurl()
	{
		return this.introduceurl;
	}
}