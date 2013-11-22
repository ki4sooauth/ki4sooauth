package com.gooagoo.mobile.entity.mobf01.transform;

import java.io.Serializable;

/**
 *  用户 
 */
public class Login implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 用户id  */
	private String userid = "";

	/** session  */
	private String sessionid = "";

	/** 无卡获账单用的会员号声音文件  */
	private String scardno = "";

	/**
	 * 设置用户id 
	 * @param userid	用户id 
	 */
	public void setUserid(String userid)
	{
		this.userid = userid != null ? userid : "";
	}

	/**
	 * 获取用户id 
	 * @return	用户id 
	 */
	public String getUserid()
	{
		return this.userid;
	}

	/**
	 * 设置session 
	 * @param sessionid	session 
	 */
	public void setSessionid(String sessionid)
	{
		this.sessionid = sessionid != null ? sessionid : "";
	}

	/**
	 * 获取session 
	 * @return	session 
	 */
	public String getSessionid()
	{
		return this.sessionid;
	}

	/**
	 * 设置无卡获账单用的会员号声音文件 
	 * @param scardno	无卡获账单用的会员号声音文件 
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取无卡获账单用的会员号声音文件 
	 * @return	无卡获账单用的会员号声音文件 
	 */
	public String getScardno()
	{
		return this.scardno;
	}
}