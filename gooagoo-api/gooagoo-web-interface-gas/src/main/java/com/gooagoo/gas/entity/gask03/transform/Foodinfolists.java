package com.gooagoo.gas.entity.gask03.transform;

import java.io.Serializable;

/**
 * 菜品信息列表  
 */
public class Foodinfolists implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 菜品id  */
	private String foodid = "";

	/** 菜品类别  */
	private String foodkind = "";

	/** 单价  */
	private String foottype = "";

	/** 菜品类别  */
	private String foodname = "";

	/**  单价  */
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
	 * 设置菜品类别 
	 * @param foodkind	菜品类别 
	 */
	public void setFoodkind(String foodkind)
	{
		this.foodkind = foodkind != null ? foodkind : "";
	}

	/**
	 * 获取菜品类别 
	 * @return	菜品类别 
	 */
	public String getFoodkind()
	{
		return this.foodkind;
	}

	/**
	 * 设置单价 
	 * @param foottype	单价 
	 */
	public void setFoottype(String foottype)
	{
		this.foottype = foottype != null ? foottype : "";
	}

	/**
	 * 获取单价 
	 * @return	单价 
	 */
	public String getFoottype()
	{
		return this.foottype;
	}

	/**
	 * 设置菜品类别 
	 * @param foodname	菜品类别 
	 */
	public void setFoodname(String foodname)
	{
		this.foodname = foodname != null ? foodname : "";
	}

	/**
	 * 获取菜品类别 
	 * @return	菜品类别 
	 */
	public String getFoodname()
	{
		return this.foodname;
	}

	/**
	 * 设置 单价 
	 * @param foodprice	 单价 
	 */
	public void setFoodprice(String foodprice)
	{
		this.foodprice = foodprice != null ? foodprice : "";
	}

	/**
	 * 获取 单价 
	 * @return	 单价 
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