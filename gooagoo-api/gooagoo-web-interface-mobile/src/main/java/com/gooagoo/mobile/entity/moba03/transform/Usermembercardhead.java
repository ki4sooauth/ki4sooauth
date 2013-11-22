package com.gooagoo.mobile.entity.moba03.transform;

import java.io.Serializable;

/**
 * 卡头信息 
 */
public class Usermembercardhead implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 卡包营销编号  */
	private String cardtopinfoid = "";

	/** 会员卡编号  */
	private String cardid = "";

	/** 商家编号  */
	private String shopid = "";

	/** 第1行标题  */
	private String line1title = "";

	/** 第1行尺寸  */
	private String line1size = "";

	/** 第1行字体  */
	private String line1font = "";

	/** 第1行颜色  */
	private String line1color = "";

	/** 第1行url  */
	private String line1url = "";

	/** 第2行标题  */
	private String line2title = "";

	/** 第2行尺寸  */
	private String line2size = "";

	/** 第2行字体  */
	private String line2font = "";

	/** 第2行颜色  */
	private String line2color = "";

	/** 第2行url  */
	private String line2url = "";

	/** 生效日期  */
	private String begindate = "";

	/** 失效日期  */
	private String enddate = "";

	/** 发布日志编号  */
	private String releaseid = "";

	/** 是否删除，Y-已删除，N-未删除  */
	private String isdel = "";

	/** 创建时间  */
	private String createtime = "";

	/** 最后一次修改时间  */
	private String ctimestamp = "";

	/**
	 * 设置卡包营销编号 
	 * @param cardtopinfoid	卡包营销编号 
	 */
	public void setCardtopinfoid(String cardtopinfoid)
	{
		this.cardtopinfoid = cardtopinfoid != null ? cardtopinfoid : "";
	}

	/**
	 * 获取卡包营销编号 
	 * @return	卡包营销编号 
	 */
	public String getCardtopinfoid()
	{
		return this.cardtopinfoid;
	}

	/**
	 * 设置会员卡编号 
	 * @param cardid	会员卡编号 
	 */
	public void setCardid(String cardid)
	{
		this.cardid = cardid != null ? cardid : "";
	}

	/**
	 * 获取会员卡编号 
	 * @return	会员卡编号 
	 */
	public String getCardid()
	{
		return this.cardid;
	}

	/**
	 * 设置商家编号 
	 * @param shopid	商家编号 
	 */
	public void setShopid(String shopid)
	{
		this.shopid = shopid != null ? shopid : "";
	}

	/**
	 * 获取商家编号 
	 * @return	商家编号 
	 */
	public String getShopid()
	{
		return this.shopid;
	}

	/**
	 * 设置第1行标题 
	 * @param line1title	第1行标题 
	 */
	public void setLine1title(String line1title)
	{
		this.line1title = line1title != null ? line1title : "";
	}

	/**
	 * 获取第1行标题 
	 * @return	第1行标题 
	 */
	public String getLine1title()
	{
		return this.line1title;
	}

	/**
	 * 设置第1行尺寸 
	 * @param line1size	第1行尺寸 
	 */
	public void setLine1size(String line1size)
	{
		this.line1size = line1size != null ? line1size : "";
	}

	/**
	 * 获取第1行尺寸 
	 * @return	第1行尺寸 
	 */
	public String getLine1size()
	{
		return this.line1size;
	}

	/**
	 * 设置第1行字体 
	 * @param line1font	第1行字体 
	 */
	public void setLine1font(String line1font)
	{
		this.line1font = line1font != null ? line1font : "";
	}

	/**
	 * 获取第1行字体 
	 * @return	第1行字体 
	 */
	public String getLine1font()
	{
		return this.line1font;
	}

	/**
	 * 设置第1行颜色 
	 * @param line1color	第1行颜色 
	 */
	public void setLine1color(String line1color)
	{
		this.line1color = line1color != null ? line1color : "";
	}

	/**
	 * 获取第1行颜色 
	 * @return	第1行颜色 
	 */
	public String getLine1color()
	{
		return this.line1color;
	}

	/**
	 * 设置第1行url 
	 * @param line1url	第1行url 
	 */
	public void setLine1url(String line1url)
	{
		this.line1url = line1url != null ? line1url : "";
	}

	/**
	 * 获取第1行url 
	 * @return	第1行url 
	 */
	public String getLine1url()
	{
		return this.line1url;
	}

	/**
	 * 设置第2行标题 
	 * @param line2title	第2行标题 
	 */
	public void setLine2title(String line2title)
	{
		this.line2title = line2title != null ? line2title : "";
	}

	/**
	 * 获取第2行标题 
	 * @return	第2行标题 
	 */
	public String getLine2title()
	{
		return this.line2title;
	}

	/**
	 * 设置第2行尺寸 
	 * @param line2size	第2行尺寸 
	 */
	public void setLine2size(String line2size)
	{
		this.line2size = line2size != null ? line2size : "";
	}

	/**
	 * 获取第2行尺寸 
	 * @return	第2行尺寸 
	 */
	public String getLine2size()
	{
		return this.line2size;
	}

	/**
	 * 设置第2行字体 
	 * @param line2font	第2行字体 
	 */
	public void setLine2font(String line2font)
	{
		this.line2font = line2font != null ? line2font : "";
	}

	/**
	 * 获取第2行字体 
	 * @return	第2行字体 
	 */
	public String getLine2font()
	{
		return this.line2font;
	}

	/**
	 * 设置第2行颜色 
	 * @param line2color	第2行颜色 
	 */
	public void setLine2color(String line2color)
	{
		this.line2color = line2color != null ? line2color : "";
	}

	/**
	 * 获取第2行颜色 
	 * @return	第2行颜色 
	 */
	public String getLine2color()
	{
		return this.line2color;
	}

	/**
	 * 设置第2行url 
	 * @param line2url	第2行url 
	 */
	public void setLine2url(String line2url)
	{
		this.line2url = line2url != null ? line2url : "";
	}

	/**
	 * 获取第2行url 
	 * @return	第2行url 
	 */
	public String getLine2url()
	{
		return this.line2url;
	}

	/**
	 * 设置生效日期 
	 * @param begindate	生效日期 
	 */
	public void setBegindate(String begindate)
	{
		this.begindate = begindate != null ? begindate : "";
	}

	/**
	 * 获取生效日期 
	 * @return	生效日期 
	 */
	public String getBegindate()
	{
		return this.begindate;
	}

	/**
	 * 设置失效日期 
	 * @param enddate	失效日期 
	 */
	public void setEnddate(String enddate)
	{
		this.enddate = enddate != null ? enddate : "";
	}

	/**
	 * 获取失效日期 
	 * @return	失效日期 
	 */
	public String getEnddate()
	{
		return this.enddate;
	}

	/**
	 * 设置发布日志编号 
	 * @param releaseid	发布日志编号 
	 */
	public void setReleaseid(String releaseid)
	{
		this.releaseid = releaseid != null ? releaseid : "";
	}

	/**
	 * 获取发布日志编号 
	 * @return	发布日志编号 
	 */
	public String getReleaseid()
	{
		return this.releaseid;
	}

	/**
	 * 设置是否删除，Y-已删除，N-未删除 
	 * @param isdel	是否删除，Y-已删除，N-未删除 
	 */
	public void setIsdel(String isdel)
	{
		this.isdel = isdel != null ? isdel : "";
	}

	/**
	 * 获取是否删除，Y-已删除，N-未删除 
	 * @return	是否删除，Y-已删除，N-未删除 
	 */
	public String getIsdel()
	{
		return this.isdel;
	}

	/**
	 * 设置创建时间 
	 * @param createtime	创建时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取创建时间 
	 * @return	创建时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}

	/**
	 * 设置最后一次修改时间 
	 * @param ctimestamp	最后一次修改时间 
	 */
	public void setCtimestamp(String ctimestamp)
	{
		this.ctimestamp = ctimestamp != null ? ctimestamp : "";
	}

	/**
	 * 获取最后一次修改时间 
	 * @return	最后一次修改时间 
	 */
	public String getCtimestamp()
	{
		return this.ctimestamp;
	}
}