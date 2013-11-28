package com.gooagoo.mobile.entity.mobn04.transform;

import java.io.Serializable;

/**
 *  购物车中商品信息 
 */
public class Goodsinfolist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 购物车编号, 自动编号，UUID,购物车表主键  */
	private String shoppingcartid = "";

	/**  商家编号  */
	private String shopid = "";

	/**  实体店编号  */
	private String shopenityid = "";

	/**  商品编号  */
	private String goodsid = "";

	/**  商品名称  */
	private String goodsname = "";

	/**  商品自定义序列号  */
	private String itemserial = "";

	/**  商品价格  */
	private String price = "";

	/**  商品主图地址  */
	private String goodsimg = "";

	/**  商品数量  */
	private String goodsnum = "";

	/**  商品详情url,商品详情介绍url  */
	private String introduceurl = "";

	/**  商品营销url  */
	private String goodsmarketingurl = "";

	/**
	 * 设置购物车编号, 自动编号，UUID,购物车表主键 
	 * @param shoppingcartid	购物车编号, 自动编号，UUID,购物车表主键 
	 */
	public void setShoppingcartid(String shoppingcartid)
	{
		this.shoppingcartid = shoppingcartid != null ? shoppingcartid : "";
	}

	/**
	 * 获取购物车编号, 自动编号，UUID,购物车表主键 
	 * @return	购物车编号, 自动编号，UUID,购物车表主键 
	 */
	public String getShoppingcartid()
	{
		return this.shoppingcartid;
	}

	/**
	 * 设置 商家编号 
	 * @param shopid	 商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取 商家编号 
	 * @return	 商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置 实体店编号 
	 * @param shopenityid	 实体店编号 
	 */
	public void setShopenityid(String shopenityid)
	{
		this.shopenityid = shopenityid != null ? shopenityid : "";
	}

	/**
	 * 获取 实体店编号 
	 * @return	 实体店编号 
	 */
	public String getShopenityid()
	{
		return this.shopenityid;
	}

	/**
	 * 设置 商品编号 
	 * @param goodsid	 商品编号 
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取 商品编号 
	 * @return	 商品编号 
	 */
	public String getGoodsid()
	{
		return this.goodsid;
	}

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
	 * 设置 商品自定义序列号 
	 * @param itemserial	 商品自定义序列号 
	 */
	public void setItemserial(String itemserial)
	{
		this.itemserial = itemserial != null ? itemserial : "";
	}

	/**
	 * 获取 商品自定义序列号 
	 * @return	 商品自定义序列号 
	 */
	public String getItemserial()
	{
		return this.itemserial;
	}

	/**
	 * 设置 商品价格 
	 * @param price	 商品价格 
	 */
	public void setPrice(String price)
	{
		this.price = price != null ? price : "";
	}

	/**
	 * 获取 商品价格 
	 * @return	 商品价格 
	 */
	public String getPrice()
	{
		return this.price;
	}

	/**
	 * 设置 商品主图地址 
	 * @param goodsimg	 商品主图地址 
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取 商品主图地址 
	 * @return	 商品主图地址 
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
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
	 * 设置 商品营销url 
	 * @param goodsmarketingurl	 商品营销url 
	 */
	public void setGoodsmarketingurl(String goodsmarketingurl)
	{
		this.goodsmarketingurl = goodsmarketingurl != null ? goodsmarketingurl : "";
	}

	/**
	 * 获取 商品营销url 
	 * @return	 商品营销url 
	 */
	public String getGoodsmarketingurl()
	{
		return this.goodsmarketingurl;
	}
}