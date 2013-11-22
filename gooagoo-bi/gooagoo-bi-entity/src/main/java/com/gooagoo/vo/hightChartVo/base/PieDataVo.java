package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class PieDataVo implements Serializable {
	private String type;
	private String name;
	private List<List<Object>> data;
	private Tooltip tooltip;

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<List<Object>> getData() {
		return data;
	}

	public void setData(List<List<Object>> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return BeanUtil.getToString(this,false);
	}
}
