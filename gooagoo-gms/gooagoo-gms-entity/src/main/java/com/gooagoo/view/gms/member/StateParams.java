package com.gooagoo.view.gms.member;

import java.io.Serializable;

public class StateParams implements Serializable {
	private static final long serialVersionUID = 1L;

	private String sType; // 统计类型（如：店内用户）
	private String userType; // 用户类型
	private String shopId; // 商家id
	private String entityId; // 实体店id
	private String areaId; // 区域id
	private String hisOrCurr; //实时或历史
	private String timeType; // 时间类型
	private String timeVal; // 时间
	private String column; //当前数据列值
	private String numOrTimes;//人数或人次
	private String mac;//mac地址
	
	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getHisOrCurr() {
		return hisOrCurr;
	}

	public void setHisOrCurr(String hisOrCurr) {
		this.hisOrCurr = hisOrCurr;
	}

	public String getNumOrTimes() {
		return numOrTimes;
	}

	public void setNumOrTimes(String numOrTimes) {
		this.numOrTimes = numOrTimes;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getsType() {
		return sType;
	}

	public void setsType(String sType) {
		this.sType = sType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(String timeVal) {
		this.timeVal = timeVal;
	}
    
	public String getShopIdOrEntityIdOrAreaId() {
		if(this.areaId!=null && !"".equals(this.areaId.trim())){
			return this.areaId;
		}else if(this.entityId!=null && !"".equals(this.entityId.trim())){
			return this.entityId;
		}else{
			return this.shopId;
		}
		
	}
	
	
	@Override
	public String toString() {
		return "StateParams [sType=" + sType + ", userType=" + userType + ", shopId=" + shopId + ", entityId=" + entityId + ", areaId=" + areaId + ", timeType=" + timeType + ", timeVal=" + timeVal
				+ "]";
	}

}
