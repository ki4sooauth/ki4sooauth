package com.gooagoo.mobile.entity.mobd01.transform;

import java.io.Serializable;

/**
 *  购物计划 
 */
public class Usershoppingplansinglemob implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 购物清单编号，UUID  */
	private String shoppinglistid = "";

	/** 购物清单标题 (如果清单为手机新建，则此节点为空) */
	private String title = "";

	/** 预计购物时间  */
	private String preshoppingtime = "";

	/** 信息来源，参考通用字典表的infosource  */
	private String infosource = "";

	/** 是否删除，Y-已删除，N-未删除  */
	private String isdel = "";

	/** 创建时间  */
	private String createtime = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

	/**  商品列表  */
	private java.util.List<Shoppingplangoodssinglemob> shoppingplangoodssinglemob = new java.util.ArrayList<Shoppingplangoodssinglemob>();

	/**
	 * 设置购物清单编号，UUID 
	 * @param shoppinglistid	购物清单编号，UUID 
	 */
	public void setShoppinglistid(String shoppinglistid)
	{
		this.shoppinglistid = shoppinglistid != null ? shoppinglistid : "";
	}

	/**
	 * 获取购物清单编号，UUID 
	 * @return	购物清单编号，UUID 
	 */
	public String getShoppinglistid()
	{
		return this.shoppinglistid;
	}

	/**
	 * 设置购物清单标题 (如果清单为手机新建，则此节点为空)
	 * @param title	购物清单标题 (如果清单为手机新建，则此节点为空)
	 */
	public void setTitle(String title)
	{
		this.title = title != null ? title : "";
	}

	/**
	 * 获取购物清单标题 (如果清单为手机新建，则此节点为空)
	 * @return	购物清单标题 (如果清单为手机新建，则此节点为空)
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * 设置预计购物时间 
	 * @param preshoppingtime	预计购物时间 
	 */
	public void setPreshoppingtime(String preshoppingtime)
	{
		this.preshoppingtime = preshoppingtime != null ? preshoppingtime : "";
	}

	/**
	 * 获取预计购物时间 
	 * @return	预计购物时间 
	 */
	public String getPreshoppingtime()
	{
		return this.preshoppingtime;
	}

	/**
	 * 设置信息来源，参考通用字典表的infosource 
	 * @param infosource	信息来源，参考通用字典表的infosource 
	 */
	public void setInfosource(String infosource)
	{
		this.infosource = infosource != null ? infosource : "";
	}

	/**
	 * 获取信息来源，参考通用字典表的infosource 
	 * @return	信息来源，参考通用字典表的infosource 
	 */
	public String getInfosource()
	{
		return this.infosource;
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
	 * 设置创建时间 
	 * @param createtime	创建时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取创建时间 
	 * @return	创建时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
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

	/**
	 * 设置 商品列表 
	 * @param shoppingplangoodssinglemob	 商品列表 
	 */
	public void setShoppingplangoodssinglemob(java.util.List<Shoppingplangoodssinglemob> shoppingplangoodssinglemob)
	{
		this.shoppingplangoodssinglemob = shoppingplangoodssinglemob;
	}

	/**
	 * 获取 商品列表 
	 * @return	 商品列表 
	 */
	public java.util.List<Shoppingplangoodssinglemob> getShoppingplangoodssinglemob()
	{
		return this.shoppingplangoodssinglemob;
	}

	/**
	 * 添加 商品列表 
	 * @return shoppingplangoodssinglemob	 商品列表 
	 */
	public Shoppingplangoodssinglemob addMoreShoppingplangoodssinglemob() {
		Shoppingplangoodssinglemob shoppingplangoodssinglemob = new Shoppingplangoodssinglemob();
		this.shoppingplangoodssinglemob.add(shoppingplangoodssinglemob);
		return shoppingplangoodssinglemob;
	}
}