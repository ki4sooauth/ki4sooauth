package com.gooagoo.mobile.entity.mobk02.transform;

import java.io.Serializable;

/**
 *  消费日
 */
public class Daylist implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 若订单、账单、购物清单存在其一则返回时间:日(dd)，多天 */
	private String day = "";

	/**
	 * 设置若订单、账单、购物清单存在其一则返回时间:日(dd)，多天
	 * @param day	若订单、账单、购物清单存在其一则返回时间:日(dd)，多天
	 */
	public void setDay(String day)
	{
		this.day = day != null ? day : "";
	}

	/**
	 * 获取若订单、账单、购物清单存在其一则返回时间:日(dd)，多天
	 * @return	若订单、账单、购物清单存在其一则返回时间:日(dd)，多天
	 */
	public String getDay()
	{
		return this.day;
	}
}