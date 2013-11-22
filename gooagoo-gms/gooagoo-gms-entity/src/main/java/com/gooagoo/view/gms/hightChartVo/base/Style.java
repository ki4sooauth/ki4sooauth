package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Style implements Serializable {
	private String color = "#3E576F";
	private String font = "italic";
    private  String  fontWeight;
   
	public Style() {
		super();
	}
	
	public Style(String color, String font, String fontWeight) {
		super();
		this.color = color;
		this.font = font;
		this.fontWeight = fontWeight;
	}




	public String getFontWeight() {
		return fontWeight;
	}

	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}
    
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
