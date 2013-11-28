package com.gooagoo.mobile.entity.mobg01.transform;

import java.io.Serializable;

/**
 *  商家类型字典 
 */
public class Shoptype implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商家类型编号 ，只查询根节点 （parent_shop_type_id = “-1”的节点。） */
	private String shoptypeid = "";

	/** 商家类型名称  */
	private String shoptypename = "";

	/** 排序号  */
	private String sortorder = "";

	/** 是否删除，Y-已删除，N-未删除  */
	private String isdel = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

	/**
	 * 设置商家类型编号 ，只查询根节点 （parent_shop_type_id = “-1”的节点。）
	 * @param shoptypeid	商家类型编号 ，只查询根节点 （parent_shop_type_id = “-1”的节点。）
	 */
	public void setShoptypeid(String shoptypeid)
	{
		this.shoptypeid = shoptypeid != null ? shoptypeid : "";
	}

	/**
	 * 获取商家类型编号 ，只查询根节点 （parent_shop_type_id = “-1”的节点。）
	 * @return	商家类型编号 ，只查询根节点 （parent_shop_type_id = “-1”的节点。）
	 */
	public String getShoptypeid()
	{
		return this.shoptypeid;
	}

	/**
	 * 设置商家类型名称 
	 * @param shoptypename	商家类型名称 
	 */
	public void setShoptypename(String shoptypename)
	{
		this.shoptypename = shoptypename != null ? shoptypename : "";
	}

	/**
	 * 获取商家类型名称 
	 * @return	商家类型名称 
	 */
	public String getShoptypename()
	{
		return this.shoptypename;
	}

	/**
	 * 设置排序号 
	 * @param sortorder	排序号 
	 */
	public void setSortorder(String sortorder)
	{
		this.sortorder = sortorder != null ? sortorder : "";
	}

	/**
	 * 获取排序号 
	 * @return	排序号 
	 */
	public String getSortorder()
	{
		return this.sortorder;
	}

	/**
	 * 设置是否删除，Y-已删除，N-未删除 
	 * @param isdel	是否删除，Y-已删除，N-未删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除，Y-已删除，N-未删除 
	 * @return	是否删除，Y-已删除，N-未删除 
	 */
	public String getIsdel()
	{
		return this.isdel;
	}

	/**
	 * 设置最后一次修改时间 
	 * @param ctimestamp	最后一次修改时间 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取最后一次修改时间 
	 * @return	最后一次修改时间 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}