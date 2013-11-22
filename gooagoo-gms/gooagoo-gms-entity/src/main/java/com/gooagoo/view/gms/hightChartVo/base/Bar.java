package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Bar implements Serializable {
	private DataLabels dataLabels;

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
