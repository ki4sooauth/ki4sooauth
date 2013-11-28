package com.gooagoo.mobile.entity.moba09.transform;

import java.io.Serializable;

/**
 *  店铺新卡信息 
 */
public class Shopcardinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 卡名  */
	private String cardname = "";

	/** 卡头图片 */
	private String cardheadurl = "";

	/** 卡身图片 */
	private String cardbodyurl = "";

	/** 升级所需积分 */
	private String needjifen = "";

	/** 会员权限说明  */
	private String description = "";

	/** 使用期限  */
	private String uselimited = "";

	/** 创建时间  */
	private String createtime = "";

	/**
	 * 设置卡名 
	 * @param cardname	卡名 
	 */
	public void setCardname(String cardname)
	{
		this.cardname = cardname != null ? cardname : "";
	}

	/**
	 * 获取卡名 
	 * @return	卡名 
	 */
	public String getCardname()
	{
		return this.cardname;
	}

	/**
	 * 设置卡头图片
	 * @param cardheadurl	卡头图片
	 */
	public void setCardheadurl(String cardheadurl)
	{
		this.cardheadurl = cardheadurl != null ? cardheadurl : "";
	}

	/**
	 * 获取卡头图片
	 * @return	卡头图片
	 */
	public String getCardheadurl()
	{
		return this.cardheadurl;
	}

	/**
	 * 设置卡身图片
	 * @param cardbodyurl	卡身图片
	 */
	public void setCardbodyurl(String cardbodyurl)
	{
		this.cardbodyurl = cardbodyurl != null ? cardbodyurl : "";
	}

	/**
	 * 获取卡身图片
	 * @return	卡身图片
	 */
	public String getCardbodyurl()
	{
		return this.cardbodyurl;
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
	 * 设置创建时间 
	 * @param createtime	创建时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取创建时间 
	 * @return	创建时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}
}