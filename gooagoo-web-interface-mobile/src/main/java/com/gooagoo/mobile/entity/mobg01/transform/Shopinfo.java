package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  商家信息 
 */
public class Shopinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 商家类型（一级类别）  */
	private String shoptypelv1 = "";

	/** 商家类型（一级类别）名称  */
	private String shoptypelv1name = "";

	/** 商家类型（二级类别）  */
	private String shoptypelv2 = "";

	/** 商家类型（二级类别）名称  */
	private String shoptypelv2name = "";

	/** 商家logo，长方形  */
	private String logor = "";

	/** 商家logo，正方形  */
	private String logos = "";

	/** 虚拟商家地址  */
	private String virtureshopurl = "";

	/** 积分商城地址  */
	private String shopintegralurl = "";

	/** 是否删除，Y-已删除，N-未删除  */
	private String isdel = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

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
	 * 设置商家类型（一级类别） 
	 * @param shoptypelv1	商家类型（一级类别） 
	 */
	public void setShoptypelv1(String shoptypelv1)
	{
		this.shoptypelv1 = shoptypelv1 != null ? shoptypelv1 : "";
	}

	/**
	 * 获取商家类型（一级类别） 
	 * @return	商家类型（一级类别） 
	 */
	public String getShoptypelv1()
	{
		return this.shoptypelv1;
	}

	/**
	 * 设置商家类型（一级类别）名称 
	 * @param shoptypelv1name	商家类型（一级类别）名称 
	 */
	public void setShoptypelv1name(String shoptypelv1name)
	{
		this.shoptypelv1name = shoptypelv1name != null ? shoptypelv1name : "";
	}

	/**
	 * 获取商家类型（一级类别）名称 
	 * @return	商家类型（一级类别）名称 
	 */
	public String getShoptypelv1name()
	{
		return this.shoptypelv1name;
	}

	/**
	 * 设置商家类型（二级类别） 
	 * @param shoptypelv2	商家类型（二级类别） 
	 */
	public void setShoptypelv2(String shoptypelv2)
	{
		this.shoptypelv2 = shoptypelv2 != null ? shoptypelv2 : "";
	}

	/**
	 * 获取商家类型（二级类别） 
	 * @return	商家类型（二级类别） 
	 */
	public String getShoptypelv2()
	{
		return this.shoptypelv2;
	}

	/**
	 * 设置商家类型（二级类别）名称 
	 * @param shoptypelv2name	商家类型（二级类别）名称 
	 */
	public void setShoptypelv2name(String shoptypelv2name)
	{
		this.shoptypelv2name = shoptypelv2name != null ? shoptypelv2name : "";
	}

	/**
	 * 获取商家类型（二级类别）名称 
	 * @return	商家类型（二级类别）名称 
	 */
	public String getShoptypelv2name()
	{
		return this.shoptypelv2name;
	}

	/**
	 * 设置商家logo，长方形 
	 * @param logor	商家logo，长方形 
	 */
	public void setLogor(String logor)
	{
		this.logor = logor != null ? logor : "";
	}

	/**
	 * 获取商家logo，长方形 
	 * @return	商家logo，长方形 
	 */
	public String getLogor()
	{
		return this.logor;
	}

	/**
	 * 设置商家logo，正方形 
	 * @param logos	商家logo，正方形 
	 */
	public void setLogos(String logos)
	{
		this.logos = logos != null ? logos : "";
	}

	/**
	 * 获取商家logo，正方形 
	 * @return	商家logo，正方形 
	 */
	public String getLogos()
	{
		return this.logos;
	}

	/**
	 * 设置虚拟商家地址 
	 * @param virtureshopurl	虚拟商家地址 
	 */
	public void setVirtureshopurl(String virtureshopurl)
	{
		this.virtureshopurl = virtureshopurl != null ? virtureshopurl : "";
	}

	/**
	 * 获取虚拟商家地址 
	 * @return	虚拟商家地址 
	 */
	public String getVirtureshopurl()
	{
		return this.virtureshopurl;
	}

	/**
	 * 设置积分商城地址 
	 * @param shopintegralurl	积分商城地址 
	 */
	public void setShopintegralurl(String shopintegralurl)
	{
		this.shopintegralurl = shopintegralurl != null ? shopintegralurl : "";
	}

	/**
	 * 获取积分商城地址 
	 * @return	积分商城地址 
	 */
	public String getShopintegralurl()
	{
		return this.shopintegralurl;
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