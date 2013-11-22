package com.gooagoo.mobile.entity.moba01.transform;

import java.io.Serializable;

/**
 *  未读通知信息 
 */
public class Noreadnoticeinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  商家编号  */
	private String shopid = "";

	/** 未读通知条数 */
	private String noreadnoticenums = "";

	/**
	 * 设置 商家编号 
	 * @param shopid	 商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取 商家编号 
	 * @return	 商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置未读通知条数
	 * @param noreadnoticenums	未读通知条数
	 */
	public void setNoreadnoticenums(String noreadnoticenums)
	{
		this.noreadnoticenums = noreadnoticenums != null ? noreadnoticenums : "";
	}

	/**
	 * 获取未读通知条数
	 * @return	未读通知条数
	 */
	public String getNoreadnoticenums()
	{
		return this.noreadnoticenums;
	}
}