package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Events implements Serializable {
	private String click;
   
	public Events() {
		super();
	}

	public Events(String click) {
		super();
		this.click = click;
	}

	public String getClick() {
		return click;
	}

	public void setClick(String click) {
		this.click = click;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
