package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class XAxis implements Serializable {
	private List<?> categories;
	private Labels labels;
	private Title title;
     
	
	public XAxis() {
		super();
	}

	public XAxis(List<?> categories, Labels labels, Title title) {
		super();
		this.categories = categories;
		this.labels = labels;
		this.title = title;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Labels getLabels() {
		return labels;
	}

	public void setLabels(Labels labels) {
		this.labels = labels;
	}

	public List<?> getCategories() {
		return categories;
	}

	public void setCategories(List<?> categories) {
		this.categories = categories;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
