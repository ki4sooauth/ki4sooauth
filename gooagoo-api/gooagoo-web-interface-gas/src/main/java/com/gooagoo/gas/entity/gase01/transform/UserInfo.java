package com.gooagoo.gas.entity.gase01.transform;

import java.io.Serializable;

/**
 * 店里所有会员列表信息
 */
public class UserInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 会员编号 */
	private String userId = "";

	/** 会员卡音频编号 member_of_card.scardno */
	private String scardno = "";

	/** 会员卡名称   */
	private String cardname = "";

	/** 性别，member_base_info.sex,返回如：男，如果该字段没有值则显示为“”  */
	private String sex = "";

	/** 年龄 */
	private String age = "";

	/** 会员真实姓名，member_base_info.name */
	private String realname = "";

	/** 手机号码 member_base_info.phone,如果没有则显示"" */
	private String phone = "";

	/**
	 * 设置会员编号
	 * @param userId	会员编号
	 */
	public void setUserId(String userId)
	{
		this.userId = userId != null ? userId : "";
	}

	/**
	 * 获取会员编号
	 * @return	会员编号
	 */
	public String getUserId()
	{
		return this.userId;
	}

	/**
	 * 设置会员卡音频编号 member_of_card.scardno
	 * @param scardno	会员卡音频编号 member_of_card.scardno
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取会员卡音频编号 member_of_card.scardno
	 * @return	会员卡音频编号 member_of_card.scardno
	 */
	public String getScardno()
	{
		return this.scardno;
	}

	/**
	 * 设置会员卡名称  
	 * @param cardname	会员卡名称  
	 */
	public void setCardname(String cardname)
	{
		this.cardname = cardname != null ? cardname : "";
	}

	/**
	 * 获取会员卡名称  
	 * @return	会员卡名称  
	 */
	public String getCardname()
	{
		return this.cardname;
	}

	/**
	 * 设置性别，member_base_info.sex,返回如：男，如果该字段没有值则显示为“” 
	 * @param sex	性别，member_base_info.sex,返回如：男，如果该字段没有值则显示为“” 
	 */
	public void setSex(String sex)
	{
		this.sex = sex != null ? sex : "";
	}

	/**
	 * 获取性别，member_base_info.sex,返回如：男，如果该字段没有值则显示为“” 
	 * @return	性别，member_base_info.sex,返回如：男，如果该字段没有值则显示为“” 
	 */
	public String getSex()
	{
		return this.sex;
	}

	/**
	 * 设置年龄
	 * @param age	年龄
	 */
	public void setAge(String age)
	{
		this.age = age != null ? age : "";
	}

	/**
	 * 获取年龄
	 * @return	年龄
	 */
	public String getAge()
	{
		return this.age;
	}

	/**
	 * 设置会员真实姓名，member_base_info.name
	 * @param realname	会员真实姓名，member_base_info.name
	 */
	public void setRealname(String realname)
	{
		this.realname = realname != null ? realname : "";
	}

	/**
	 * 获取会员真实姓名，member_base_info.name
	 * @return	会员真实姓名，member_base_info.name
	 */
	public String getRealname()
	{
		return this.realname;
	}

	/**
	 * 设置手机号码 member_base_info.phone,如果没有则显示""
	 * @param phone	手机号码 member_base_info.phone,如果没有则显示""
	 */
	public void setPhone(String phone)
	{
		this.phone = phone != null ? phone : "";
	}

	/**
	 * 获取手机号码 member_base_info.phone,如果没有则显示""
	 * @return	手机号码 member_base_info.phone,如果没有则显示""
	 */
	public String getPhone()
	{
		return this.phone;
	}
}