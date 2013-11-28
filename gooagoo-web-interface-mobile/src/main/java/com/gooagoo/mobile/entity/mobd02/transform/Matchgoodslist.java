package com.gooagoo.mobile.entity.mobd02.transform;

import java.io.Serializable;

/**
 *  购物匹配  
 */
public class Matchgoodslist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品的id  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品价格  */
	private String price = "";

	/** 商品图片  */
	private String goodsimg = "";

	/**  商品详情url,商品详情介绍url  */
	private String introduceurl = "";

	/** 商家id  */
	private String shopid = "";

	/** 实体店id  */
	private String shopentityid = "";

	/** 位置信息描述  */
	private String positionname = "";

	/** 商品概要描述  */
	private String goodscontent = "";

	/** 商家名称  */
	private String shopname = "";

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
	 * 设置商家id 
	 * @param shopid	商家id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家id 
	 * @return	商家id 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置实体店id 
	 * @param shopentityid	实体店id 
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取实体店id 
	 * @return	实体店id 
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置位置信息描述 
	 * @param positionname	位置信息描述 
	 */
	public void setPositionname(String positionname)
	{
		this.positionname = positionname != null ? positionname : "";
	}

	/**
	 * 获取位置信息描述 
	 * @return	位置信息描述 
	 */
	public String getPositionname()
	{
		return this.positionname;
	}

	/**
	 * 设置商品概要描述 
	 * @param goodscontent	商品概要描述 
	 */
	public void setGoodscontent(String goodscontent)
	{
		this.goodscontent = goodscontent != null ? goodscontent : "";
	}

	/**
	 * 获取商品概要描述 
	 * @return	商品概要描述 
	 */
	public String getGoodscontent()
	{
		return this.goodscontent;
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
}