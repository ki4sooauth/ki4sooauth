package com.gooagoo.gas.entity.gasc03.transform;

import java.io.Serializable;

/**
 * 会员信息
 */
public class Userbaseinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 用户id member_of_card.user_id  */
	private String userid = "";

	/** 真实姓名,member_base_info.name  */
	private String realname = "";

	/** 会员卡名称,member_card.card_name  */
	private String cardname = "";

	/** 会员卡音频编号 member_of_card.scardno  */
	private String scardno = "";

	/** 可用积分 integral_info.useable_integral_number  */
	private String useableintegralnumber = "";

	/**
	 * 设置用户id member_of_card.user_id 
	 * @param userid	用户id member_of_card.user_id 
	 */
	public void setUserid(String userid)
	{
		this.userid = userid != null ? userid : "";
	}

	/**
	 * 获取用户id member_of_card.user_id 
	 * @return	用户id member_of_card.user_id 
	 */
	public String getUserid()
	{
		return this.userid;
	}

	/**
	 * 设置真实姓名,member_base_info.name 
	 * @param realname	真实姓名,member_base_info.name 
	 */
	public void setRealname(String realname)
	{
		this.realname = realname != null ? realname : "";
	}

	/**
	 * 获取真实姓名,member_base_info.name 
	 * @return	真实姓名,member_base_info.name 
	 */
	public String getRealname()
	{
		return this.realname;
	}

	/**
	 * 设置会员卡名称,member_card.card_name 
	 * @param cardname	会员卡名称,member_card.card_name 
	 */
	public void setCardname(String cardname)
	{
		this.cardname = cardname != null ? cardname : "";
	}

	/**
	 * 获取会员卡名称,member_card.card_name 
	 * @return	会员卡名称,member_card.card_name 
	 */
	public String getCardname()
	{
		return this.cardname;
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
	 * 设置可用积分 integral_info.useable_integral_number 
	 * @param useableintegralnumber	可用积分 integral_info.useable_integral_number 
	 */
	public void setUseableintegralnumber(String useableintegralnumber)
	{
		this.useableintegralnumber = useableintegralnumber != null ? useableintegralnumber : "";
	}

	/**
	 * 获取可用积分 integral_info.useable_integral_number 
	 * @return	可用积分 integral_info.useable_integral_number 
	 */
	public String getUseableintegralnumber()
	{
		return this.useableintegralnumber;
	}
}