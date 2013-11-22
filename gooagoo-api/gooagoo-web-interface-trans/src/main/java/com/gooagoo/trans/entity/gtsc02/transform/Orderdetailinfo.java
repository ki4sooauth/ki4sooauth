package com.gooagoo.trans.entity.gtsc02.transform;

import java.io.Serializable;

/**
 *  订单详细信息 
 */
public class Orderdetailinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  详单单号  */
	private String billdetailid = "";

	/**  商品id  */
	private String goodsid = "";

	/**  商品图片地址  */
	private String goodsimg = "";

	/**  商品自定义序列号  */
	private String itemserial = "";

	/**  商品名称  */
	private String goodsname = "";

	/**  商品数量  */
	private String goodsnum = "";

	/**  商品单价  */
	private String payprice = "";

	/**   做法    */
	private String cookingmethods = "";

	/**   等叫标记    */
	private String waitcallmark = "";

	/**
	 * 设置 详单单号 
	 * @param billdetailid	 详单单号 
	 */
	public void setBilldetailid(String billdetailid)
	{
		this.billdetailid = billdetailid != null ? billdetailid : "";
	}

	/**
	 * 获取 详单单号 
	 * @return	 详单单号 
	 */
	public String getBilldetailid()
	{
		return this.billdetailid;
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
	 * 设置 商品自定义序列号 
	 * @param itemserial	 商品自定义序列号 
	 */
	public void setItemserial(String itemserial)
	{
		this.itemserial = itemserial != null ? itemserial : "";
	}

	/**
	 * 获取 商品自定义序列号 
	 * @return	 商品自定义序列号 
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
	 * @param payprice	 商品单价 
	 */
	public void setPayprice(String payprice)
	{
		this.payprice = payprice != null ? payprice : "";
	}

	/**
	 * 获取 商品单价 
	 * @return	 商品单价 
	 */
	public String getPayprice()
	{
		return this.payprice;
	}

	/**
	 * 设置  做法   
	 * @param cookingmethods	  做法   
	 */
	public void setCookingmethods(String cookingmethods)
	{
		this.cookingmethods = cookingmethods != null ? cookingmethods : "";
	}

	/**
	 * 获取  做法   
	 * @return	  做法   
	 */
	public String getCookingmethods()
	{
		return this.cookingmethods;
	}

	/**
	 * 设置  等叫标记   
	 * @param waitcallmark	  等叫标记   
	 */
	public void setWaitcallmark(String waitcallmark)
	{
		this.waitcallmark = waitcallmark != null ? waitcallmark : "";
	}

	/**
	 * 获取  等叫标记   
	 * @return	  等叫标记   
	 */
	public String getWaitcallmark()
	{
		return this.waitcallmark;
	}
}