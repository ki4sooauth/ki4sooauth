package com.gooagoo.view.gms.resource;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class AllBiddingRecordView implements Serializable {
	private String adName; // 广告位名称
	private Date biddingStartTime; // 竞拍开始时间
	private String inPage;//所在页面
	private Date biddingEndTime; // 竞拍结束时间
	private String biddingNo; // 竞拍编号
	private String shopName;// 商家名称
	private Double bidAmount; // 出价
	private String adDescription; // 描述
	private Date effectStartDate;// 生效起始日期

	private Date effectEndDate;// 生效结束日期

	private String effectStartTime;// 生效起始时间

	private String effectEndTime;// 生效结束时间
	
	private Date bidDate; //竞拍时间

	private String result;// 結果
     
	
	public String getInPage() {
		return inPage;
	}

	public void setInPage(String inPage) {
		this.inPage = inPage;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public String getAdDescription() {
		return adDescription;
	}

	public void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
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

	public void setResult(String result) {
		this.result = result;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public Date getBiddingStartTime() {
		return biddingStartTime;
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

	public void setBiddingStartTime(Date biddingStartTime) {
		this.biddingStartTime = biddingStartTime;
	}

	public Date getBiddingEndTime() {
		return biddingEndTime;
	}

	public void setBiddingEndTime(Date biddingEndTime) {
		this.biddingEndTime = biddingEndTime;
	}

	public String getBiddingNo() {
		return biddingNo;
	}

	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}

	public Double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
		return "AllBiddingRecordView [adName=" + adName + ", biddingStartTime=" + biddingStartTime + ", inPage=" + inPage + ", biddingEndTime=" + biddingEndTime + ", biddingNo=" + biddingNo
				+ ", shopName=" + shopName + ", bidAmount=" + bidAmount + ", adDescription=" + adDescription + ", effectStartDate=" + effectStartDate + ", effectEndDate=" + effectEndDate
				+ ", effectStartTime=" + effectStartTime + ", effectEndTime=" + effectEndTime + ", bidDate=" + bidDate + ", result=" + result + "]";
	}

}
