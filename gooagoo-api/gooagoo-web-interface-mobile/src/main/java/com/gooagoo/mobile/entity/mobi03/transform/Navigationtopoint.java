package com.gooagoo.mobile.entity.mobi03.transform;

import java.io.Serializable;

/**
 *  导航信息
 */
public class Navigationtopoint implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** svg导航信息  */
	private String svgstr = "";

	/**
	 * 设置svg导航信息 
	 * @param svgstr	svg导航信息 
	 */
	public void setSvgstr(String svgstr)
	{
		this.svgstr = svgstr != null ? svgstr : "";
	}

	/**
	 * 获取svg导航信息 
	 * @return	svg导航信息 
	 */
	public String getSvgstr()
	{
		return this.svgstr;
	}
}