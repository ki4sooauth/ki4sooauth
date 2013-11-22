package com.gooagoo.view.gms.resource;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AdView implements Serializable {
	private String adCode;// 广告位编码

	private String adType;// 广告位类型，参考通用字典表的ad_type

	private String adName;// 广告位名称

	private String adDescription;// 广告位描述

	private String adUrl;// 广告位介绍url，图片链接地址

	public String getAdCode() {
		return adCode;
	}

	public void setAdCode(String adCode) {
		this.adCode = adCode;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getAdName() {
		return adName;
	}

	public void setAdName(String adName) {
		this.adName = adName;
	}

	public String getAdDescription() {
		return adDescription;
	}

	public void setAdDescription(String adDescription) {
		this.adDescription = adDescription;
	}

	public String getAdUrl() {
		return adUrl;
	}

	public void setAdUrl(String adUrl) {
		this.adUrl = adUrl;
	}

	@Override
	public String toString() {
		return "AdView [adCode=" + adCode + ", adType=" + adType + ", adName=" + adName + ", adDescription=" + adDescription + ", adUrl=" + adUrl + "]";
	}
    
}
