package com.gooagoo.gas.entity.gasj06.transform;

import java.io.Serializable;

/**
 *  各类型餐桌排号记录 
 */
public class Deskqueuetrack implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 餐桌类型,如：1-2人桌  */
	private String deskkind = "";

	/** 当前餐桌类型等待排队的排队号码,以json形式保存,如["1","2"]  */
	private String queuenos = "";

	/**
	 * 设置餐桌类型,如：1-2人桌 
	 * @param deskkind	餐桌类型,如：1-2人桌 
	 */
	public void setDeskkind(String deskkind)
	{
		this.deskkind = deskkind != null ? deskkind : "";
	}

	/**
	 * 获取餐桌类型,如：1-2人桌 
	 * @return	餐桌类型,如：1-2人桌 
	 */
	public String getDeskkind()
	{
		return this.deskkind;
	}

	/**
	 * 设置当前餐桌类型等待排队的排队号码,以json形式保存,如["1","2"] 
	 * @param queuenos	当前餐桌类型等待排队的排队号码,以json形式保存,如["1","2"] 
	 */
	public void setQueuenos(String queuenos)
	{
		this.queuenos = queuenos != null ? queuenos : "";
	}

	/**
	 * 获取当前餐桌类型等待排队的排队号码,以json形式保存,如["1","2"] 
	 * @return	当前餐桌类型等待排队的排队号码,以json形式保存,如["1","2"] 
	 */
	public String getQueuenos()
	{
		return this.queuenos;
	}
}