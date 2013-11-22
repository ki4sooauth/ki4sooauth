package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class RangeSelector implements Serializable {
	private Integer selected;
   
	public RangeSelector(Integer selected) {
		super();
		this.selected = selected;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
