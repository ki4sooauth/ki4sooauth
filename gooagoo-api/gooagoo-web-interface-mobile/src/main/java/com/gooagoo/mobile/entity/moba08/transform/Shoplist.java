package com.gooagoo.mobile.entity.moba08.transform;

import java.io.Serializable;

/**
 *  商家列表 
 */
public class Shoplist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家id  */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 商家正方形logo  */
	private String squarelogo = "";

	/** 商家长方形logo  */
	private String oblonglogo = "";

	/** 商家名首字母  */
	private String shopfirstchar = "";

	/** 商家类别  */
	private String shoptypeleaf = "";

	/** 是否删除，Y-已删除，N-未删除  */
	private String isdel = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

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
	 * 设置商家正方形logo 
	 * @param squarelogo	商家正方形logo 
	 */
	public void setSquarelogo(String squarelogo)
	{
		this.squarelogo = squarelogo != null ? squarelogo : "";
	}

	/**
	 * 获取商家正方形logo 
	 * @return	商家正方形logo 
	 */
	public String getSquarelogo()
	{
		return this.squarelogo;
	}

	/**
	 * 设置商家长方形logo 
	 * @param oblonglogo	商家长方形logo 
	 */
	public void setOblonglogo(String oblonglogo)
	{
		this.oblonglogo = oblonglogo != null ? oblonglogo : "";
	}

	/**
	 * 获取商家长方形logo 
	 * @return	商家长方形logo 
	 */
	public String getOblonglogo()
	{
		return this.oblonglogo;
	}

	/**
	 * 设置商家名首字母 
	 * @param shopfirstchar	商家名首字母 
	 */
	public void setShopfirstchar(String shopfirstchar)
	{
		this.shopfirstchar = shopfirstchar != null ? shopfirstchar : "";
	}

	/**
	 * 获取商家名首字母 
	 * @return	商家名首字母 
	 */
	public String getShopfirstchar()
	{
		return this.shopfirstchar;
	}

	/**
	 * 设置商家类别 
	 * @param shoptypeleaf	商家类别 
	 */
	public void setShoptypeleaf(String shoptypeleaf)
	{
		this.shoptypeleaf = shoptypeleaf != null ? shoptypeleaf : "";
	}

	/**
	 * 获取商家类别 
	 * @return	商家类别 
	 */
	public String getShoptypeleaf()
	{
		return this.shoptypeleaf;
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