package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class StackLabels implements Serializable {
	private Boolean enabled;
	private Style style;
   
	
	public StackLabels() {
		super();
	}

	public StackLabels(Boolean enabled, Style style) {
		super();
		this.enabled = enabled;
		this.style = style;
	}



	public Style getStyle() {
		return style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
    
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
