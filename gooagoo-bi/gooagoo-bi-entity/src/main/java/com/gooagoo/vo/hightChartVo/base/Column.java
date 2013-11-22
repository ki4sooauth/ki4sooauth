package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Column implements Serializable {
	private Float pointPadding;
	private Integer borderWidth;
	private String stacking;
	private DataLabels dataLabels;

	public DataLabels getDataLabels() {
		return dataLabels;
	}

	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}

	public String getStacking() {
		return stacking;
	}

	public void setStacking(String stacking) {
		this.stacking = stacking;
	}

	public float getPointPadding() {
		return pointPadding;
	}

	public void setPointPadding(float pointPadding) {
		this.pointPadding = pointPadding;
	}

	public Integer getBorderWidth() {
		return borderWidth;
	}

	public void setBorderWidth(Integer borderWidth) {
		this.borderWidth = borderWidth;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
