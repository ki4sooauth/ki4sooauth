package com.gooagoo.gas.entity.gasl01.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 单一会员卡确认
 */
public class SingleMemberCardRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-查询成功，false-查询失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 会员卡卡号   */
	private String scardno = null;

	/** 会员卡名称   */
	private String cardname = null;

	/** 当前可用积分   */
	private String jifen = null;

	/** 上次到店时间   */
	private String lasttime = null;

	/**
	 * 设置查询结果编码，true-查询成功，false-查询失败
	 * @param result	查询结果编码，true-查询成功，false-查询失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取查询结果编码，true-查询成功，false-查询失败
	 * @return	查询结果编码，true-查询成功，false-查询失败
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置查询结果描述
	 * @param msg	查询结果描述
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取查询结果描述
	 * @return	查询结果描述
	 */
	public String getMsg()
	{
		return this.msg;
	}

	/**
	 * 设置 提示信息编号 
	 * @param msgcode	 提示信息编号 
	 */
	public void setMsgcode(String msgcode)
	{
		this.msgcode = msgcode != null ? msgcode : "";
	}

	/**
	 * 获取 提示信息编号 
	 * @return	 提示信息编号 
	 */
	public String getMsgcode()
	{
		return this.msgcode;
	}

	/**
	 * 设置会员卡卡号  
	 * @param scardno	会员卡卡号  
	 */
	public void setScardno(String scardno)
	{
		this.scardno = scardno != null ? scardno : "";
	}

	/**
	 * 获取会员卡卡号  
	 * @return	会员卡卡号  
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
	 * 设置当前可用积分  
	 * @param jifen	当前可用积分  
	 */
	public void setJifen(String jifen)
	{
		this.jifen = jifen != null ? jifen : "";
	}

	/**
	 * 获取当前可用积分  
	 * @return	当前可用积分  
	 */
	public String getJifen()
	{
		return this.jifen;
	}

	/**
	 * 设置上次到店时间  
	 * @param lasttime	上次到店时间  
	 */
	public void setLasttime(String lasttime)
	{
		this.lasttime = lasttime != null ? lasttime : "";
	}

	/**
	 * 获取上次到店时间  
	 * @return	上次到店时间  
	 */
	public String getLasttime()
	{
		return this.lasttime;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}