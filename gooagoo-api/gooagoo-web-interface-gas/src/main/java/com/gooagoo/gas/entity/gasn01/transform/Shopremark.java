package com.gooagoo.gas.entity.gasn01.transform;

import java.io.Serializable;

/**
 *  返回商家备注信息 
 */
public class Shopremark implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  返回商家备注信息  */
	private String remark = "";

	/**
	 * 设置 返回商家备注信息 
	 * @param remark	 返回商家备注信息 
	 */
	public void setRemark(String remark)
	{
		this.remark = remark != null ? remark : "";
	}

	/**
	 * 获取 返回商家备注信息 
	 * @return	 返回商家备注信息 
	 */
	public String getRemark()
	{
		return this.remark;
	}
}