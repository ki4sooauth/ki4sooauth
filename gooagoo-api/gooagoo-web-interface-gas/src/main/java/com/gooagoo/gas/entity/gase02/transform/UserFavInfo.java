package com.gooagoo.gas.entity.gase02.transform;

import java.io.Serializable;

/**
 * TA的收藏商品信息 
 */
public class UserFavInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 店铺id  */
	private String shopid = "";

	/** 商品id  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品价格  */
	private String goodsprice = "";

	/** 商品多个展示图片,以，隔开  */
	private String goodsimg = "";

	/** 商品类别,查出该商品对应的根节点到叶节点的所有类别  */
	private java.util.List<Goodscategorylistf> goodscategorylistf = new java.util.ArrayList<Goodscategorylistf>();

	/** 品牌名称  */
	private String goodsbrand = "";

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
	 * 设置商品类别,查出该商品对应的根节点到叶节点的所有类别 
	 * @param goodscategorylistf	商品类别,查出该商品对应的根节点到叶节点的所有类别 
	 */
	public void setGoodscategorylistf(java.util.List<Goodscategorylistf> goodscategorylistf)
	{
		this.goodscategorylistf = goodscategorylistf;
	}

	/**
	 * 获取商品类别,查出该商品对应的根节点到叶节点的所有类别 
	 * @return	商品类别,查出该商品对应的根节点到叶节点的所有类别 
	 */
	public java.util.List<Goodscategorylistf> getGoodscategorylistf()
	{
		return this.goodscategorylistf;
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
	 * 添加商品类别,查出该商品对应的根节点到叶节点的所有类别 
	 * @return goodscategorylistf	商品类别,查出该商品对应的根节点到叶节点的所有类别 
	 */
	public Goodscategorylistf addMoreGoodscategorylistf() {
		Goodscategorylistf goodscategorylistf = new Goodscategorylistf();
		this.goodscategorylistf.add(goodscategorylistf);
		return goodscategorylistf;
	}
}