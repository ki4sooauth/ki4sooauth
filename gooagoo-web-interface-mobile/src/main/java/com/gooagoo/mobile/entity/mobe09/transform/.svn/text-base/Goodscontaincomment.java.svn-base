package com.gooagoo.mobile.entity.mobe09.transform;

import java.io.Serializable;

/**
 * 商品信息和评论  
 */
public class Goodscontaincomment implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 商品信息  */
	private Onedimensioncode onedimensioncode = new Onedimensioncode();

	/** 商品评论，目前取3條  */
	private java.util.List<Usercomment> usercomment = new java.util.ArrayList<Usercomment>();

	/**
	 * 设置商品信息 
	 * @param onedimensioncode	商品信息 
	 */
	public void setOnedimensioncode(Onedimensioncode onedimensioncode)
	{
		this.onedimensioncode = onedimensioncode;
	}

	/**
	 * 获取商品信息 
	 * @return	商品信息 
	 */
	public Onedimensioncode getOnedimensioncode()
	{
		return this.onedimensioncode;
	}

	/**
	 * 设置商品评论，目前取3條 
	 * @param usercomment	商品评论，目前取3條 
	 */
	public void setUsercomment(java.util.List<Usercomment> usercomment)
	{
		this.usercomment = usercomment;
	}

	/**
	 * 获取商品评论，目前取3條 
	 * @return	商品评论，目前取3條 
	 */
	public java.util.List<Usercomment> getUsercomment()
	{
		return this.usercomment;
	}

	/**
	 * 添加商品评论，目前取3條 
	 * @return usercomment	商品评论，目前取3條 
	 */
	public Usercomment addMoreUsercomment() {
		Usercomment usercomment = new Usercomment();
		this.usercomment.add(usercomment);
		return usercomment;
	}
}