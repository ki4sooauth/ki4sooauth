package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Subtitle implements Serializable {
	private String text;
	private Integer x;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}
   
	
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
