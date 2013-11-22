package com.gooagoo.gas.entity.gasa01.transform;

import java.io.Serializable;

/**
 *  店员所属区域信息 
 */
public class Shopuserposition implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  实体店编号  */
	private String shopuserentityid = "";

	/**  实体店名称  */
	private String shopuserentityname = "";

	/**  区域编号  */
	private String positionid = "";

	/**
	 * 设置 实体店编号 
	 * @param shopuserentityid	 实体店编号 
	 */
	public void setShopuserentityid(String shopuserentityid)
	{
		this.shopuserentityid = shopuserentityid != null ? shopuserentityid : "";
	}

	/**
	 * 获取 实体店编号 
	 * @return	 实体店编号 
	 */
	public String getShopuserentityid()
	{
		return this.shopuserentityid;
	}

	/**
	 * 设置 实体店名称 
	 * @param shopuserentityname	 实体店名称 
	 */
	public void setShopuserentityname(String shopuserentityname)
	{
		this.shopuserentityname = shopuserentityname != null ? shopuserentityname : "";
	}

	/**
	 * 获取 实体店名称 
	 * @return	 实体店名称 
	 */
	public String getShopuserentityname()
	{
		return this.shopuserentityname;
	}

	/**
	 * 设置 区域编号 
	 * @param positionid	 区域编号 
	 */
	public void setPositionid(String positionid)
	{
		this.positionid = positionid != null ? positionid : "";
	}

	/**
	 * 获取 区域编号 
	 * @return	 区域编号 
	 */
	public String getPositionid()
	{
		return this.positionid;
	}
}