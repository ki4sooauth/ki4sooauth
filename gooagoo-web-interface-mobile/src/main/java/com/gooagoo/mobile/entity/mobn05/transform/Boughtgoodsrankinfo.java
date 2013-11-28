package com.gooagoo.mobile.entity.mobn05.transform;

import java.io.Serializable;

/**
 *  已经购买过商品次数排行信息
 */
public class Boughtgoodsrankinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品编号 */
	private String goodsid = "";

	/** 商品名称 */
	private String goodsname = "";

	/** 价格 */
	private String price = "";

	/** 商品图片 */
	private String goodsimg = "";

	/** 实体店编号 */
	private String shopentityid = "";

	/** 商家名称 */
	private String shopname = "";

	/**  商品详情url,商品详情介绍url  */
	private String introduceurl = "";

	/** 购过次数 */
	private String buycount = "";

	/**
	 * 设置商品编号
	 * @param goodsid	商品编号
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取商品编号
	 * @return	商品编号
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
	 * 设置价格
	 * @param price	价格
	 */
	public void setPrice(String price)
	{
		this.price = price != null ? price : "";
	}

	/**
	 * 获取价格
	 * @return	价格
	 */
	public String getPrice()
	{
		return this.price;
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
	 * 设置商家名称
	 * @param shopname	商家名称
	 */
	public void setShopname(String shopname)
	{
		this.shopname = shopname != null ? shopname : "";
	}

	/**
	 * 获取商家名称
	 * @return	商家名称
	 */
	public String getShopname()
	{
		return this.shopname;
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

	/**
	 * 设置购过次数
	 * @param buycount	购过次数
	 */
	public void setBuycount(String buycount)
	{
		this.buycount = buycount != null ? buycount : "";
	}

	/**
	 * 获取购过次数
	 * @return	购过次数
	 */
	public String getBuycount()
	{
		return this.buycount;
	}
}