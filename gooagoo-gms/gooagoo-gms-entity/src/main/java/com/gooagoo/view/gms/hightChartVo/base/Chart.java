package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Chart implements Serializable {
	private String renderTo="123456";
	private String plotBackgroundColor="123465";
	private String plotBorderWidth;
	private Boolean plotShadow;
	private String type;
	private Integer height;
	private Integer width;
	private Integer marginRight;
	private Integer marginBottom;

	public Chart() {
	}

	public Chart(String renderTo, String plotBackgroundColor, String plotBorderWidth, Boolean plotShadow, String type, Integer height, Integer width, Integer marginRight, Integer marginBottom) {
		super();
		this.renderTo = renderTo;
		this.plotBackgroundColor = plotBackgroundColor;
		this.plotBorderWidth = plotBorderWidth;
		this.plotShadow = plotShadow;
		this.type = type;
		this.height = height;
		this.width = width;
		this.marginRight = marginRight;
		this.marginBottom = marginBottom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getMarginRight() {
		return marginRight;
	}

	public void setMarginRight(Integer marginRight) {
		this.marginRight = marginRight;
	}

	public Integer getMarginBottom() {
		return marginBottom;
	}

	public void setMarginBottom(Integer marginBottom) {
		this.marginBottom = marginBottom;
	}

	public String getRenderTo() {
		return renderTo;
	}

	public void setRenderTo(String renderTo) {
		this.renderTo = renderTo;
	}

	public String getPlotBackgroundColor() {
		return plotBackgroundColor;
	}

	public void setPlotBackgroundColor(String plotBackgroundColor) {
		this.plotBackgroundColor = plotBackgroundColor;
	}

	public String getPlotBorderWidth() {
		return plotBorderWidth;
	}

	public void setPlotBorderWidth(String plotBorderWidth) {
		this.plotBorderWidth = plotBorderWidth;
	}

	public boolean isPlotShadow() {
		return plotShadow;
	}

	public void setPlotShadow(Boolean plotShadow) {
		this.plotShadow = plotShadow;
	}

	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
