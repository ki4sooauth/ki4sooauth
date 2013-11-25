package com.gooagoo.view.gms.resource;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class ShopBiddingRecordView implements Serializable {

	private String adName; // 广告位名称
	private String biddingNo; // 竞拍编号
	private Date biddingTime; // 竞拍时间
	private Date biddingStartTime; // 竞拍开始时间
	private Date biddingEndTime; // 竞拍结束时间
	private String adDescription; // 描述
	private Date effectStartDate;// 生效起始日期
	private Date effectEndDate;// 生效结束日期
	private String effectStartTime;// 生效起始时间
	private Date  bidDate; //竞拍时间
	private String effectEndTime;// 生效结束时间
	private Double bidAmount;// 出价
	private String result; // 結果
	
	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getBiddingNo() {
		return biddingNo;
	}

	public void setBiddingNo(String biddingNo) {
		this.biddingNo = biddingNo;
	}

	public Date getBiddingTime() {
		return biddingTime;
	}

	public void setBiddingTime(Date biddingTime) {
		this.biddingTime = biddingTime;
	}

	public Date getBiddingStartTime() {
		return biddingStartTime;
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

	public Double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(Double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ShopBiddingRecordView [adName=" + adName + ", biddingNo=" + biddingNo + ", biddingTime=" + biddingTime + ", biddingStartTime=" + biddingStartTime + ", biddingEndTime="
				+ biddingEndTime + ", adDescription=" + adDescription + ", effectStartDate=" + effectStartDate + ", effectEndDate=" + effectEndDate + ", effectStartTime=" + effectStartTime
				+ ", bidDate=" + bidDate + ", effectEndTime=" + effectEndTime + ", bidAmount=" + bidAmount + ", result=" + result + "]";
	}

}