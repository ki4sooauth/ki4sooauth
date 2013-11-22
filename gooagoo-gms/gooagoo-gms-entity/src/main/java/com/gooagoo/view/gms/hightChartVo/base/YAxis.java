package com.gooagoo.view.gms.hightChartVo.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class YAxis implements Serializable {
	private Integer min;
	private Boolean allowDecimals;
	private Title title;
	private List<PlotLines> plotLines = new ArrayList<PlotLines>();
	private Labels labels;
	private StackLabels stackLabels;
    
	public YAxis() {
	}
	
	public YAxis(Integer min, Boolean allowDecimals, Title title, List<PlotLines> plotLines, Labels labels, StackLabels stackLabels) {
		super();
		this.min = min;
		this.allowDecimals = allowDecimals;
		this.title = title;
		this.plotLines = plotLines;
		this.labels = labels;
		this.stackLabels = stackLabels;
	}




	public StackLabels getStackLabels() {
		return stackLabels;
	}

	public void setStackLabels(StackLabels stackLabels) {
		this.stackLabels = stackLabels;
	}

	public Boolean getAllowDecimals() {
		return allowDecimals;
	}

	public Labels getLabels() {
		return labels;
	}

	public void setLabels(Labels labels) {
		this.labels = labels;
	}

	public Boolean isAllowDecimals() {
		return allowDecimals;
	}

	public void setAllowDecimals(Boolean allowDecimals) {
		this.allowDecimals = allowDecimals;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public List<PlotLines> getPlotLines() {
		return plotLines;
	}

	public void setPlotLines(List<PlotLines> plotLines) {
		this.plotLines = plotLines;
	}
    
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
	
}
