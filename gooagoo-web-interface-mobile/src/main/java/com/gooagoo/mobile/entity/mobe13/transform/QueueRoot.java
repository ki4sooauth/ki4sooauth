package com.gooagoo.mobile.entity.mobe13.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 *  用餐排号  
 */
public class QueueRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 排队号码 */
	private String queueno = null;

	/** 当前叫到排队号码  */
	private String currentqueueno = null;

	/** 排队等候号数  */
	private String waitnum = null;

	/** 正在结帐数 */
	private String checkoutnum = null;

	/** 排号时间 */
	private String createtime = null;

	/**
	 * 设置查询结果编码，true-成功，false-失败 
	 * @param result	查询结果编码，true-成功，false-失败 
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取查询结果编码，true-成功，false-失败 
	 * @return	查询结果编码，true-成功，false-失败 
	 */
	public String getResult()
	{
		return this.result;
	}

	/**
	 * 设置查询失败描述 
	 * @param msg	查询失败描述 
	 */
	public void setMsg(String msg)
	{
		this.msg = msg != null ? msg : "";
	}

	/**
	 * 获取查询失败描述 
	 * @return	查询失败描述 
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

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}