package com.gooagoo.mobile.entity.mobe07.transform;

import java.io.Serializable;

/**
 * 订单 
 */
public class Getorderform implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 点菜单id  */
	private String billid = "";

	/** 商家id  */
	private String shopid = "";

	/** 用户id  */
	private String userid = "";

	/** 用户会员卡id  */
	private String scardno = "";

	/** 打折率  */
	private String discountrate = "";

	/** 商品累计数量  */
	private String goodstotalnum = "";

	/** 原始价格总数  */
	private String originalprice = "";

	/** 实收总额  */
	private String payprice = "";

	/** 商家名称  */
	private String shopname = "";

	/** 商家logo  */
	private String logo = "";

	/** 点菜单图片路径  */
	private String billimg = "";

	/** 桌号  */
	private String reserve2 = "";

	/** 房间号  */
	private String reserve1 = "";

	/** 商品信息列表  */
	private java.util.List<Goodslist> goodslist = new java.util.ArrayList<Goodslist>();

	/**
	 * 设置点菜单id 
	 * @param billid	点菜单id 
	 */
	public void setBillid(String billid)
	{
		this.billid = billid != null ? billid : "";
	}

	/**
	 * 获取点菜单id 
	 * @return	点菜单id 
	 */
	public String getBillid()
	{
		return this.billid;
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
	 * 设置用户id 
	 * @param userid	用户id 
	 */
	public void setUserid(String userid)
	{
		this.userid = userid != null ? userid : "";
	}

	/**
	 * 获取用户id 
	 * @return	用户id 
	 */
	public String getUserid()
	{
		return this.userid;
	}

	/**
	 * 设置用户会员卡id 
	 * @param scardno	用户会员卡id 
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取用户会员卡id 
	 * @return	用户会员卡id 
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置打折率 
	 * @param discountrate	打折率 
	 */
	public void setDiscountrate(String discountrate)
	{
		this.discountrate = discountrate != null ? discountrate : "";
	}

	/**
	 * 获取打折率 
	 * @return	打折率 
	 */
	public String getDiscountrate()
	{
		return this.discountrate;
	}

	/**
	 * 设置商品累计数量 
	 * @param goodstotalnum	商品累计数量 
	 */
	public void setGoodstotalnum(String goodstotalnum)
	{
		this.goodstotalnum = goodstotalnum != null ? goodstotalnum : "";
	}

	/**
	 * 获取商品累计数量 
	 * @return	商品累计数量 
	 */
	public String getGoodstotalnum()
	{
		return this.goodstotalnum;
	}

	/**
	 * 设置原始价格总数 
	 * @param originalprice	原始价格总数 
	 */
	public void setOriginalprice(String originalprice)
	{
		this.originalprice = originalprice != null ? originalprice : "";
	}

	/**
	 * 获取原始价格总数 
	 * @return	原始价格总数 
	 */
	public String getOriginalprice()
	{
		return this.originalprice;
	}

	/**
	 * 设置实收总额 
	 * @param payprice	实收总额 
	 */
	public void setPayprice(String payprice)
	{
		this.payprice = payprice != null ? payprice : "";
	}

	/**
	 * 获取实收总额 
	 * @return	实收总额 
	 */
	public String getPayprice()
	{
		return this.payprice;
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
	 * 设置商家logo 
	 * @param logo	商家logo 
	 */
	public void setLogo(String logo)
	{
		this.logo = logo != null ? logo : "";
	}

	/**
	 * 获取商家logo 
	 * @return	商家logo 
	 */
	public String getLogo()
	{
		return this.logo;
	}

	/**
	 * 设置点菜单图片路径 
	 * @param billimg	点菜单图片路径 
	 */
	public void setBillimg(String billimg)
	{
		this.billimg = billimg != null ? billimg : "";
	}

	/**
	 * 获取点菜单图片路径 
	 * @return	点菜单图片路径 
	 */
	public String getBillimg()
	{
		return this.billimg;
	}

	/**
	 * 设置桌号 
	 * @param reserve2	桌号 
	 */
	public void setReserve2(String reserve2)
	{
		this.reserve2 = reserve2 != null ? reserve2 : "";
	}

	/**
	 * 获取桌号 
	 * @return	桌号 
	 */
	public String getReserve2()
	{
		return this.reserve2;
	}

	/**
	 * 设置房间号 
	 * @param reserve1	房间号 
	 */
	public void setReserve1(String reserve1)
	{
		this.reserve1 = reserve1 != null ? reserve1 : "";
	}

	/**
	 * 获取房间号 
	 * @return	房间号 
	 */
	public String getReserve1()
	{
		return this.reserve1;
	}

	/**
	 * 设置商品信息列表 
	 * @param goodslist	商品信息列表 
	 */
	public void setGoodslist(java.util.List<Goodslist> goodslist)
	{
		this.goodslist = goodslist;
	}

	/**
	 * 获取商品信息列表 
	 * @return	商品信息列表 
	 */
	public java.util.List<Goodslist> getGoodslist()
	{
		return this.goodslist;
	}

	/**
	 * 添加商品信息列表 
	 * @return goodslist	商品信息列表 
	 */
	public Goodslist addMoreGoodslist() {
		Goodslist goodslist = new Goodslist();
		this.goodslist.add(goodslist);
		return goodslist;
	}
}