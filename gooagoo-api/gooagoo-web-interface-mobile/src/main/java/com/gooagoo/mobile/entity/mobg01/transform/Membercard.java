package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  会员卡基本信息 
 */
public class Membercard implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家编号  */
	private String shopid = "";

	/** 会员卡编号  */
	private String cardid = "";

	/** 会员卡名称  */
	private String cardname = "";

	/** 会员卡类型 :0-关注卡，1-电子卡，2-实体卡  */
	private String cardtype = "";

	/** 会员卡级别  */
	private String cardlvl = "";

	/** 是否需要审批  */
	private String needapproval = "";

	/** 升级所需积分  */
	private String needjifen = "";

	/** 会员卡图片url  */
	private String cardurl = "";

	/** 会员卡卡头图片url  */
	private String cardheadurl = "";

	/** 会员权限说明  */
	private String description = "";

	/** 使用期限  */
	private String uselimited = "";

	/** 是否删除  */
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
	 * 设置会员卡类型 :0-关注卡，1-电子卡，2-实体卡 
	 * @param cardtype	会员卡类型 :0-关注卡，1-电子卡，2-实体卡 
	 */
	public void setCardtype(String cardtype)
	{
		this.cardtype = cardtype != null ? cardtype : "";
	}

	/**
	 * 获取会员卡类型 :0-关注卡，1-电子卡，2-实体卡 
	 * @return	会员卡类型 :0-关注卡，1-电子卡，2-实体卡 
	 */
	public String getCardtype()
	{
		return this.cardtype;
	}

	/**
	 * 设置会员卡级别 
	 * @param cardlvl	会员卡级别 
	 */
	public void setCardlvl(String cardlvl)
	{
		this.cardlvl = cardlvl != null ? cardlvl : "";
	}

	/**
	 * 获取会员卡级别 
	 * @return	会员卡级别 
	 */
	public String getCardlvl()
	{
		return this.cardlvl;
	}

	/**
	 * 设置是否需要审批 
	 * @param needapproval	是否需要审批 
	 */
	public void setNeedapproval(String needapproval)
	{
		this.needapproval = needapproval != null ? needapproval : "";
	}

	/**
	 * 获取是否需要审批 
	 * @return	是否需要审批 
	 */
	public String getNeedapproval()
	{
		return this.needapproval;
	}

	/**
	 * 设置升级所需积分 
	 * @param needjifen	升级所需积分 
	 */
	public void setNeedjifen(String needjifen)
	{
		this.needjifen = needjifen != null ? needjifen : "";
	}

	/**
	 * 获取升级所需积分 
	 * @return	升级所需积分 
	 */
	public String getNeedjifen()
	{
		return this.needjifen;
	}

	/**
	 * 设置会员卡图片url 
	 * @param cardurl	会员卡图片url 
	 */
	public void setCardurl(String cardurl)
	{
		this.cardurl = cardurl != null ? cardurl : "";
	}

	/**
	 * 获取会员卡图片url 
	 * @return	会员卡图片url 
	 */
	public String getCardurl()
	{
		return this.cardurl;
	}

	/**
	 * 设置会员卡卡头图片url 
	 * @param cardheadurl	会员卡卡头图片url 
	 */
	public void setCardheadurl(String cardheadurl)
	{
		this.cardheadurl = cardheadurl != null ? cardheadurl : "";
	}

	/**
	 * 获取会员卡卡头图片url 
	 * @return	会员卡卡头图片url 
	 */
	public String getCardheadurl()
	{
		return this.cardheadurl;
	}

	/**
	 * 设置会员权限说明 
	 * @param description	会员权限说明 
	 */
	public void setDescription(String description)
	{
		this.description = description != null ? description : "";
	}

	/**
	 * 获取会员权限说明 
	 * @return	会员权限说明 
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * 设置使用期限 
	 * @param uselimited	使用期限 
	 */
	public void setUselimited(String uselimited)
	{
		this.uselimited = uselimited != null ? uselimited : "";
	}

	/**
	 * 获取使用期限 
	 * @return	使用期限 
	 */
	public String getUselimited()
	{
		return this.uselimited;
	}

	/**
	 * 设置是否删除 
	 * @param isdel	是否删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除 
	 * @return	是否删除 
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