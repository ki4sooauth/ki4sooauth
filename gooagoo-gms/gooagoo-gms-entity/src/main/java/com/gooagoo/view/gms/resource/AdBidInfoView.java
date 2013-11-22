package com.gooagoo.view.gms.resource;

import java.io.Serializable;
import java.util.Date;

public class AdBidInfoView implements Serializable {
	private static final long serialVersionUID = 4035467393085638817L;

	private String bidId;// 竞拍编号，UUID

	private String adCode;// 广告位编码
	
	private String shopName; //当前最高价的商家名称

	private Double startingPrice;// 起拍价

	private Double increase;// 涨幅

	private double maxBidAmount; // 当前最高价

	private Date bidStartTime;// 竞价起始时间

	private Date bidEndTime;// 竞价结束时间

	private Date effectStartDate;// 生效起始日期

	private Date effectEndDate;// 生效结束日期

	private String effectStartTime;// '生效起始时间，格式HH:mm:ss，例如211204',

	private String effectEndTime;// '生效结束时间，格式HH:mm:ss，例如211204',

	private String imgUrl;// 图片地址

	private String linkUrl;// 链接地址

	public double getMaxBidAmount() {
		return maxBidAmount;
	}

	public void setMaxBidAmount(double maxBidAmount) {
		this.maxBidAmount = maxBidAmount;
	}
    
	
	
	
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getBidId() {
		return bidId;
	}

	public void setBidId(String bidId) {
		this.bidId = bidId;
	}

	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public Double getStartingPrice() {
		return startingPrice;
	}

	public void setStartingPrice(Double startingPrice) {
		this.startingPrice = startingPrice;
	}

	public Double getIncrease() {
		return increase;
	}

	public void setIncrease(Double increase) {
		this.increase = increase;
	}

	public Date getBidStartTime() {
		return bidStartTime;
	}

	public void setBidStartTime(Date bidStartTime) {
		this.bidStartTime = bidStartTime;
	}

	public Date getBidEndTime() {
		return bidEndTime;
	}

	public void setBidEndTime(Date bidEndTime) {
		this.bidEndTime = bidEndTime;
	}

	public Date getEffectStartDate() {
		return effectStartDate;
	}

	public void setEffectStartDate(Date effectStartDate) {
		this.effectStartDate = effectStartDate;
	}

	public Date getEffectEndDate() {
		return effectEndDate;
	}

	public void setEffectEndDate(Date effectEndDate) {
		this.effectEndDate = effectEndDate;
	}

	public String getEffectStartTime() {
		return effectStartTime;
	}

	public void setEffectStartTime(String effectStartTime) {
		this.effectStartTime = effectStartTime;
	}

	public String getEffectEndTime() {
		return effectEndTime;
	}

	public void setEffectEndTime(String effectEndTime) {
		this.effectEndTime = effectEndTime;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	@Override
	public String toString() {
		return "AdBidInfoView [bidId=" + bidId + ", adCode=" + adCode + ", shopName=" + shopName + ", startingPrice=" + startingPrice + ", increase=" + increase + ", maxBidAmount=" + maxBidAmount
				+ ", bidStartTime=" + bidStartTime + ", bidEndTime=" + bidEndTime + ", effectStartDate=" + effectStartDate + ", effectEndDate=" + effectEndDate + ", effectStartTime="
				+ effectStartTime + ", effectEndTime=" + effectEndTime + ", imgUrl=" + imgUrl + ", linkUrl=" + linkUrl + "]";
	}

}
