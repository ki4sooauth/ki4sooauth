package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Legend implements Serializable {
	private String layout;
	private String align;
	private String verticalAlign;
	private Integer x;
	private Integer y;
	private Integer borderWidth;
	private Boolean floating;
	private String backgroundColor;
	private String borderColor;
	private Boolean shadow;
	private Boolean enabled;
	
	

	public Legend(String layout, String align, String verticalAlign, Integer x, Integer y, Integer borderWidth, Boolean floating, String backgroundColor, String borderColor, Boolean shadow,
			Boolean enabled) {
		super();
		this.layout = layout;
		this.align = align;
		this.verticalAlign = verticalAlign;
		this.x = x;
		this.y = y;
		this.borderWidth = borderWidth;
		this.floating = floating;
		this.backgroundColor = backgroundColor;
		this.borderColor = borderColor;
		this.shadow = shadow;
		this.enabled = enabled;
	}

	public Legend() {
	}

	public Boolean isFloating() {
		return floating;
	}

	public void setFloating(Boolean floating) {
		this.floating = floating;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Boolean getFloating() {
		return floating;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
	}

	public Boolean getShadow() {
		return shadow;
	}

	public void setShadow(Boolean shadow) {
		this.shadow = shadow;
	}

	public String getLayout() {
		return layout;
	}

	public void setLayout(String layout) {
		this.layout = layout;
	}

	public String getAlign() {
		return align;
	}

	public void setAlign(String align) {
		this.align = align;
	}

	public String getVerticalAlign() {
		return verticalAlign;
	}

	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
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
