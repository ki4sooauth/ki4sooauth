package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Title implements Serializable {
	private String text;
	private Integer x;
	private String align;

	public Title() {
	}

	public Title(String text, Integer x, String align) {
		super();
		this.text = text;
		this.x = x;
		this.align = align;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
