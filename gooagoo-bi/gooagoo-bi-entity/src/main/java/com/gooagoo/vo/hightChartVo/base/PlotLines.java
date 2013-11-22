package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class PlotLines implements Serializable {
	private Integer value;
	private Integer width;
	private String color;

	
	public PlotLines() {
		super();
	}
	
	public PlotLines(Integer value, Integer width, String color) {
		super();
		this.value = value;
		this.width = width;
		this.color = color;
	}



	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,false);
	}
}
