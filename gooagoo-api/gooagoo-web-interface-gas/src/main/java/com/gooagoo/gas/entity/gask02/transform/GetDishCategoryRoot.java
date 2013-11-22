package com.gooagoo.gas.entity.gask02.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 菜品类别信息获取
 */
public class GetDishCategoryRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 品类信息 */
	private java.util.List<Foodkinds> foodkinds = null;

	/**
	 * 设置查询结果编码，true-成功，false-失败
	 * @param result	查询结果编码，true-成功，false-失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取查询结果编码，true-成功，false-失败
	 * @return	查询结果编码，true-成功，false-失败
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置查询结果描述
	 * @param msg	查询结果描述
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取查询结果描述
	 * @return	查询结果描述
	 */
	public String getMsg()
	{
		return this.msg;
	}

	/**
	 * 设置 提示信息编号 
	 * @param msgcode	 提示信息编号 
	 */
	public void setMsgcode(String msgcode)
	{
		this.msgcode = msgcode != null ? msgcode : "";
	}

	/**
	 * 获取 提示信息编号 
	 * @return	 提示信息编号 
	 */
	public String getMsgcode()
	{
		return this.msgcode;
	}

	/**
	 * 设置品类信息
	 * @param foodkinds	品类信息
	 */
	public void setFoodkinds(java.util.List<Foodkinds> foodkinds)
	{
		this.foodkinds = foodkinds;
	}

	/**
	 * 获取品类信息
	 * @return	品类信息
	 */
	public java.util.List<Foodkinds> getFoodkinds()
	{
		return this.foodkinds;
	}

	/**
	 * 添加品类信息
	 * @return foodkinds	品类信息
	 */
	public Foodkinds addMoreFoodkinds() {
		Foodkinds foodkinds = new Foodkinds();
		this.foodkinds.add(foodkinds);
		return foodkinds;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}