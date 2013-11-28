package com.gooagoo.mobile.entity.mobc05.transform;

import java.io.Serializable;

/**
 * 信息 
 */
public class Boutiquerecommend implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 信息的类型：活动、商品、优惠劵  */
	private String noticetype = "";

	/** 信息的图片  */
	private String noticeimage = "";

	/**
	 * 设置信息的类型：活动、商品、优惠劵 
	 * @param noticetype	信息的类型：活动、商品、优惠劵 
	 */
	public void setNoticetype(String noticetype)
	{
		this.noticetype = noticetype != null ? noticetype : "";
	}

	/**
	 * 获取信息的类型：活动、商品、优惠劵 
	 * @return	信息的类型：活动、商品、优惠劵 
	 */
	public String getNoticetype()
	{
		return this.noticetype;
	}

	/**
	 * 设置信息的图片 
	 * @param noticeimage	信息的图片 
	 */
	public void setNoticeimage(String noticeimage)
	{
		this.noticeimage = noticeimage != null ? noticeimage : "";
	}

	/**
	 * 获取信息的图片 
	 * @return	信息的图片 
	 */
	public String getNoticeimage()
	{
		return this.noticeimage;
	}
}