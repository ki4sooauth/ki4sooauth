package com.gooagoo.gas.entity.gasf01.transform;

import java.io.Serializable;

/**
 * 位置信息
 */
public class PositionInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 位置编号，唯一，通过UUID产生 */
	private String positionId = "";

	/** 位置名称 */
	private String positionName = "";

	/** 商家编号 */
	private String shopId = "";

	/** 实体店编号 */
	private String shopEntityId = "";

	/** 父位置编号 */
	private String parentPositionId = "";

	/** 父级名称 */
	private String parentPositionName = "";

	/** 位置描述 */
	private String description = "";

	/** 是否删除 */
	private String isDel = "";

	/** 创建时间 */
	private String createTime = "";

	/** 最后一次修改时间 */
	private String cTimeStamp = "";

	/**
	 * 设置位置编号，唯一，通过UUID产生
	 * @param positionId	位置编号，唯一，通过UUID产生
	 */
	public void setPositionId(String positionId)
	{
		this.positionId = positionId != null ? positionId : "";
	}

	/**
	 * 获取位置编号，唯一，通过UUID产生
	 * @return	位置编号，唯一，通过UUID产生
	 */
	public String getPositionId()
	{
		return this.positionId;
	}

	/**
	 * 设置位置名称
	 * @param positionName	位置名称
	 */
	public void setPositionName(String positionName)
	{
		this.positionName = positionName != null ? positionName : "";
	}

	/**
	 * 获取位置名称
	 * @return	位置名称
	 */
	public String getPositionName()
	{
		return this.positionName;
	}

	/**
	 * 设置商家编号
	 * @param shopId	商家编号
	 */
	public void setShopId(String shopId)
	{
		this.shopId = shopId != null ? shopId : "";
	}

	/**
	 * 获取商家编号
	 * @return	商家编号
	 */
	public String getShopId()
	{
		return this.shopId;
	}

	/**
	 * 设置实体店编号
	 * @param shopEntityId	实体店编号
	 */
	public void setShopEntityId(String shopEntityId)
	{
		this.shopEntityId = shopEntityId != null ? shopEntityId : "";
	}

	/**
	 * 获取实体店编号
	 * @return	实体店编号
	 */
	public String getShopEntityId()
	{
		return this.shopEntityId;
	}

	/**
	 * 设置父位置编号
	 * @param parentPositionId	父位置编号
	 */
	public void setParentPositionId(String parentPositionId)
	{
		this.parentPositionId = parentPositionId != null ? parentPositionId : "";
	}

	/**
	 * 获取父位置编号
	 * @return	父位置编号
	 */
	public String getParentPositionId()
	{
		return this.parentPositionId;
	}

	/**
	 * 设置父级名称
	 * @param parentPositionName	父级名称
	 */
	public void setParentPositionName(String parentPositionName)
	{
		this.parentPositionName = parentPositionName != null ? parentPositionName : "";
	}

	/**
	 * 获取父级名称
	 * @return	父级名称
	 */
	public String getParentPositionName()
	{
		return this.parentPositionName;
	}

	/**
	 * 设置位置描述
	 * @param description	位置描述
	 */
	public void setDescription(String description)
	{
		this.description = description != null ? description : "";
	}

	/**
	 * 获取位置描述
	 * @return	位置描述
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * 设置是否删除
	 * @param isDel	是否删除
	 */
	public void setIsDel(String isDel)
	{
		this.isDel = isDel != null ? isDel : "";
	}

	/**
	 * 获取是否删除
	 * @return	是否删除
	 */
	public String getIsDel()
	{
		return this.isDel;
	}

	/**
	 * 设置创建时间
	 * @param createTime	创建时间
	 */
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime != null ? createTime : "";
	}

	/**
	 * 获取创建时间
	 * @return	创建时间
	 */
	public String getCreateTime()
	{
		return this.createTime;
	}

	/**
	 * 设置最后一次修改时间
	 * @param cTimeStamp	最后一次修改时间
	 */
	public void setCTimeStamp(String cTimeStamp)
	{
		this.cTimeStamp = cTimeStamp != null ? cTimeStamp : "";
	}

	/**
	 * 获取最后一次修改时间
	 * @return	最后一次修改时间
	 */
	public String getCTimeStamp()
	{
		return this.cTimeStamp;
	}
}