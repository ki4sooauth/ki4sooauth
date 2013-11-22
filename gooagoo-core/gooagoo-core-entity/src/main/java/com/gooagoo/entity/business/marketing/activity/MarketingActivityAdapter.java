package com.gooagoo.entity.business.marketing.activity;

import java.io.Serializable;
import java.util.Date;

/**
 * 吆喝信息表
 */

public class MarketingActivityAdapter implements Serializable
{

	 private static final long serialVersionUID = 1L;

	    private String activityId;//活动编号，UUID

	    private Date startTime;//活动开始时间

	    private Date endTime;//活动结束时间
	    
	    private String shopTypeRoot;//活动类型

		public String getActivityId() {
			return activityId;
		}

		public void setActivityId(String activityId) {
			this.activityId = activityId;
		}

		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}

		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}

		public String getShopTypeRoot() {
			return shopTypeRoot;
		}

		public void setShopTypeRoot(String shopTypeRoot) {
			this.shopTypeRoot = shopTypeRoot;
		}

		@Override
		public String toString() {
			return "MarketingActivityVO [activityId=" + activityId
					+ ", startTime=" + startTime + ", endTime=" + endTime
					+ ", shopTypeRoot=" + shopTypeRoot + "]";
		}
	    
}
