package com.gooagoo.mobile.entity.mobb05.transform;

import java.io.Serializable;

/**
 *  评论信息 
 */
public class Usercomment implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 评论的id  */
	private String commentid = "";

	/** 评论人的昵称  */
	private String nickname = "";

	/** 商品概要描述  */
	private String description = "";

	/** 商品评分  */
	private String commentlevel = "";

	/** 评论的内容  */
	private String content = "";

	/** 评论来源：M-手机端按机型分类，P-网站端按浏览器分类  */
	private String source = "";

	/** 评论时间  */
	private String createtime = "";

	/**
	 * 设置评论的id 
	 * @param commentid	评论的id 
	 */
	public void setCommentid(String commentid)
	{
		this.commentid = commentid != null ? commentid : "";
	}

	/**
	 * 获取评论的id 
	 * @return	评论的id 
	 */
	public String getCommentid()
	{
		return this.commentid;
	}

	/**
	 * 设置评论人的昵称 
	 * @param nickname	评论人的昵称 
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname != null ? nickname : "";
	}

	/**
	 * 获取评论人的昵称 
	 * @return	评论人的昵称 
	 */
	public String getNickname()
	{
		return this.nickname;
	}

	/**
	 * 设置商品概要描述 
	 * @param description	商品概要描述 
	 */
	public void setDescription(String description)
	{
		this.description = description != null ? description : "";
	}

	/**
	 * 获取商品概要描述 
	 * @return	商品概要描述 
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * 设置商品评分 
	 * @param commentlevel	商品评分 
	 */
	public void setCommentlevel(String commentlevel)
	{
		this.commentlevel = commentlevel != null ? commentlevel : "";
	}

	/**
	 * 获取商品评分 
	 * @return	商品评分 
	 */
	public String getCommentlevel()
	{
		return this.commentlevel;
	}

	/**
	 * 设置评论的内容 
	 * @param content	评论的内容 
	 */
	public void setContent(String content)
	{
		this.content = content != null ? content : "";
	}

	/**
	 * 获取评论的内容 
	 * @return	评论的内容 
	 */
	public String getContent()
	{
		return this.content;
	}

	/**
	 * 设置评论来源：M-手机端按机型分类，P-网站端按浏览器分类 
	 * @param source	评论来源：M-手机端按机型分类，P-网站端按浏览器分类 
	 */
	public void setSource(String source)
	{
		this.source = source != null ? source : "";
	}

	/**
	 * 获取评论来源：M-手机端按机型分类，P-网站端按浏览器分类 
	 * @return	评论来源：M-手机端按机型分类，P-网站端按浏览器分类 
	 */
	public String getSource()
	{
		return this.source;
	}

	/**
	 * 设置评论时间 
	 * @param createtime	评论时间 
	 */
	public void setCreatetime(String createtime)
	{
		this.createtime = createtime != null ? createtime : "";
	}

	/**
	 * 获取评论时间 
	 * @return	评论时间 
	 */
	public String getCreatetime()
	{
		return this.createtime;
	}
}