package com.gooagoo.gas.entity.gash01.transform;

import java.io.Serializable;

/**
 * 店员信息
 */
public class Intercomuserinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 店员助理id */
	private String shopuserid = "";

	/** 用户名称 */
	private String shopusername = "";

	/** 店铺id(当前实体店id) */
	private String shopentityid = "";

	/** 用户图片 */
	private String shopuserimg = "";

	/**
	 * 设置店员助理id
	 * @param shopuserid	店员助理id
	 */
	public void setShopuserid(String shopuserid)
	{
		this.shopuserid = shopuserid != null ? shopuserid : "";
	}

	/**
	 * 获取店员助理id
	 * @return	店员助理id
	 */
	public String getShopuserid()
	{
		return this.shopuserid;
	}

	/**
	 * 设置用户名称
	 * @param shopusername	用户名称
	 */
	public void setShopusername(String shopusername)
	{
		this.shopusername = shopusername != null ? shopusername : "";
	}

	/**
	 * 获取用户名称
	 * @return	用户名称
	 */
	public String getShopusername()
	{
		return this.shopusername;
	}

	/**
	 * 设置店铺id(当前实体店id)
	 * @param shopentityid	店铺id(当前实体店id)
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取店铺id(当前实体店id)
	 * @return	店铺id(当前实体店id)
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置用户图片
	 * @param shopuserimg	用户图片
	 */
	public void setShopuserimg(String shopuserimg)
	{
		this.shopuserimg = shopuserimg != null ? shopuserimg : "";
	}

	/**
	 * 获取用户图片
	 * @return	用户图片
	 */
	public String getShopuserimg()
	{
		return this.shopuserimg;
	}
}