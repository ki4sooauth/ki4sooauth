package com.gooagoo.gas.entity.gask01.transform;

import java.io.Serializable;

/**
 * 餐饮商品详细返回信息
 */
public class Foodinfolist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 菜品id */
	private String foodid = "";

	/** 菜品一维码,对应手机页面上显示的编号   */
	private String onedimensioncode = "";

	/** 菜品类别名称 */
	private String foodkind = "";

	/** 菜品类别编码 */
	private String foodtype = "";

	/** 菜品名称 */
	private String foodname = "";

	/** 单价 */
	private String foodprice = "";

	/** 人气 */
	private String foodhot = "";

	/** 商品库存量：0：无，1：有 */
	private String inventory = "";

	/**
	 * 设置菜品id
	 * @param foodid	菜品id
	 */
	public void setFoodid(String foodid)
	{
		this.foodid = foodid != null ? foodid : "";
	}

	/**
	 * 获取菜品id
	 * @return	菜品id
	 */
	public String getFoodid()
	{
		return this.foodid;
	}

	/**
	 * 设置菜品一维码,对应手机页面上显示的编号  
	 * @param onedimensioncode	菜品一维码,对应手机页面上显示的编号  
	 */
	public void setOnedimensioncode(String onedimensioncode)
	{
		this.onedimensioncode = onedimensioncode != null ? onedimensioncode : "";
	}

	/**
	 * 获取菜品一维码,对应手机页面上显示的编号  
	 * @return	菜品一维码,对应手机页面上显示的编号  
	 */
	public String getOnedimensioncode()
	{
		return this.onedimensioncode;
	}

	/**
	 * 设置菜品类别名称
	 * @param foodkind	菜品类别名称
	 */
	public void setFoodkind(String foodkind)
	{
		this.foodkind = foodkind != null ? foodkind : "";
	}

	/**
	 * 获取菜品类别名称
	 * @return	菜品类别名称
	 */
	public String getFoodkind()
	{
		return this.foodkind;
	}

	/**
	 * 设置菜品类别编码
	 * @param foodtype	菜品类别编码
	 */
	public void setFoodtype(String foodtype)
	{
		this.foodtype = foodtype != null ? foodtype : "";
	}

	/**
	 * 获取菜品类别编码
	 * @return	菜品类别编码
	 */
	public String getFoodtype()
	{
		return this.foodtype;
	}

	/**
	 * 设置菜品名称
	 * @param foodname	菜品名称
	 */
	public void setFoodname(String foodname)
	{
		this.foodname = foodname != null ? foodname : "";
	}

	/**
	 * 获取菜品名称
	 * @return	菜品名称
	 */
	public String getFoodname()
	{
		return this.foodname;
	}

	/**
	 * 设置单价
	 * @param foodprice	单价
	 */
	public void setFoodprice(String foodprice)
	{
		this.foodprice = foodprice != null ? foodprice : "";
	}

	/**
	 * 获取单价
	 * @return	单价
	 */
	public String getFoodprice()
	{
		return this.foodprice;
	}

	/**
	 * 设置人气
	 * @param foodhot	人气
	 */
	public void setFoodhot(String foodhot)
	{
		this.foodhot = foodhot != null ? foodhot : "";
	}

	/**
	 * 获取人气
	 * @return	人气
	 */
	public String getFoodhot()
	{
		return this.foodhot;
	}

	/**
	 * 设置商品库存量：0：无，1：有
	 * @param inventory	商品库存量：0：无，1：有
	 */
	public void setInventory(String inventory)
	{
		this.inventory = inventory != null ? inventory : "";
	}

	/**
	 * 获取商品库存量：0：无，1：有
	 * @return	商品库存量：0：无，1：有
	 */
	public String getInventory()
	{
		return this.inventory;
	}
}