package com.gooagoo.gas.entity.gase06.transform;

import java.io.Serializable;

/**
 *  收藏信息 
 */
public class Favoritelist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 收藏信息的id  */
	private String favoriteid = "";

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

	/** 商品价格  */
	private String price = "";

	/** 优惠是否已使用，Y-已使用，N-未使用   */
	private String isused = "";

	/** 信息的小图片  */
	private String infopic = "";

	/** 是否删除，Y-已删除，N-未删除   */
	private String isdel = "";

	/** 时间戳  */
	private String ctimestamp = "";

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
	 * 设置时间戳 
	 * @param ctimestamp	时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取时间戳 
	 * @return	时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}