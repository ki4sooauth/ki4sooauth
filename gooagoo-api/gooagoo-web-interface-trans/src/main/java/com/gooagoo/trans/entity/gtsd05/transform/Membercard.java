package com.gooagoo.trans.entity.gtsd05.transform;

import java.io.Serializable;

/**
 * 会员卡背景图片信息
 */
public class Membercard implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 会员卡编号 */
	private String cardid = "";

	/** 会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡 */
	private String cardtype = "";

	/** 商铺id */
	private String shopid = "";

	/** 会员卡名称 */
	private String cardname = "";

	/** 是否是物理卡(card_type2=2为物理卡) */
	private String isphysical = "";

	/** 卡图片地址 */
	private String cardurl = "";

	/** 时间戳 */
	private String ctimestamp = "";

	/** 是否删除，Y-已删除，N-未删除 */
	private String isdel = "";

	/**
	 * 设置会员卡编号
	 * @param cardid	会员卡编号
	 */
	public void setCardid(String cardid)
	{
		this.cardid = cardid != null ? cardid : "";
	}

	/**
	 * 获取会员卡编号
	 * @return	会员卡编号
	 */
	public String getCardid()
	{
		return this.cardid;
	}

	/**
	 * 设置会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 * @param cardtype	会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 */
	public void setCardtype(String cardtype)
	{
		this.cardtype = cardtype != null ? cardtype : "";
	}

	/**
	 * 获取会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 * @return	会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 */
	public String getCardtype()
	{
		return this.cardtype;
	}

	/**
	 * 设置商铺id
	 * @param shopid	商铺id
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商铺id
	 * @return	商铺id
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置会员卡名称
	 * @param cardname	会员卡名称
	 */
	public void setCardname(String cardname)
	{
		this.cardname = cardname != null ? cardname : "";
	}

	/**
	 * 获取会员卡名称
	 * @return	会员卡名称
	 */
	public String getCardname()
	{
		return this.cardname;
	}

	/**
	 * 设置是否是物理卡(card_type2=2为物理卡)
	 * @param isphysical	是否是物理卡(card_type2=2为物理卡)
	 */
	public void setIsphysical(String isphysical)
	{
		this.isphysical = isphysical != null ? isphysical : "";
	}

	/**
	 * 获取是否是物理卡(card_type2=2为物理卡)
	 * @return	是否是物理卡(card_type2=2为物理卡)
	 */
	public String getIsphysical()
	{
		return this.isphysical;
	}

	/**
	 * 设置卡图片地址
	 * @param cardurl	卡图片地址
	 */
	public void setCardurl(String cardurl)
	{
		this.cardurl = cardurl != null ? cardurl : "";
	}

	/**
	 * 获取卡图片地址
	 * @return	卡图片地址
	 */
	public String getCardurl()
	{
		return this.cardurl;
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
}