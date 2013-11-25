package com.gooagoo.mobile.entity.mobe09.transform;

import java.io.Serializable;

import com.google.gson.Gson;

/**
 * 通过一维码获取商品信息
 */
public class GoodsInfoFromOnecodevalueRoot implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 查询结果编码，true-成功，false-失败  */
	private String result = null;

	/** 查询失败描述  */
	private String msg = null;

	/**  提示信息编号  */
	private String msgcode = null;

	/** 商品信息和评论   */
	private java.util.List<Goodscontaincomment> goodscontaincomment = null;

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
	 * 设置商品信息和评论  
	 * @param goodscontaincomment	商品信息和评论  
	 */
	public void setGoodscontaincomment(java.util.List<Goodscontaincomment> goodscontaincomment)
	{
		this.goodscontaincomment = goodscontaincomment;
	}

	/**
	 * 获取商品信息和评论  
	 * @return	商品信息和评论  
	 */
	public java.util.List<Goodscontaincomment> getGoodscontaincomment()
	{
		return this.goodscontaincomment;
	}

	/**
	 * 添加商品信息和评论  
	 * @return goodscontaincomment	商品信息和评论  
	 */
	public Goodscontaincomment addMoreGoodscontaincomment() {
		Goodscontaincomment goodscontaincomment = new Goodscontaincomment();
		this.goodscontaincomment.add(goodscontaincomment);
		return goodscontaincomment;
	}

	/**
	 * 转换成json
	 */
	public String toJson() {
		Gson json = new Gson();
		return json.toJson(this);
	}
}