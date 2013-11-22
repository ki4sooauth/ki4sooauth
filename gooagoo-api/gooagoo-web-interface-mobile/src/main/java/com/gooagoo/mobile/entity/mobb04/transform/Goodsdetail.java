package com.gooagoo.mobile.entity.mobb04.transform;

import java.io.Serializable;

/**
 *  商品信息 
 */
public class Goodsdetail implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品的id  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品价格  */
	private String price = "";

	/** 商品促销价  */
	private String discountprice = "";

	/** 访问链接url  */
	private String linkurl = "";

	/** 商品小图  */
	private String goodsimg = "";

	/** 商品概要描述  */
	private String goodscontent = "";

	/** 商品评分  */
	private String goodsscore = "";

	/** 店铺id  */
	private String shopid = "";

	/** 实体店id  */
	private String shopentityid = "";

	/** 买过此商品的还购买过哪些商品  */
	private java.util.List<Bought> bought = new java.util.ArrayList<Bought>();

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
	 * 设置商品促销价 
	 * @param discountprice	商品促销价 
	 */
	public void setDiscountprice(String discountprice)
	{
		this.discountprice = discountprice != null ? discountprice : "";
	}

	/**
	 * 获取商品促销价 
	 * @return	商品促销价 
	 */
	public String getDiscountprice()
	{
		return this.discountprice;
	}

	/**
	 * 设置访问链接url 
	 * @param linkurl	访问链接url 
	 */
	public void setLinkurl(String linkurl)
	{
		this.linkurl = linkurl != null ? linkurl : "";
	}

	/**
	 * 获取访问链接url 
	 * @return	访问链接url 
	 */
	public String getLinkurl()
	{
		return this.linkurl;
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
	 * 设置商品评分 
	 * @param goodsscore	商品评分 
	 */
	public void setGoodsscore(String goodsscore)
	{
		this.goodsscore = goodsscore != null ? goodsscore : "";
	}

	/**
	 * 获取商品评分 
	 * @return	商品评分 
	 */
	public String getGoodsscore()
	{
		return this.goodsscore;
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
	 * 设置买过此商品的还购买过哪些商品 
	 * @param bought	买过此商品的还购买过哪些商品 
	 */
	public void setBought(java.util.List<Bought> bought)
	{
		this.bought = bought;
	}

	/**
	 * 获取买过此商品的还购买过哪些商品 
	 * @return	买过此商品的还购买过哪些商品 
	 */
	public java.util.List<Bought> getBought()
	{
		return this.bought;
	}

	/**
	 * 添加买过此商品的还购买过哪些商品 
	 * @return bought	买过此商品的还购买过哪些商品 
	 */
	public Bought addMoreBought() {
		Bought bought = new Bought();
		this.bought.add(bought);
		return bought;
	}
}