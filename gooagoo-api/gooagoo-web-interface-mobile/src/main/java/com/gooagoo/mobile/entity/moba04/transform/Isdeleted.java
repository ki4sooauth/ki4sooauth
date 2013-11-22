package com.gooagoo.mobile.entity.moba04.transform;

import java.io.Serializable;

/**
 * 平台已删除的通知编号信息 
 */
public class Isdeleted implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** ，字符串，已删除通知的编号，多个用逗号分隔开  */
	private String noticeidstr = "";

	/** 返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N  */
	private String flag = "";

	/**  记录平台返回通知信息中 最大的时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置，字符串，已删除通知的编号，多个用逗号分隔开 
	 * @param noticeidstr	，字符串，已删除通知的编号，多个用逗号分隔开 
	 */
	public void setNoticeidstr(String noticeidstr)
	{
		this.noticeidstr = noticeidstr != null ? noticeidstr : "";
	}

	/**
	 * 获取，字符串，已删除通知的编号，多个用逗号分隔开 
	 * @return	，字符串，已删除通知的编号，多个用逗号分隔开 
	 */
	public String getNoticeidstr()
	{
		return this.noticeidstr;
	}

	/**
	 * 设置返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 * @param flag	返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 */
	public void setFlag(String flag)
	{
		this.flag = flag != null ? flag : "";
	}

	/**
	 * 获取返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 * @return	返回通知的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 */
	public String getFlag()
	{
		return this.flag;
	}

	/**
	 * 设置 记录平台返回通知信息中 最大的时间戳 
	 * @param ctimestamp	 记录平台返回通知信息中 最大的时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取 记录平台返回通知信息中 最大的时间戳 
	 * @return	 记录平台返回通知信息中 最大的时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}