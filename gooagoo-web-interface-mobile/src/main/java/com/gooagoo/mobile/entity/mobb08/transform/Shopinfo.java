package com.gooagoo.mobile.entity.mobb08.transform;

import java.io.Serializable;

/**
 *  商家信息 
 */
public class Shopinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  商家id  */
	private String shopid = "";

	/** 商家logo，正方形  */
	private String logo1 = "";

	/**  会员卡卡头url  */
	private String cardheadurl = "";

	/**  商家关注数量  */
	private String attentionnums = "";

	/**  商家会员数量  */
	private String membernums = "";

	/**  精品数量 */
	private String numbers = "";

	/**
	 * 设置 商家id 
	 * @param shopid	 商家id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取 商家id 
	 * @return	 商家id 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置商家logo，正方形 
	 * @param logo1	商家logo，正方形 
	 */
	public void setLogo1(String logo1)
	{
		this.logo1 = logo1 != null ? logo1 : "";
	}

	/**
	 * 获取商家logo，正方形 
	 * @return	商家logo，正方形 
	 */
	public String getLogo1()
	{
		return this.logo1;
	}

	/**
	 * 设置 会员卡卡头url 
	 * @param cardheadurl	 会员卡卡头url 
	 */
	public void setCardheadurl(String cardheadurl)
	{
		this.cardheadurl = cardheadurl != null ? cardheadurl : "";
	}

	/**
	 * 获取 会员卡卡头url 
	 * @return	 会员卡卡头url 
	 */
	public String getCardheadurl()
	{
		return this.cardheadurl;
	}

	/**
	 * 设置 商家关注数量 
	 * @param attentionnums	 商家关注数量 
	 */
	public void setAttentionnums(String attentionnums)
	{
		this.attentionnums = attentionnums != null ? attentionnums : "";
	}

	/**
	 * 获取 商家关注数量 
	 * @return	 商家关注数量 
	 */
	public String getAttentionnums()
	{
		return this.attentionnums;
	}

	/**
	 * 设置 商家会员数量 
	 * @param membernums	 商家会员数量 
	 */
	public void setMembernums(String membernums)
	{
		this.membernums = membernums != null ? membernums : "";
	}

	/**
	 * 获取 商家会员数量 
	 * @return	 商家会员数量 
	 */
	public String getMembernums()
	{
		return this.membernums;
	}

	/**
	 * 设置 精品数量
	 * @param numbers	 精品数量
	 */
	public void setNumbers(String numbers)
	{
		this.numbers = numbers != null ? numbers : "";
	}

	/**
	 * 获取 精品数量
	 * @return	 精品数量
	 */
	public String getNumbers()
	{
		return this.numbers;
	}
}