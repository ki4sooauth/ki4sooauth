package com.gooagoo.entity.business.marketing.cryout;

import java.io.Serializable;

/**
 *  推荐吆喝 
 */
public class RecommendCryoutInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/** 吆喝的id  */
	private String cryoutid = "";

	/** 用户id  */
	private String userid = "";

	/** 商家的id  */
	private String shopid = "";

	/** 商家名称  */
	private String shopname = "";

	/** 商家的logo  */
	private String logo = "";

	/** 商家地址  */
	private String address = "";

	/** 吆喝的内容（有特殊格式的规定）  */
	private String cryouttextmobile = "";

	/** 极小的缩略图  */
	private String thumbnailpic = "";

	/** 大点的图  */
	private String bmiddlepic = "";

	/** 原始图片（最大的）  */
	private String originalpic = "";

	/** 信息来源：L-现场，R-远程  */
	private String source = "";

	/** 吆喝创建时间  */
	private String createtime = "";

	/** 是否允许关注：Y-允许，N-不允许   */
	private String allowat = "";

	/** 是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或会员  */
	private String relation = "";

	/**
	 * 设置吆喝的id 
	 * @param cryoutid	吆喝的id 
	 */
	public void setCryoutid(String cryoutid) {
		this.cryoutid = cryoutid;
	}

	/**
	 * 获取吆喝的id 
	 * @return	吆喝的id 
	 */
	public String getCryoutid() {
		return this.cryoutid;
	}

	/**
	 * 设置用户id 
	 * @param userid	用户id 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 获取用户id 
	 * @return	用户id 
	 */
	public String getUserid() {
		return this.userid;
	}

	/**
	 * 设置商家的id 
	 * @param shopid	商家的id 
	 */
	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	/**
	 * 获取商家的id 
	 * @return	商家的id 
	 */
	public String getShopid() {
		return this.shopid;
	}

	/**
	 * 设置商家名称 
	 * @param shopname	商家名称 
	 */
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	/**
	 * 获取商家名称 
	 * @return	商家名称 
	 */
	public String getShopname() {
		return this.shopname;
	}

	/**
	 * 设置商家的logo 
	 * @param logo	商家的logo 
	 */
	public void setLogo(String logo) {
		this.logo = logo;
	}

	/**
	 * 获取商家的logo 
	 * @return	商家的logo 
	 */
	public String getLogo() {
		return this.logo;
	}

	/**
	 * 设置商家地址 
	 * @param address	商家地址 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取商家地址 
	 * @return	商家地址 
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * 设置吆喝的内容（有特殊格式的规定） 
	 * @param cryouttextmobile	吆喝的内容（有特殊格式的规定） 
	 */
	public void setCryouttextmobile(String cryouttextmobile) {
		this.cryouttextmobile = cryouttextmobile;
	}

	/**
	 * 获取吆喝的内容（有特殊格式的规定） 
	 * @return	吆喝的内容（有特殊格式的规定） 
	 */
	public String getCryouttextmobile() {
		return this.cryouttextmobile;
	}

	/**
	 * 设置极小的缩略图 
	 * @param thumbnailpic	极小的缩略图 
	 */
	public void setThumbnailpic(String thumbnailpic) {
		this.thumbnailpic = thumbnailpic;
	}

	/**
	 * 获取极小的缩略图 
	 * @return	极小的缩略图 
	 */
	public String getThumbnailpic() {
		return this.thumbnailpic;
	}

	/**
	 * 设置大点的图 
	 * @param bmiddlepic	大点的图 
	 */
	public void setBmiddlepic(String bmiddlepic) {
		this.bmiddlepic = bmiddlepic;
	}

	/**
	 * 获取大点的图 
	 * @return	大点的图 
	 */
	public String getBmiddlepic() {
		return this.bmiddlepic;
	}

	/**
	 * 设置原始图片（最大的） 
	 * @param originalpic	原始图片（最大的） 
	 */
	public void setOriginalpic(String originalpic) {
		this.originalpic = originalpic;
	}

	/**
	 * 获取原始图片（最大的） 
	 * @return	原始图片（最大的） 
	 */
	public String getOriginalpic() {
		return this.originalpic;
	}

	/**
	 * 设置信息来源：L-现场，R-远程 
	 * @param source	信息来源：L-现场，R-远程 
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * 获取信息来源：L-现场，R-远程 
	 * @return	信息来源：L-现场，R-远程 
	 */
	public String getSource() {
		return this.source;
	}

	/**
	 * 设置吆喝创建时间 
	 * @param createtime	吆喝创建时间 
	 */
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	/**
	 * 获取吆喝创建时间 
	 * @return	吆喝创建时间 
	 */
	public String getCreatetime() {
		return this.createtime;
	}

	/**
	 * 设置是否允许关注：Y-允许，N-不允许  
	 * @param allowat	是否允许关注：Y-允许，N-不允许  
	 */
	public void setAllowat(String allowat) {
		this.allowat = allowat;
	}

	/**
	 * 获取是否允许关注：Y-允许，N-不允许  
	 * @return	是否允许关注：Y-允许，N-不允许  
	 */
	public String getAllowat() {
		return this.allowat;
	}

	/**
	 * 设置是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或会员 
	 * @param relation	是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或会员 
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}

	/**
	 * 获取是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或会员 
	 * @return	是否已经关注或者是会员：0-关注卡，1-电子卡，2-实体卡，N-未关注或会员 
	 */
	public String getRelation() {
		return this.relation;
	}
}