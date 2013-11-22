package com.gooagoo.mobile.entity.mobb08.transform;

import java.io.Serializable;

/**
 *  精品信息 
 */
public class Objinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  精品商品id）  */
	private String objid = "";

	/**  精品图片url  */
	private String objpicurl = "";

	/**  精品名称  */
	private String objname = "";

	/**  精品收藏人数  */
	private String favnums = "";

	/**  是否收藏，Y-已收藏，N-未收藏  */
	private String isfav = "";

	/**  详情url,详情介绍url  */
	private String introduceurl = "";

	/**
	 * 设置 精品商品id） 
	 * @param objid	 精品商品id） 
	 */
	public void setObjid(String objid)
	{
		this.objid = objid != null ? objid : "";
	}

	/**
	 * 获取 精品商品id） 
	 * @return	 精品商品id） 
	 */
	public String getObjid()
	{
		return this.objid;
	}

	/**
	 * 设置 精品图片url 
	 * @param objpicurl	 精品图片url 
	 */
	public void setObjpicurl(String objpicurl)
	{
		this.objpicurl = objpicurl != null ? objpicurl : "";
	}

	/**
	 * 获取 精品图片url 
	 * @return	 精品图片url 
	 */
	public String getObjpicurl()
	{
		return this.objpicurl;
	}

	/**
	 * 设置 精品名称 
	 * @param objname	 精品名称 
	 */
	public void setObjname(String objname)
	{
		this.objname = objname != null ? objname : "";
	}

	/**
	 * 获取 精品名称 
	 * @return	 精品名称 
	 */
	public String getObjname()
	{
		return this.objname;
	}

	/**
	 * 设置 精品收藏人数 
	 * @param favnums	 精品收藏人数 
	 */
	public void setFavnums(String favnums)
	{
		this.favnums = favnums != null ? favnums : "";
	}

	/**
	 * 获取 精品收藏人数 
	 * @return	 精品收藏人数 
	 */
	public String getFavnums()
	{
		return this.favnums;
	}

	/**
	 * 设置 是否收藏，Y-已收藏，N-未收藏 
	 * @param isfav	 是否收藏，Y-已收藏，N-未收藏 
	 */
	public void setIsfav(String isfav)
	{
		this.isfav = isfav != null ? isfav : "";
	}

	/**
	 * 获取 是否收藏，Y-已收藏，N-未收藏 
	 * @return	 是否收藏，Y-已收藏，N-未收藏 
	 */
	public String getIsfav()
	{
		return this.isfav;
	}

	/**
	 * 设置 详情url,详情介绍url 
	 * @param introduceurl	 详情url,详情介绍url 
	 */
	public void setIntroduceurl(String introduceurl)
	{
		this.introduceurl = introduceurl != null ? introduceurl : "";
	}

	/**
	 * 获取 详情url,详情介绍url 
	 * @return	 详情url,详情介绍url 
	 */
	public String getIntroduceurl()
	{
		return this.introduceurl;
	}
}