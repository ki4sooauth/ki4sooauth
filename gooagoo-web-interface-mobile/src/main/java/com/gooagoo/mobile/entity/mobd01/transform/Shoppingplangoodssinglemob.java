package com.gooagoo.mobile.entity.mobd01.transform;

import java.io.Serializable;

/**
 *  商品列表 
 */
public class Shoppingplangoodssinglemob implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 购物清单详细编号，UUID  */
	private String shoppinggoodsid = "";

	/** 商品编号  */
	private String goodsid = "";

	/** 商品名称  */
	private String goodsname = "";

	/** 商品类型编号  */
	private String goodstypeid = "";

	/** 商品类型名称  */
	private String goodstypename = "";

	/** 商家编号  */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 是否删除，Y-已删除，N-未删除  */
	private String isdel = "";

	/** 创建时间  */
	private String createtime = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

	/**
	 * 设置购物清单详细编号，UUID 
	 * @param shoppinggoodsid	购物清单详细编号，UUID 
	 */
	public void setShoppinggoodsid(String shoppinggoodsid)
	{
		this.shoppinggoodsid = shoppinggoodsid != null ? shoppinggoodsid : "";
	}

	/**
	 * 获取购物清单详细编号，UUID 
	 * @return	购物清单详细编号，UUID 
	 */
	public String getShoppinggoodsid()
	{
		return this.shoppinggoodsid;
	}

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
	 * 设置商品类型编号 
	 * @param goodstypeid	商品类型编号 
	 */
	public void setGoodstypeid(String goodstypeid)
	{
		this.goodstypeid = goodstypeid != null ? goodstypeid : "";
	}

	/**
	 * 获取商品类型编号 
	 * @return	商品类型编号 
	 */
	public String getGoodstypeid()
	{
		return this.goodstypeid;
	}

	/**
	 * 设置商品类型名称 
	 * @param goodstypename	商品类型名称 
	 */
	public void setGoodstypename(String goodstypename)
	{
		this.goodstypename = goodstypename != null ? goodstypename : "";
	}

	/**
	 * 获取商品类型名称 
	 * @return	商品类型名称 
	 */
	public String getGoodstypename()
	{
		return this.goodstypename;
	}

	/**
	 * 设置商家编号 
	 * @param shopid	商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家编号 
	 * @return	商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
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
	 * 设置是否删除，Y-已删除，N-未删除 
	 * @param isdel	是否删除，Y-已删除，N-未删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除，Y-已删除，N-未删除 
	 * @return	是否删除，Y-已删除，N-未删除 
	 */
	public String getIsdel()
	{
		return this.isdel;
	}

	/**
	 * 设置创建时间 
	 * @param createtime	创建时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取创建时间 
	 * @return	创建时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}

	/**
	 * 设置最后一次修改时间 
	 * @param ctimestamp	最后一次修改时间 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取最后一次修改时间 
	 * @return	最后一次修改时间 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}