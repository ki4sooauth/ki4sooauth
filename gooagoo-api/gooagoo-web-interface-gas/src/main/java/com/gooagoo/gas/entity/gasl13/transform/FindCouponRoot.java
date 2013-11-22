package com.gooagoo.gas.entity.gasl13.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 查询优惠劵信息
 */
public class FindCouponRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true-提交成功，false-提交失败 */
	private String result = null;

	/** 查询结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/**  优惠劵信息  */
	private java.util.List<Voucherdetail> voucherdetail = null;

	/**
	 * 设置结果编码，true-提交成功，false-提交失败
	 * @param result	结果编码，true-提交成功，false-提交失败
	 */
	public void setResult(String result)
	{
		this.result = result != null ? result : "";
	}

	/**
	 * 获取结果编码，true-提交成功，false-提交失败
	 * @return	结果编码，true-提交成功，false-提交失败
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
	 * 设置 优惠劵信息 
	 * @param voucherdetail	 优惠劵信息 
	 */
	public void setVoucherdetail(java.util.List<Voucherdetail> voucherdetail)
	{
		this.voucherdetail = voucherdetail;
	}

	/**
	 * 获取 优惠劵信息 
	 * @return	 优惠劵信息 
	 */
	public java.util.List<Voucherdetail> getVoucherdetail()
	{
		return this.voucherdetail;
	}

	/**
	 * 添加 优惠劵信息 
	 * @return voucherdetail	 优惠劵信息 
	 */
	public Voucherdetail addMoreVoucherdetail() {
		Voucherdetail voucherdetail = new Voucherdetail();
		this.voucherdetail.add(voucherdetail);
		return voucherdetail;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}