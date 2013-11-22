package com.gooagoo.gas.entity.gasj01.transform;

import java.io.Serializable;

/**
 * 餐桌状态
 */
public class Deskstatuslist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  当前类型餐桌总数，如:3-8人桌总数  */
	private String sum = "";

	/**  餐桌类型编码  */
	private String tabletypecode = "";

	/**  餐桌类型名称  */
	private String tabletypename = "";

	/** 未被占有桌子数，即空余数 */
	private String free = "";

	/** 正在结账数 */
	private String occupancy = "";

	/** 正在用餐数量,即已点餐数 */
	private String usenum = "";

	/** 共有多少人排队等待使用当前类型的桌子 */
	private String list = "";

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
	 * 设置 餐桌类型编码 
	 * @param tabletypecode	 餐桌类型编码 
	 */
	public void setTabletypecode(String tabletypecode)
	{
		this.tabletypecode = tabletypecode != null ? tabletypecode : "";
	}

	/**
	 * 获取 餐桌类型编码 
	 * @return	 餐桌类型编码 
	 */
	public String getTabletypecode()
	{
		return this.tabletypecode;
	}

	/**
	 * 设置 餐桌类型名称 
	 * @param tabletypename	 餐桌类型名称 
	 */
	public void setTabletypename(String tabletypename)
	{
		this.tabletypename = tabletypename != null ? tabletypename : "";
	}

	/**
	 * 获取 餐桌类型名称 
	 * @return	 餐桌类型名称 
	 */
	public String getTabletypename()
	{
		return this.tabletypename;
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