package com.gooagoo.mobile.entity.moba04.transform;

import java.io.Serializable;

/**
 * 通知 
 */
public class Membernotice implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 是否已读  */
	private String isread = "";

	/** 通知编号  */
	private String noticeinfoid = "";

	/** 分页编号:通知推送时间（YYYY-MM-DD HH:MM:SS） +通知编号 */
	private String pageid = "";

	/** 通知和用户关联表的UUID  */
	private String noticeuserid = "";

	/** 店铺id  */
	private String shopid = "";

	/** 店铺logo  */
	private String logo = "";

	/** 通知名称  */
	private String title = "";

	/** 小图片  */
	private String img = "";

	/** 通知详情  */
	private String noticetextmobile = "";

	/** 提交时间  */
	private String ctimestamp = "";

	/** 是否删除  */
	private String isdel = "";

	/**
	 * 设置是否已读 
	 * @param isread	是否已读 
	 */
	public void setIsread(String isread)
	{
		this.isread = isread != null ? isread : "";
	}

	/**
	 * 获取是否已读 
	 * @return	是否已读 
	 */
	public String getIsread()
	{
		return this.isread;
	}

	/**
	 * 设置通知编号 
	 * @param noticeinfoid	通知编号 
	 */
	public void setNoticeinfoid(String noticeinfoid)
	{
		this.noticeinfoid = noticeinfoid != null ? noticeinfoid : "";
	}

	/**
	 * 获取通知编号 
	 * @return	通知编号 
	 */
	public String getNoticeinfoid()
	{
		return this.noticeinfoid;
	}

	/**
	 * 设置分页编号:通知推送时间（YYYY-MM-DD HH:MM:SS） +通知编号
	 * @param pageid	分页编号:通知推送时间（YYYY-MM-DD HH:MM:SS） +通知编号
	 */
	public void setPageid(String pageid)
	{
		this.pageid = pageid != null ? pageid : "";
	}

	/**
	 * 获取分页编号:通知推送时间（YYYY-MM-DD HH:MM:SS） +通知编号
	 * @return	分页编号:通知推送时间（YYYY-MM-DD HH:MM:SS） +通知编号
	 */
	public String getPageid()
	{
		return this.pageid;
	}

	/**
	 * 设置通知和用户关联表的UUID 
	 * @param noticeuserid	通知和用户关联表的UUID 
	 */
	public void setNoticeuserid(String noticeuserid)
	{
		this.noticeuserid = noticeuserid != null ? noticeuserid : "";
	}

	/**
	 * 获取通知和用户关联表的UUID 
	 * @return	通知和用户关联表的UUID 
	 */
	public String getNoticeuserid()
	{
		return this.noticeuserid;
	}

	/**
	 * 设置店铺id 
	 * @param shopid	店铺id 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取店铺id 
	 * @return	店铺id 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置店铺logo 
	 * @param logo	店铺logo 
	 */
	public void setLogo(String logo)
	{
		this.logo = logo != null ? logo : "";
	}

	/**
	 * 获取店铺logo 
	 * @return	店铺logo 
	 */
	public String getLogo()
	{
		return this.logo;
	}

	/**
	 * 设置通知名称 
	 * @param title	通知名称 
	 */
	public void setTitle(String title)
	{
		this.title = title != null ? title : "";
	}

	/**
	 * 获取通知名称 
	 * @return	通知名称 
	 */
	public String getTitle()
	{
		return this.title;
	}

	/**
	 * 设置小图片 
	 * @param img	小图片 
	 */
	public void setImg(String img)
	{
		this.img = img != null ? img : "";
	}

	/**
	 * 获取小图片 
	 * @return	小图片 
	 */
	public String getImg()
	{
		return this.img;
	}

	/**
	 * 设置通知详情 
	 * @param noticetextmobile	通知详情 
	 */
	public void setNoticetextmobile(String noticetextmobile)
	{
		this.noticetextmobile = noticetextmobile != null ? noticetextmobile : "";
	}

	/**
	 * 获取通知详情 
	 * @return	通知详情 
	 */
	public String getNoticetextmobile()
	{
		return this.noticetextmobile;
	}

	/**
	 * 设置提交时间 
	 * @param ctimestamp	提交时间 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取提交时间 
	 * @return	提交时间 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}

	/**
	 * 设置是否删除 
	 * @param isdel	是否删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除 
	 * @return	是否删除 
	 */
	public String getIsdel()
	{
		return this.isdel;
	}
}