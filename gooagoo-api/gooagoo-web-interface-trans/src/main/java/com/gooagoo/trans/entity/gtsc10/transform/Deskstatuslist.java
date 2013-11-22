package com.gooagoo.trans.entity.gtsc10.transform;

import java.io.Serializable;

/**
 * 餐桌状态
 */
public class Deskstatuslist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 餐桌类型，如3-8人 */
	private String deskkind = "";

	/** 餐桌类别名称，如8人桌 */
	private String deskkindname = "";

	/**  当前类型餐桌总数，如:3-8人桌总数  */
	private String sum = "";

	/** 未被占有桌子数，即空余数 */
	private String free = "";

	/** 正在结账数 */
	private String occupancy = "";

	/** 正在用餐数量,即已点餐数 */
	private String usenum = "";

	/** 共有多少人排队等待使用当前类型的桌子 */
	private String list = "";

	/**
	 * 设置餐桌类型，如3-8人
	 * @param deskkind	餐桌类型，如3-8人
	 */
	public void setDeskkind(String deskkind)
	{
		this.deskkind = deskkind != null ? deskkind : "";
	}

	/**
	 * 获取餐桌类型，如3-8人
	 * @return	餐桌类型，如3-8人
	 */
	public String getDeskkind()
	{
		return this.deskkind;
	}

	/**
	 * 设置餐桌类别名称，如8人桌
	 * @param deskkindname	餐桌类别名称，如8人桌
	 */
	public void setDeskkindname(String deskkindname)
	{
		this.deskkindname = deskkindname != null ? deskkindname : "";
	}

	/**
	 * 获取餐桌类别名称，如8人桌
	 * @return	餐桌类别名称，如8人桌
	 */
	public String getDeskkindname()
	{
		return this.deskkindname;
	}

	/**
	 * 设置 当前类型餐桌总数，如:3-8人桌总数 
	 * @param sum	 当前类型餐桌总数，如:3-8人桌总数 
	 */
	public void setSum(String sum)
	{
		this.sum = sum != null ? sum : "";
	}

	/**
	 * 获取 当前类型餐桌总数，如:3-8人桌总数 
	 * @return	 当前类型餐桌总数，如:3-8人桌总数 
	 */
	public String getSum()
	{
		return this.sum;
	}

	/**
	 * 设置未被占有桌子数，即空余数
	 * @param free	未被占有桌子数，即空余数
	 */
	public void setFree(String free)
	{
		this.free = free != null ? free : "";
	}

	/**
	 * 获取未被占有桌子数，即空余数
	 * @return	未被占有桌子数，即空余数
	 */
	public String getFree()
	{
		return this.free;
	}

	/**
	 * 设置正在结账数
	 * @param occupancy	正在结账数
	 */
	public void setOccupancy(String occupancy)
	{
		this.occupancy = occupancy != null ? occupancy : "";
	}

	/**
	 * 获取正在结账数
	 * @return	正在结账数
	 */
	public String getOccupancy()
	{
		return this.occupancy;
	}

	/**
	 * 设置正在用餐数量,即已点餐数
	 * @param usenum	正在用餐数量,即已点餐数
	 */
	public void setUsenum(String usenum)
	{
		this.usenum = usenum != null ? usenum : "";
	}

	/**
	 * 获取正在用餐数量,即已点餐数
	 * @return	正在用餐数量,即已点餐数
	 */
	public String getUsenum()
	{
		return this.usenum;
	}

	/**
	 * 设置共有多少人排队等待使用当前类型的桌子
	 * @param list	共有多少人排队等待使用当前类型的桌子
	 */
	public void setList(String list)
	{
		this.list = list != null ? list : "";
	}

	/**
	 * 获取共有多少人排队等待使用当前类型的桌子
	 * @return	共有多少人排队等待使用当前类型的桌子
	 */
	public String getList()
	{
		return this.list;
	}
}