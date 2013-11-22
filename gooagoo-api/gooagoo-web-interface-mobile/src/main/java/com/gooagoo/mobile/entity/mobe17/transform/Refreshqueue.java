package com.gooagoo.mobile.entity.mobe17.transform;

import java.io.Serializable;

/**
 *  刷新排号 
 */
public class Refreshqueue implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  商家编号  */
	private String shopid = "";

	/**  实体店编号  */
	private String shopentityid = "";

	/** 排队号码 */
	private String queueno = "";

	/** 当前叫到排队号码  */
	private String currentqueueno = "";

	/** 排队等候号数  */
	private String waitnum = "";

	/** 正在结帐数 */
	private String checkoutnum = "";

	/** 排号时间 */
	private String createtime = "";

	/**
	 * 设置 商家编号 
	 * @param shopid	 商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取 商家编号 
	 * @return	 商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置 实体店编号 
	 * @param shopentityid	 实体店编号 
	 */
	public void setShopentityid(String shopentityid)
	{
		this.shopentityid = shopentityid != null ? shopentityid : "";
	}

	/**
	 * 获取 实体店编号 
	 * @return	 实体店编号 
	 */
	public String getShopentityid()
	{
		return this.shopentityid;
	}

	/**
	 * 设置排队号码
	 * @param queueno	排队号码
	 */
	public void setQueueno(String queueno)
	{
		this.queueno = queueno != null ? queueno : "";
	}

	/**
	 * 获取排队号码
	 * @return	排队号码
	 */
	public String getQueueno()
	{
		return this.queueno;
	}

	/**
	 * 设置当前叫到排队号码 
	 * @param currentqueueno	当前叫到排队号码 
	 */
	public void setCurrentqueueno(String currentqueueno)
	{
		this.currentqueueno = currentqueueno != null ? currentqueueno : "";
	}

	/**
	 * 获取当前叫到排队号码 
	 * @return	当前叫到排队号码 
	 */
	public String getCurrentqueueno()
	{
		return this.currentqueueno;
	}

	/**
	 * 设置排队等候号数 
	 * @param waitnum	排队等候号数 
	 */
	public void setWaitnum(String waitnum)
	{
		this.waitnum = waitnum != null ? waitnum : "";
	}

	/**
	 * 获取排队等候号数 
	 * @return	排队等候号数 
	 */
	public String getWaitnum()
	{
		return this.waitnum;
	}

	/**
	 * 设置正在结帐数
	 * @param checkoutnum	正在结帐数
	 */
	public void setCheckoutnum(String checkoutnum)
	{
		this.checkoutnum = checkoutnum != null ? checkoutnum : "";
	}

	/**
	 * 获取正在结帐数
	 * @return	正在结帐数
	 */
	public String getCheckoutnum()
	{
		return this.checkoutnum;
	}

	/**
	 * 设置排号时间
	 * @param createtime	排号时间
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取排号时间
	 * @return	排号时间
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}
}