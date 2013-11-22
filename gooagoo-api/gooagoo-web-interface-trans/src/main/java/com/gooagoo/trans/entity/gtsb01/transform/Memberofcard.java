package com.gooagoo.trans.entity.gtsb01.transform;

import java.io.Serializable;

/**
 * 会员信息
 */
public class Memberofcard implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 会员卡音频编号 */
	private String scardno = "";

	/** 用户编号 */
	private String userid = "";

	/** 会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡 */
	private String cardtype2 = "";

	/** 商铺id */
	private String shopid = "";

	/** 物理卡号 */
	private String phycardno = "";

	/** 有效期限起 */
	private String createtime = "";

	/** 有效期限止 */
	private String expiredate = "";

	/** 时间戳 */
	private String ctimestamp = "";

	/** 是否删除，Y-已删除，N-未删除 */
	private String isdel = "";

	/**
	 * 设置会员卡音频编号
	 * @param scardno	会员卡音频编号
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取会员卡音频编号
	 * @return	会员卡音频编号
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置用户编号
	 * @param userid	用户编号
	 */
	public void setUserid(String userid)
	{
		this.userid = userid != null ? userid : "";
	}

	/**
	 * 获取用户编号
	 * @return	用户编号
	 */
	public String getUserid()
	{
		return this.userid;
	}

	/**
	 * 设置会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 * @param cardtype2	会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 */
	public void setCardtype2(String cardtype2)
	{
		this.cardtype2 = cardtype2 != null ? cardtype2 : "";
	}

	/**
	 * 获取会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 * @return	会员卡类型，00表示关注信息卡，10-F0表示电子卡，F1-FF表示实体卡
	 */
	public String getCardtype2()
	{
		return this.cardtype2;
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
	 * 设置物理卡号
	 * @param phycardno	物理卡号
	 */
	public void setPhycardno(String phycardno)
	{
		this.phycardno = phycardno != null ? phycardno : "";
	}

	/**
	 * 获取物理卡号
	 * @return	物理卡号
	 */
	public String getPhycardno()
	{
		return this.phycardno;
	}

	/**
	 * 设置有效期限起
	 * @param createtime	有效期限起
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取有效期限起
	 * @return	有效期限起
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}

	/**
	 * 设置有效期限止
	 * @param expiredate	有效期限止
	 */
	public void setExpiredate(String expiredate)
	{
		this.expiredate = expiredate != null ? expiredate : "";
	}

	/**
	 * 获取有效期限止
	 * @return	有效期限止
	 */
	public String getExpiredate()
	{
		return this.expiredate;
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