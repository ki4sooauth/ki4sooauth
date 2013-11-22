package com.gooagoo.entity.business.shop.map;

import java.io.Serializable;

/**
 *  导航信息
 */
public class NavigationlistBusiness implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** svg导航信息  */
	private String svgstr = "";

	/**
	 * 设置svg导航信息 
	 * @param svgstr	svg导航信息 
	 */
	public void setSvgstr(String svgstr) {
		this.svgstr = svgstr;
	}

	/**
	 * 获取svg导航信息 
	 * @return	svg导航信息 
	 */
	public String getSvgstr() {
		return this.svgstr;
	}
}