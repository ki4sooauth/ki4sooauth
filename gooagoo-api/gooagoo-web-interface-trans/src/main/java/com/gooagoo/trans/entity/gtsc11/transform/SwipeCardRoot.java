package com.gooagoo.trans.entity.gtsc11.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 刷卡
 */
public class SwipeCardRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败  */
	private String result = null;

	/** 结果编码描述，0-平台API接口异常，1-请使用本店会员卡，2-该卡已经过期 ，3.该卡不存在 */
	private String code = null;

	/** 结果描述，平台API接口异常，非本店会员卡，该卡已经过期  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 会员卡音频编号 */
	private Cardinfo cardinfo = null;

	/**
	 * 设置结果编码，true成功，false失败 
	 * @param result	结果编码，true成功，false失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true成功，false失败 
	 * @return	结果编码，true成功，false失败 
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置结果编码描述，0-平台API接口异常，1-请使用本店会员卡，2-该卡已经过期 ，3.该卡不存在
	 * @param code	结果编码描述，0-平台API接口异常，1-请使用本店会员卡，2-该卡已经过期 ，3.该卡不存在
	 */
	public void setCode(String code)
	{
		this.code = code != null ? code : "";
	}

	/**
	 * 获取结果编码描述，0-平台API接口异常，1-请使用本店会员卡，2-该卡已经过期 ，3.该卡不存在
	 * @return	结果编码描述，0-平台API接口异常，1-请使用本店会员卡，2-该卡已经过期 ，3.该卡不存在
	 */
	public String getCode()
	{
		return this.code;
	}

	/**
	 * 设置结果描述，平台API接口异常，非本店会员卡，该卡已经过期 
	 * @param msg	结果描述，平台API接口异常，非本店会员卡，该卡已经过期 
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取结果描述，平台API接口异常，非本店会员卡，该卡已经过期 
	 * @return	结果描述，平台API接口异常，非本店会员卡，该卡已经过期 
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
	 * 设置会员卡音频编号
	 * @param cardinfo	会员卡音频编号
	 */
	public void setCardinfo(Cardinfo cardinfo)
	{
		this.cardinfo = cardinfo;
	}

	/**
	 * 获取会员卡音频编号
	 * @return	会员卡音频编号
	 */
	public Cardinfo getCardinfo()
	{
		return this.cardinfo;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}