package com.gooagoo.gas.entity.gasj04.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 扫桌号获取点菜单
 */
public class GetMenuByDeskNoRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 结果编码，true成功，false失败 */
	private String result = null;

	/** 结果描述 */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 订单编号,订单编号对应order_info中的order_id */
	private String orderid = null;

	/** 定单图片URL */
	private String orderurl = null;

	/**  总额 即 合计  */
	private String totalpay = null;

	/**  菜品详情列表  */
	private java.util.List<Menulist> menulist = null;

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
	 * 设置订单编号,订单编号对应order_info中的order_id
	 * @param orderid	订单编号,订单编号对应order_info中的order_id
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取订单编号,订单编号对应order_info中的order_id
	 * @return	订单编号,订单编号对应order_info中的order_id
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置定单图片URL
	 * @param orderurl	定单图片URL
	 */
	public void setOrderurl(String orderurl)
	{
		this.orderurl = orderurl != null ? orderurl : "";
	}

	/**
	 * 获取定单图片URL
	 * @return	定单图片URL
	 */
	public String getOrderurl()
	{
		return this.orderurl;
	}

	/**
	 * 设置 总额 即 合计 
	 * @param totalpay	 总额 即 合计 
	 */
	public void setTotalpay(String totalpay)
	{
		this.totalpay = totalpay != null ? totalpay : "";
	}

	/**
	 * 获取 总额 即 合计 
	 * @return	 总额 即 合计 
	 */
	public String getTotalpay()
	{
		return this.totalpay;
	}

	/**
	 * 设置 菜品详情列表 
	 * @param menulist	 菜品详情列表 
	 */
	public void setMenulist(java.util.List<Menulist> menulist)
	{
		this.menulist = menulist;
	}

	/**
	 * 获取 菜品详情列表 
	 * @return	 菜品详情列表 
	 */
	public java.util.List<Menulist> getMenulist()
	{
		return this.menulist;
	}

	/**
	 * 添加 菜品详情列表 
	 * @return menulist	 菜品详情列表 
	 */
	public Menulist addMoreMenulist() {
		Menulist menulist = new Menulist();
		this.menulist.add(menulist);
		return menulist;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}