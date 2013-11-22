package com.gooagoo.gas.entity.gasj06.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 获取排号记录
 */
public class DeskQueueTrackRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true获取排号记录成功，false获取排号记录失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  各类型餐桌排号记录  */
	private java.util.List<Deskqueuetrack> deskqueuetrack = null;

	/**
	 * 设置结果编码，true获取排号记录成功，false获取排号记录失败
	 * @param result	结果编码，true获取排号记录成功，false获取排号记录失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true获取排号记录成功，false获取排号记录失败
	 * @return	结果编码，true获取排号记录成功，false获取排号记录失败
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
	 * 设置 各类型餐桌排号记录 
	 * @param deskqueuetrack	 各类型餐桌排号记录 
	 */
	public void setDeskqueuetrack(java.util.List<Deskqueuetrack> deskqueuetrack)
	{
		this.deskqueuetrack = deskqueuetrack;
	}

	/**
	 * 获取 各类型餐桌排号记录 
	 * @return	 各类型餐桌排号记录 
	 */
	public java.util.List<Deskqueuetrack> getDeskqueuetrack()
	{
		return this.deskqueuetrack;
	}

	/**
	 * 添加 各类型餐桌排号记录 
	 * @return deskqueuetrack	 各类型餐桌排号记录 
	 */
	public Deskqueuetrack addMoreDeskqueuetrack() {
		Deskqueuetrack deskqueuetrack = new Deskqueuetrack();
		this.deskqueuetrack.add(deskqueuetrack);
		return deskqueuetrack;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}