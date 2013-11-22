package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class PlotOptions implements Serializable {
	private Pie pie;
	private Column column;
	private Series series;
	private Bar bar;

	public Bar getBar() {
		return bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Series getSeries() {
		return series;
	}

	public void setSeries(Series series) {
		this.series = series;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public Pie getPie() {
		return pie;
	}

	public void setPie(Pie pie) {
		this.pie = pie;
	}
    
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
