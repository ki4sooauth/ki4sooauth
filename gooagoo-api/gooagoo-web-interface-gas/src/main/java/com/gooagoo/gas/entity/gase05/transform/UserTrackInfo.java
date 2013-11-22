package com.gooagoo.gas.entity.gase05.transform;

import java.io.Serializable;

/**
 * 店内踪迹信息
 */
public class UserTrackInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 停留次数 */
	private String trackCount = "";

	/** 主区域名称 */
	private String storeArea = "";

	/**
	 * 设置停留次数
	 * @param trackCount	停留次数
	 */
	public void setTrackCount(String trackCount)
	{
		this.trackCount = trackCount != null ? trackCount : "";
	}

	/**
	 * 获取停留次数
	 * @return	停留次数
	 */
	public String getTrackCount()
	{
		return this.trackCount;
	}

	/**
	 * 设置主区域名称
	 * @param storeArea	主区域名称
	 */
	public void setStoreArea(String storeArea)
	{
		this.storeArea = storeArea != null ? storeArea : "";
	}

	/**
	 * 获取主区域名称
	 * @return	主区域名称
	 */
	public String getStoreArea()
	{
		return this.storeArea;
	}
}