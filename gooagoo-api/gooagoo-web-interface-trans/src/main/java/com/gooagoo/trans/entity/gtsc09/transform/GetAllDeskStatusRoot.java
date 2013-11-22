package com.gooagoo.trans.entity.gtsc09.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 获取所用餐桌状态
 */
public class GetAllDeskStatusRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  餐桌状态列表  */
	private java.util.List<DeskStatusList> deskStatusList = null;

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
	 * 设置 餐桌状态列表 
	 * @param deskStatusList	 餐桌状态列表 
	 */
	public void setDeskStatusList(java.util.List<DeskStatusList> deskStatusList)
	{
		this.deskStatusList = deskStatusList;
	}

	/**
	 * 获取 餐桌状态列表 
	 * @return	 餐桌状态列表 
	 */
	public java.util.List<DeskStatusList> getDeskStatusList()
	{
		return this.deskStatusList;
	}

	/**
	 * 添加 餐桌状态列表 
	 * @return deskStatusList	 餐桌状态列表 
	 */
	public DeskStatusList addMoreDeskStatusList() {
		DeskStatusList deskStatusList = new DeskStatusList();
		this.deskStatusList.add(deskStatusList);
		return deskStatusList;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}