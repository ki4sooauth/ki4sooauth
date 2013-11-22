package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Series implements Serializable {
	private String cursor;

	private Point point;
    
	public Series() {
		super();
	}

	public Series(String cursor, Point point) {
		super();
		this.cursor = cursor;
		this.point = point;
	}

	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
