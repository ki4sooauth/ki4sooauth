package com.gooagoo.view.gms.statistic;

import java.io.Serializable;

public class StatisticParameters implements Serializable {

	private static final long serialVersionUID = 1L;

	private String parentId; // 统计项id(如：活动id)
	private String childId; // 子统计项id(如活动下的活动内容);
	private String name; // 统计类别，如：活动
	private String chartName; // 统计图名称
	private String timeTypeVal; // 统计时间类型
	private String source; // 来源
	private String hisOrCurr; // 实时历史数据
	private String channel; // 渠道
	private String userType; // 用户类型
	private String behType; // 行为类型
	private String column;// x轴数据
	private String shopId;// 商家id;
	private String entityId; // 实体店id;
	private String timeVal; // 指定的时间

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

	public String getTimeVal() {
		return timeVal;
	}

	public void setTimeVal(String timeVal) {
		this.timeVal = timeVal;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getBehType() {
		return behType;
	}

	public void setBehType(String behType) {
		this.behType = behType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getChildId() {
		return childId;
	}

	public void setChildId(String childId) {
		this.childId = childId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getTimeTypeVal() {
		return timeTypeVal;
	}

	public void setTimeTypeVal(String timeTypeVal) {
		this.timeTypeVal = timeTypeVal;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getHisOrCurr() {
		return hisOrCurr;
	}

	public void setHisOrCurr(String hisOrCurr) {
		this.hisOrCurr = hisOrCurr;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getChannel() {
		if (this.channel == null || "".equals(channel)) {
			this.channel = "*";
		}else if("goods".equals(this.name) && this.childId!=null){
			channel = this.channel+this.childId;
		}else if("category".equals(this.name) && this.childId!=null){
			channel = this.channel+this.childId;
		}else if("brand".equals(this.name) && this.childId!=null){
			channel = this.channel+this.childId;
		}else if("coupon".equals(this.name) && this.childId!=null){
			channel = this.channel+this.childId;
		}
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getId() {
		if (this.childId != null && !"".equals(childId.trim())) {
			return this.childId;
		}
		return this.parentId;
	}

	public String getShopIdOrEntityId() {
		if (this.entityId != null && !"".equals(entityId.trim())) {
			return this.entityId;
		}
		return this.shopId;
	}

	@Override
	public String toString() {
		return "StatisticParameters [parentId=" + parentId + ", childId=" + childId + ", name=" + name + ", chartName=" + chartName + ", timeTypeVal=" + timeTypeVal + ", source=" + source
				+ ", hisOrCurr=" + hisOrCurr + ", userType=" + userType + "]";
	}

}
