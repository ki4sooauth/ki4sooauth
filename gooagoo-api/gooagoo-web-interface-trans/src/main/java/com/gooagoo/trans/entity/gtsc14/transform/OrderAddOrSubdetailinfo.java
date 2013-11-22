package com.gooagoo.trans.entity.gtsc14.transform;

import java.io.Serializable;

/**
 *  订单详细信息 
 */
public class OrderAddOrSubdetailinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 订单编号  */
	private String orderid = "";

	/**  订单明细编号 */
	private String orderdetailid = "";

	/**  类型，0-加菜，1-减菜  */
	private String typedeal = "";

	/**  商品id  */
	private String goodsid = "";

	/**  商品图片地址  */
	private String goodsimg = "";

	/**  商品条形码(自定义序列号)  */
	private String itemserial = "";

	/**  商品名称  */
	private String goodsname = "";

	/**  商品数量  */
	private String goodsnum = "";

	/**  商品单价  */
	private String goodsprice = "";

	/**  做法  */
	private String cookingmethods = "";

	/**  等叫标记（从缓存中获取）  */
	private String waitcallmark = "";

	/**  申请时间  */
	private String createtime = "";

	/**
	 * 设置订单编号 
	 * @param orderid	订单编号 
	 */
	public void setOrderid(String orderid)
	{
		this.orderid = orderid != null ? orderid : "";
	}

	/**
	 * 获取订单编号 
	 * @return	订单编号 
	 */
	public String getOrderid()
	{
		return this.orderid;
	}

	/**
	 * 设置 订单明细编号
	 * @param orderdetailid	 订单明细编号
	 */
	public void setOrderdetailid(String orderdetailid)
	{
		this.orderdetailid = orderdetailid != null ? orderdetailid : "";
	}

	/**
	 * 获取 订单明细编号
	 * @return	 订单明细编号
	 */
	public String getOrderdetailid()
	{
		return this.orderdetailid;
	}

	/**
	 * 设置 类型，0-加菜，1-减菜 
	 * @param typedeal	 类型，0-加菜，1-减菜 
	 */
	public void setTypedeal(String typedeal)
	{
		this.typedeal = typedeal != null ? typedeal : "";
	}

	/**
	 * 获取 类型，0-加菜，1-减菜 
	 * @return	 类型，0-加菜，1-减菜 
	 */
	public String getTypedeal()
	{
		return this.typedeal;
	}

	/**
	 * 设置 商品id 
	 * @param goodsid	 商品id 
	 */
	public void setGoodsid(String goodsid)
	{
		this.goodsid = goodsid != null ? goodsid : "";
	}

	/**
	 * 获取 商品id 
	 * @return	 商品id 
	 */
	public String getGoodsid()
	{
		return this.goodsid;
	}

	/**
	 * 设置 商品图片地址 
	 * @param goodsimg	 商品图片地址 
	 */
	public void setGoodsimg(String goodsimg)
	{
		this.goodsimg = goodsimg != null ? goodsimg : "";
	}

	/**
	 * 获取 商品图片地址 
	 * @return	 商品图片地址 
	 */
	public String getGoodsimg()
	{
		return this.goodsimg;
	}

	/**
	 * 设置 商品条形码(自定义序列号) 
	 * @param itemserial	 商品条形码(自定义序列号) 
	 */
	public void setItemserial(String itemserial)
	{
		this.itemserial = itemserial != null ? itemserial : "";
	}

	/**
	 * 获取 商品条形码(自定义序列号) 
	 * @return	 商品条形码(自定义序列号) 
	 */
	public String getItemserial()
	{
		return this.itemserial;
	}

	/**
	 * 设置 商品名称 
	 * @param goodsname	 商品名称 
	 */
	public void setGoodsname(String goodsname)
	{
		this.goodsname = goodsname != null ? goodsname : "";
	}

	/**
	 * 获取 商品名称 
	 * @return	 商品名称 
	 */
	public String getGoodsname()
	{
		return this.goodsname;
	}

	/**
	 * 设置 商品数量 
	 * @param goodsnum	 商品数量 
	 */
	public void setGoodsnum(String goodsnum)
	{
		this.goodsnum = goodsnum != null ? goodsnum : "";
	}

	/**
	 * 获取 商品数量 
	 * @return	 商品数量 
	 */
	public String getGoodsnum()
	{
		return this.goodsnum;
	}

	/**
	 * 设置 商品单价 
	 * @param goodsprice	 商品单价 
	 */
	public void setGoodsprice(String goodsprice)
	{
		this.goodsprice = goodsprice != null ? goodsprice : "";
	}

	/**
	 * 获取 商品单价 
	 * @return	 商品单价 
	 */
	public String getGoodsprice()
	{
		return this.goodsprice;
	}

	/**
	 * 设置 做法 
	 * @param cookingmethods	 做法 
	 */
	public void setCookingmethods(String cookingmethods)
	{
		this.cookingmethods = cookingmethods != null ? cookingmethods : "";
	}

	/**
	 * 获取 做法 
	 * @return	 做法 
	 */
	public String getCookingmethods()
	{
		return this.cookingmethods;
	}

	/**
	 * 设置 等叫标记（从缓存中获取） 
	 * @param waitcallmark	 等叫标记（从缓存中获取） 
	 */
	public void setWaitcallmark(String waitcallmark)
	{
		this.waitcallmark = waitcallmark != null ? waitcallmark : "";
	}

	/**
	 * 获取 等叫标记（从缓存中获取） 
	 * @return	 等叫标记（从缓存中获取） 
	 */
	public String getWaitcallmark()
	{
		return this.waitcallmark;
	}

	/**
	 * 设置 申请时间 
	 * @param createtime	 申请时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取 申请时间 
	 * @return	 申请时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}
}