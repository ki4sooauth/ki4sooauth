package com.gooagoo.mobile.entity.mobc01.transform;

import java.io.Serializable;

/**
 * 平台已删除的吆喝吆喝编号信息 
 */
public class Isdeleted implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** ，字符串，已删除吆喝的编号，多个用逗号分隔开  */
	private String cryoutidstr = "";

	/** 返回吆喝信息的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N  */
	private String flag = "";

	/**  记录平台返回吆喝信息中 最大的时间戳  */
	private String ctimestamp = "";

	/**
	 * 设置，字符串，已删除吆喝的编号，多个用逗号分隔开 
	 * @param cryoutidstr	，字符串，已删除吆喝的编号，多个用逗号分隔开 
	 */
	public void setCryoutidstr(String cryoutidstr)
	{
		this.cryoutidstr = cryoutidstr != null ? cryoutidstr : "";
	}

	/**
	 * 获取，字符串，已删除吆喝的编号，多个用逗号分隔开 
	 * @return	，字符串，已删除吆喝的编号，多个用逗号分隔开 
	 */
	public String getCryoutidstr()
	{
		return this.cryoutidstr;
	}

	/**
	 * 设置返回吆喝信息的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 * @param flag	返回吆喝信息的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 */
	public void setFlag(String flag)
	{
		this.flag = flag != null ? flag : "";
	}

	/**
	 * 获取返回吆喝信息的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 * @return	返回吆喝信息的总条数是否大于每页信息显示条数，若大于flag=Y，反之Flag=N 
	 */
	public String getFlag()
	{
		return this.flag;
	}

	/**
	 * 设置 记录平台返回吆喝信息中 最大的时间戳 
	 * @param ctimestamp	 记录平台返回吆喝信息中 最大的时间戳 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取 记录平台返回吆喝信息中 最大的时间戳 
	 * @return	 记录平台返回吆喝信息中 最大的时间戳 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}