package com.gooagoo.view.gms.hightChartVo.base;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

public class PieSelectedData {
	private String name;
	private String y;
	private boolean sliced;
	private boolean selected;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public boolean isSliced() {
		return sliced;
	}

	public void setSliced(boolean sliced) {
		this.sliced = sliced;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
