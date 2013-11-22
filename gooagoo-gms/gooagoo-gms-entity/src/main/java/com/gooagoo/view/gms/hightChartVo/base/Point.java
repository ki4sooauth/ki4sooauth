package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Point implements Serializable {
	private Events events;
	
	public Point() {
		super();
	}

	public Point(Events events) {
		super();
		this.events = events;
	}

	public Events getEvents() {
		return events;
	}

	public void setEvents(Events events) {
		this.events = events;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
