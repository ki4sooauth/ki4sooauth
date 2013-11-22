package com.gooagoo.mobile.entity.mobf06.transform;

import java.io.Serializable;

/**
 *  用户基本信息 
 */
public class Userinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 昵称  */
	private String nickname = "";

	/** 姓名  */
	private String realname = "";

	/** 性别  */
	private String sex = "";

	/** 生日  */
	private String birthday = "";

	/** 证件类型  */
	private String idtype = "";

	/** 证件号码  */
	private String idno = "";

	/** 手机号  */
	private String phone = "";

	/** 邮编  */
	private String postcode = "";

	/** 地址  */
	private String address = "";

	/** 是否允许别人加自己为好友，Y-否允，N-不否允  */
	private String isallowfriend = "";

	/**
	 * 设置昵称 
	 * @param nickname	昵称 
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname != null ? nickname : "";
	}

	/**
	 * 获取昵称 
	 * @return	昵称 
	 */
	public String getNickname()
	{
		return this.nickname;
	}

	/**
	 * 设置姓名 
	 * @param realname	姓名 
	 */
	public void setRealname(String realname)
	{
		this.realname = realname != null ? realname : "";
	}

	/**
	 * 获取姓名 
	 * @return	姓名 
	 */
	public String getRealname()
	{
		return this.realname;
	}

	/**
	 * 设置性别 
	 * @param sex	性别 
	 */
	public void setSex(String sex)
	{
		this.sex = sex != null ? sex : "";
	}

	/**
	 * 获取性别 
	 * @return	性别 
	 */
	public String getSex()
	{
		return this.sex;
	}

	/**
	 * 设置生日 
	 * @param birthday	生日 
	 */
	public void setBirthday(String birthday)
	{
		this.birthday = birthday != null ? birthday : "";
	}

	/**
	 * 获取生日 
	 * @return	生日 
	 */
	public String getBirthday()
	{
		return this.birthday;
	}

	/**
	 * 设置证件类型 
	 * @param idtype	证件类型 
	 */
	public void setIdtype(String idtype)
	{
		this.idtype = idtype != null ? idtype : "";
	}

	/**
	 * 获取证件类型 
	 * @return	证件类型 
	 */
	public String getIdtype()
	{
		return this.idtype;
	}

	/**
	 * 设置证件号码 
	 * @param idno	证件号码 
	 */
	public void setIdno(String idno)
	{
		this.idno = idno != null ? idno : "";
	}

	/**
	 * 获取证件号码 
	 * @return	证件号码 
	 */
	public String getIdno()
	{
		return this.idno;
	}

	/**
	 * 设置手机号 
	 * @param phone	手机号 
	 */
	public void setPhone(String phone)
	{
		this.phone = phone != null ? phone : "";
	}

	/**
	 * 获取手机号 
	 * @return	手机号 
	 */
	public String getPhone()
	{
		return this.phone;
	}

	/**
	 * 设置邮编 
	 * @param postcode	邮编 
	 */
	public void setPostcode(String postcode)
	{
		this.postcode = postcode != null ? postcode : "";
	}

	/**
	 * 获取邮编 
	 * @return	邮编 
	 */
	public String getPostcode()
	{
		return this.postcode;
	}

	/**
	 * 设置地址 
	 * @param address	地址 
	 */
	public void setAddress(String address)
	{
		this.address = address != null ? address : "";
	}

	/**
	 * 获取地址 
	 * @return	地址 
	 */
	public String getAddress()
	{
		return this.address;
	}

	/**
	 * 设置是否允许别人加自己为好友，Y-否允，N-不否允 
	 * @param isallowfriend	是否允许别人加自己为好友，Y-否允，N-不否允 
	 */
	public void setIsallowfriend(String isallowfriend)
	{
		this.isallowfriend = isallowfriend != null ? isallowfriend : "";
	}

	/**
	 * 获取是否允许别人加自己为好友，Y-否允，N-不否允 
	 * @return	是否允许别人加自己为好友，Y-否允，N-不否允 
	 */
	public String getIsallowfriend()
	{
		return this.isallowfriend;
	}
}