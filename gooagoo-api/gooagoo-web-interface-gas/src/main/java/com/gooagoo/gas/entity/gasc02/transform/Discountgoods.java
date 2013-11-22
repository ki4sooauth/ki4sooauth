package com.gooagoo.gas.entity.gasc02.transform;

import java.io.Serializable;

/**
 * 品类优惠信息
 */
public class Discountgoods implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家id */
	private String shopid = "";

	/** 商品id */
	private String goodsid = "";

	/** 商品名称 */
	private String goodsname = "";

	/** 商品价格 */
	private String price = "";

	/** 商品价格，实体店价格 */
	private String discountprice = "";

	/** 商品多个展示图片,以|隔开 */
	private String goodsimg = "";

	/** 品类名称 */
	private String goodscategoryleaf = "";

	/** 品牌名称 */
	private String goodsbrand = "";

	/** 产品特征 */
	private java.util.List<Goodsdetailextend> goodsdetailextend = new java.util.ArrayList<Goodsdetailextend>();

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

	/**
	 * 设置商品价格，实体店价格
	 * @param discountprice	商品价格，实体店价格
	 */
	public void setDiscountprice(String discountprice)
	{
		this.discountprice = discountprice != null ? discountprice : "";
	}

	/**
	 * 获取商品价格，实体店价格
	 * @return	商品价格，实体店价格
	 */
	public String getDiscountprice()
	{
		return this.discountprice;
	}

	/**
	 * 设置商品多个展示图片,以|隔开
	 * @param goodsimg	商品多个展示图片,以|隔开
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取商品多个展示图片,以|隔开
	 * @return	商品多个展示图片,以|隔开
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

	/**
	 * 设置产品特征
	 * @param goodsdetailextend	产品特征
	 */
	public void setGoodsdetailextend(java.util.List<Goodsdetailextend> goodsdetailextend)
	{
		this.goodsdetailextend = goodsdetailextend;
	}

	/**
	 * 获取产品特征
	 * @return	产品特征
	 */
	public java.util.List<Goodsdetailextend> getGoodsdetailextend()
	{
		return this.goodsdetailextend;
	}

	/**
	 * 添加产品特征
	 * @return goodsdetailextend	产品特征
	 */
	public Goodsdetailextend addMoreGoodsdetailextend() {
		Goodsdetailextend goodsdetailextend = new Goodsdetailextend();
		this.goodsdetailextend.add(goodsdetailextend);
		return goodsdetailextend;
	}
}