package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Pie implements Serializable {
	private Boolean allowPointSelect;
	private String cursor;
	private Boolean showInLegend;
	private DataLabels dataLabels;

	public Pie() {
		super();
	}
	
	public Pie(Boolean allowPointSelect, String cursor, Boolean showInLegend, DataLabels dataLabels) {
		super();
		this.allowPointSelect = allowPointSelect;
		this.cursor = cursor;
		this.showInLegend = showInLegend;
		this.dataLabels = dataLabels;
	}



	public Boolean isAllowPointSelect() {
		return allowPointSelect;
	}

	public void setAllowPointSelect(Boolean allowPointSelect) {
		this.allowPointSelect = allowPointSelect;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public Boolean isShowInLegend() {
		return showInLegend;
	}

	public void setShowInLegend(Boolean showInLegend) {
		this.showInLegend = showInLegend;
	}

	public DataLabels getDataLabels() {
		return dataLabels;
	}

	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
