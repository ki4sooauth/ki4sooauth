package com.gooagoo.mobile.entity.mobe14.transform;

import java.io.Serializable;

/**
 * 品类销售排行 
 */
public class Goodssequencelist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品编号，uuid  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 品类编号（叶节点）  */
	private String goodscategoryleaf = "";

	/** 品类名称（叶节点）  */
	private String categoryname = "";

	/** 商品图片url，多张图以逗号分隔  */
	private String goodsimg = "";

	/** 商品价格  */
	private String price = "";

	/** 历史售出数量  */
	private String sellnum = "";

	/**  商品详情url,商品详情介绍url  */
	private String introduceurl = "";

	/**
	 * 设置商品编号，uuid 
	 * @param goodsid	商品编号，uuid 
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取商品编号，uuid 
	 * @return	商品编号，uuid 
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
	 * 设置品类编号（叶节点） 
	 * @param goodscategoryleaf	品类编号（叶节点） 
	 */
	public void setGoodscategoryleaf(String goodscategoryleaf)
	{
		this.goodscategoryleaf = goodscategoryleaf != null ? goodscategoryleaf : "";
	}

	/**
	 * 获取品类编号（叶节点） 
	 * @return	品类编号（叶节点） 
	 */
	public String getGoodscategoryleaf()
	{
		return this.goodscategoryleaf;
	}

	/**
	 * 设置品类名称（叶节点） 
	 * @param categoryname	品类名称（叶节点） 
	 */
	public void setCategoryname(String categoryname)
	{
		this.categoryname = categoryname != null ? categoryname : "";
	}

	/**
	 * 获取品类名称（叶节点） 
	 * @return	品类名称（叶节点） 
	 */
	public String getCategoryname()
	{
		return this.categoryname;
	}

	/**
	 * 设置商品图片url，多张图以逗号分隔 
	 * @param goodsimg	商品图片url，多张图以逗号分隔 
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取商品图片url，多张图以逗号分隔 
	 * @return	商品图片url，多张图以逗号分隔 
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
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
	 * 设置历史售出数量 
	 * @param sellnum	历史售出数量 
	 */
	public void setSellnum(String sellnum)
	{
		this.sellnum = sellnum != null ? sellnum : "";
	}

	/**
	 * 获取历史售出数量 
	 * @return	历史售出数量 
	 */
	public String getSellnum()
	{
		return this.sellnum;
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