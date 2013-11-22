package com.gooagoo.mobile.entity.mobb01.transform;

import java.io.Serializable;

/**
 *  收藏信息 
 */
public class Favoritelistg implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 收藏信息的id  */
	private String favoriteid = "";

	/** 店铺的id  */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 商家logo长方形  */
	private String logo2 = "";

	/** 实体店id  */
	private String shopentityid = "";

	/** 收藏对象的id  */
	private String objectid = "";

	/** 相应信息的网址（如活动）  */
	private String infourl = "";

	/** 信息类型，A-活动，G-商品，C-优惠券  */
	private String infotype = "";

	/** 信息标题，如商品的名称  */
	private String infotitle = "";

	/** 信息开始日期，优惠和活动的期间  */
	private String infobegindate = "";

	/** 信息结束日期  */
	private String infoenddate = "";

	/** 信息是否已过期Y/N  */
	private String isoverdate = "";

	/** 商品价格  */
	private String price = "";

	/** 优惠是否已使用，Y-已使用，N-未使用   */
	private String isused = "";

	/** 信息的小图片  */
	private String infopic = "";

	/**
	 * 设置收藏信息的id 
	 * @param favoriteid	收藏信息的id 
	 */
	public void setFavoriteid(String favoriteid)
	{
		this.favoriteid = favoriteid != null ? favoriteid : "";
	}

	/**
	 * 获取收藏信息的id 
	 * @return	收藏信息的id 
	 */
	public String getFavoriteid()
	{
		return this.favoriteid;
	}

	/**
	 * 设置店铺的id 
	 * @param shopid	店铺的id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取店铺的id 
	 * @return	店铺的id 
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
	 * 设置商家logo长方形 
	 * @param logo2	商家logo长方形 
	 */
	public void setLogo2(String logo2)
	{
		this.logo2 = logo2 != null ? logo2 : "";
	}

	/**
	 * 获取商家logo长方形 
	 * @return	商家logo长方形 
	 */
	public String getLogo2()
	{
		return this.logo2;
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
	 * 设置收藏对象的id 
	 * @param objectid	收藏对象的id 
	 */
	public void setObjectid(String objectid)
	{
		this.objectid = objectid != null ? objectid : "";
	}

	/**
	 * 获取收藏对象的id 
	 * @return	收藏对象的id 
	 */
	public String getObjectid()
	{
		return this.objectid;
	}

	/**
	 * 设置相应信息的网址（如活动） 
	 * @param infourl	相应信息的网址（如活动） 
	 */
	public void setInfourl(String infourl)
	{
		this.infourl = infourl != null ? infourl : "";
	}

	/**
	 * 获取相应信息的网址（如活动） 
	 * @return	相应信息的网址（如活动） 
	 */
	public String getInfourl()
	{
		return this.infourl;
	}

	/**
	 * 设置信息类型，A-活动，G-商品，C-优惠券 
	 * @param infotype	信息类型，A-活动，G-商品，C-优惠券 
	 */
	public void setInfotype(String infotype)
	{
		this.infotype = infotype != null ? infotype : "";
	}

	/**
	 * 获取信息类型，A-活动，G-商品，C-优惠券 
	 * @return	信息类型，A-活动，G-商品，C-优惠券 
	 */
	public String getInfotype()
	{
		return this.infotype;
	}

	/**
	 * 设置信息标题，如商品的名称 
	 * @param infotitle	信息标题，如商品的名称 
	 */
	public void setInfotitle(String infotitle)
	{
		this.infotitle = infotitle != null ? infotitle : "";
	}

	/**
	 * 获取信息标题，如商品的名称 
	 * @return	信息标题，如商品的名称 
	 */
	public String getInfotitle()
	{
		return this.infotitle;
	}

	/**
	 * 设置信息开始日期，优惠和活动的期间 
	 * @param infobegindate	信息开始日期，优惠和活动的期间 
	 */
	public void setInfobegindate(String infobegindate)
	{
		this.infobegindate = infobegindate != null ? infobegindate : "";
	}

	/**
	 * 获取信息开始日期，优惠和活动的期间 
	 * @return	信息开始日期，优惠和活动的期间 
	 */
	public String getInfobegindate()
	{
		return this.infobegindate;
	}

	/**
	 * 设置信息结束日期 
	 * @param infoenddate	信息结束日期 
	 */
	public void setInfoenddate(String infoenddate)
	{
		this.infoenddate = infoenddate != null ? infoenddate : "";
	}

	/**
	 * 获取信息结束日期 
	 * @return	信息结束日期 
	 */
	public String getInfoenddate()
	{
		return this.infoenddate;
	}

	/**
	 * 设置信息是否已过期Y/N 
	 * @param isoverdate	信息是否已过期Y/N 
	 */
	public void setIsoverdate(String isoverdate)
	{
		this.isoverdate = isoverdate != null ? isoverdate : "";
	}

	/**
	 * 获取信息是否已过期Y/N 
	 * @return	信息是否已过期Y/N 
	 */
	public String getIsoverdate()
	{
		return this.isoverdate;
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
	 * 设置优惠是否已使用，Y-已使用，N-未使用  
	 * @param isused	优惠是否已使用，Y-已使用，N-未使用  
	 */
	public void setIsused(String isused)
	{
		this.isused = isused != null ? isused : "";
	}

	/**
	 * 获取优惠是否已使用，Y-已使用，N-未使用  
	 * @return	优惠是否已使用，Y-已使用，N-未使用  
	 */
	public String getIsused()
	{
		return this.isused;
	}

	/**
	 * 设置信息的小图片 
	 * @param infopic	信息的小图片 
	 */
	public void setInfopic(String infopic)
	{
		this.infopic = infopic != null ? infopic : "";
	}

	/**
	 * 获取信息的小图片 
	 * @return	信息的小图片 
	 */
	public String getInfopic()
	{
		return this.infopic;
	}
}