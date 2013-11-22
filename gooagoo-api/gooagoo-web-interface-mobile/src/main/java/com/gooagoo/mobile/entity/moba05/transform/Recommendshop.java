package com.gooagoo.mobile.entity.moba05.transform;

import java.io.Serializable;

/**
 *  商家信息 
 */
public class Recommendshop implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家logo  */
	private String logo = "";

	/** 商家编号 */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 会员数量  */
	private String membernums = "";

	/** 关注数量  */
	private String attentionnums = "";

	/** 背景颜色（RGB）  */
	private String colortype = "";

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
	 * 设置会员数量 
	 * @param membernums	会员数量 
	 */
	public void setMembernums(String membernums)
	{
		this.membernums = membernums != null ? membernums : "";
	}

	/**
	 * 获取会员数量 
	 * @return	会员数量 
	 */
	public String getMembernums()
	{
		return this.membernums;
	}

	/**
	 * 设置关注数量 
	 * @param attentionnums	关注数量 
	 */
	public void setAttentionnums(String attentionnums)
	{
		this.attentionnums = attentionnums != null ? attentionnums : "";
	}

	/**
	 * 获取关注数量 
	 * @return	关注数量 
	 */
	public String getAttentionnums()
	{
		return this.attentionnums;
	}

	/**
	 * 设置背景颜色（RGB） 
	 * @param colortype	背景颜色（RGB） 
	 */
	public void setColortype(String colortype)
	{
		this.colortype = colortype != null ? colortype : "";
	}

	/**
	 * 获取背景颜色（RGB） 
	 * @return	背景颜色（RGB） 
	 */
	public String getColortype()
	{
		return this.colortype;
	}
}