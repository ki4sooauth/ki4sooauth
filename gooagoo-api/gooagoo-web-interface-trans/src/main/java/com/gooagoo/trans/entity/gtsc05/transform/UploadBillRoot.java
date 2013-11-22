package com.gooagoo.trans.entity.gtsc05.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 商家账单数据上传
 */
public class UploadBillRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true上传账单成功，false上传账单失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**
	 * 设置结果编码，true上传账单成功，false上传账单失败
	 * @param result	结果编码，true上传账单成功，false上传账单失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true上传账单成功，false上传账单失败
	 * @return	结果编码，true上传账单成功，false上传账单失败
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置结果描述
	 * @param msg	结果描述
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取结果描述
	 * @return	结果描述
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
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}