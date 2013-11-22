package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class YDataVo implements Serializable {
	private String name; // 图列名称
	private List<?> data; // 数据
	private Tooltip tooltip;

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<?> getData() {
		return data;
	}
    
	@Override
	public String toString() {
		return BeanUtil.getToString(this,false);
	}
	
}
