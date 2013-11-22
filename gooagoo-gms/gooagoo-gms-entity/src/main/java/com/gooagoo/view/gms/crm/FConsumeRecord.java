package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户消费档案
 * 
 */
public class FConsumeRecord implements Serializable {
	private static final long serialVersionUID = 1L;
	private String orderNo; //订单编号
	private double payMoney; //消费金额
	private Date payTime; //消费时间
	private String billImg; //帐单图片
	
	private List<FConsumeRecordDetail> consumeRecordDetailList = new ArrayList<FConsumeRecordDetail>(0);//消费详细

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public double getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(double payMoney) {
		this.payMoney = payMoney;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getBillImg() {
		return billImg;
	}

	public void setBillImg(String billImg) {
		this.billImg = billImg;
	}

	public List<FConsumeRecordDetail> getConsumeRecordDetailList() {
		return consumeRecordDetailList;
	}

	public void setConsumeRecordDetailList(List<FConsumeRecordDetail> consumeRecordDetailList) {
		this.consumeRecordDetailList = consumeRecordDetailList;
	}

	@Override
	public String toString() {
		return "FConsumeRecord [orderNo=" + orderNo + ", payMoney=" + payMoney + ", payTime=" + payTime + ", billImg=" + billImg + ", consumeRecordDetailList=" + consumeRecordDetailList + "]";
	}
	
	
	
}
