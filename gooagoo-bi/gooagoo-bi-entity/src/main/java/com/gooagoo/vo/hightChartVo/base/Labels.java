package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Labels implements Serializable {
	private Integer rotation;
	private Integer y;
	private Style style;
	private String overflow;

	public String getOverflow() {
		return overflow;
	}

	public void setOverflow(String overflow) {
		this.overflow = overflow;
	}

	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Integer getRotation() {
		return rotation;
	}

	public void setRotation(Integer rotation) {
		this.rotation = rotation;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}
    
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
