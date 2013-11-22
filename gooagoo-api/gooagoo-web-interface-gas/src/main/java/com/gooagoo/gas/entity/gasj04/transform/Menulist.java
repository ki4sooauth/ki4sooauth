package com.gooagoo.gas.entity.gasj04.transform;

import java.io.Serializable;

/**
 *  菜品详情列表 
 */
public class Menulist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 菜品id,取得是商品自定义序列号  */
	private String foodid = "";

	/** 菜品类别名称,(取菜品类别叶节点名称)  */
	private String foodkind = "";

	/** 菜品名称  */
	private String foodname = "";

	/** 单价  */
	private String foodprice = "";

	/**  数量  */
	private String num = "";

	/** 需支付金额 */
	private String foodspay = "";

	/** 是否已上菜  */
	private String ischeck = "";

	/**
	 * 设置菜品id,取得是商品自定义序列号 
	 * @param foodid	菜品id,取得是商品自定义序列号 
	 */
	public void setFoodid(String foodid)
	{
		this.foodid = foodid != null ? foodid : "";
	}

	/**
	 * 获取菜品id,取得是商品自定义序列号 
	 * @return	菜品id,取得是商品自定义序列号 
	 */
	public String getFoodid()
	{
		return this.foodid;
	}

	/**
	 * 设置菜品类别名称,(取菜品类别叶节点名称) 
	 * @param foodkind	菜品类别名称,(取菜品类别叶节点名称) 
	 */
	public void setFoodkind(String foodkind)
	{
		this.foodkind = foodkind != null ? foodkind : "";
	}

	/**
	 * 获取菜品类别名称,(取菜品类别叶节点名称) 
	 * @return	菜品类别名称,(取菜品类别叶节点名称) 
	 */
	public String getFoodkind()
	{
		return this.foodkind;
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
	 * 设置 数量 
	 * @param num	 数量 
	 */
	public void setNum(String num)
	{
		this.num = num != null ? num : "";
	}

	/**
	 * 获取 数量 
	 * @return	 数量 
	 */
	public String getNum()
	{
		return this.num;
	}

	/**
	 * 设置需支付金额
	 * @param foodspay	需支付金额
	 */
	public void setFoodspay(String foodspay)
	{
		this.foodspay = foodspay != null ? foodspay : "";
	}

	/**
	 * 获取需支付金额
	 * @return	需支付金额
	 */
	public String getFoodspay()
	{
		return this.foodspay;
	}

	/**
	 * 设置是否已上菜 
	 * @param ischeck	是否已上菜 
	 */
	public void setIscheck(String ischeck)
	{
		this.ischeck = ischeck != null ? ischeck : "";
	}

	/**
	 * 获取是否已上菜 
	 * @return	是否已上菜 
	 */
	public String getIscheck()
	{
		return this.ischeck;
	}
}