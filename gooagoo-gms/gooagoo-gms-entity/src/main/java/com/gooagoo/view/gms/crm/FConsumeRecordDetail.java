package com.gooagoo.view.gms.crm;

import java.io.Serializable;

/**
 * 用户消费档案
 * 
 */
public class FConsumeRecordDetail implements Serializable {
	private static final long serialVersionUID = 1L;
	private String goodsName; // 商品名称
	private int goodsNum;// 数量
	private double goodsPrice; // 单价
	private double totalPrice; // 总价

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "FConsumeRecordDetail [goodsName=" + goodsName + ", goodsNum=" + goodsNum + ", goodsPrice=" + goodsPrice + ", totalPrice=" + totalPrice + "]";
	}

}
