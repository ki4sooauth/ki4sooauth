package com.gooagoo.trans.entity.gtsc18.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 重量确认 
 */
public class WeightConfirmRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败  */
	private String result = null;

	/** 结果描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  重量确认信息  */
	private java.util.List<Weightconfirmlist> weightconfirmlist = null;

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
	 * 设置 重量确认信息 
	 * @param weightconfirmlist	 重量确认信息 
	 */
	public void setWeightconfirmlist(java.util.List<Weightconfirmlist> weightconfirmlist)
	{
		this.weightconfirmlist = weightconfirmlist;
	}

	/**
	 * 获取 重量确认信息 
	 * @return	 重量确认信息 
	 */
	public java.util.List<Weightconfirmlist> getWeightconfirmlist()
	{
		return this.weightconfirmlist;
	}

	/**
	 * 添加 重量确认信息 
	 * @return weightconfirmlist	 重量确认信息 
	 */
	public Weightconfirmlist addMoreWeightconfirmlist() {
		Weightconfirmlist weightconfirmlist = new Weightconfirmlist();
		this.weightconfirmlist.add(weightconfirmlist);
		return weightconfirmlist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}