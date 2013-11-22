package com.gooagoo.gas.entity.gasc02.transform;

import java.io.Serializable;

/**
 * 产品特征
 */
public class Goodsdetailextend implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 特征编码 */
	private String featurecode = "";

	/** 特征名称 */
	private String featurename = "";

	/** 特征数值 */
	private String featurevalue = "";

	/**
	 * 设置特征编码
	 * @param featurecode	特征编码
	 */
	public void setFeaturecode(String featurecode)
	{
		this.featurecode = featurecode != null ? featurecode : "";
	}

	/**
	 * 获取特征编码
	 * @return	特征编码
	 */
	public String getFeaturecode()
	{
		return this.featurecode;
	}

	/**
	 * 设置特征名称
	 * @param featurename	特征名称
	 */
	public void setFeaturename(String featurename)
	{
		this.featurename = featurename != null ? featurename : "";
	}

	/**
	 * 获取特征名称
	 * @return	特征名称
	 */
	public String getFeaturename()
	{
		return this.featurename;
	}

	/**
	 * 设置特征数值
	 * @param featurevalue	特征数值
	 */
	public void setFeaturevalue(String featurevalue)
	{
		this.featurevalue = featurevalue != null ? featurevalue : "";
	}

	/**
	 * 获取特征数值
	 * @return	特征数值
	 */
	public String getFeaturevalue()
	{
		return this.featurevalue;
	}
}