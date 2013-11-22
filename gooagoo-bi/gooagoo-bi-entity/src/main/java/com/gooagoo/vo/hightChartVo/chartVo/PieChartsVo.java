package com.gooagoo.vo.hightChartVo.chartVo;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.vo.hightChartVo.base.Chart;
import com.gooagoo.vo.hightChartVo.base.Credits;
import com.gooagoo.vo.hightChartVo.base.DataLabels;
import com.gooagoo.vo.hightChartVo.base.Events;
import com.gooagoo.vo.hightChartVo.base.Pie;
import com.gooagoo.vo.hightChartVo.base.PieDataVo;
import com.gooagoo.vo.hightChartVo.base.PlotOptions;
import com.gooagoo.vo.hightChartVo.base.Point;
import com.gooagoo.vo.hightChartVo.base.Series;
import com.gooagoo.vo.hightChartVo.base.Title;
import com.gooagoo.vo.hightChartVo.base.Tooltip;
import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

public class PieChartsVo {
	private Chart chart;
	private Credits credits;
	private Title title;
	private Tooltip tooltip;
	private PlotOptions plotOptions;
	private List<PieDataVo> series;
    
	public PieChartsVo() {
		super();
		this.init();
	}

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public PlotOptions getPlotOptions() {
		return plotOptions;
	}

	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}

	public List<PieDataVo> getSeries() {
		return series;
	}

	public void setSeries(List<PieDataVo> series) {
		this.series = series;
	}
    
	public String create(String title, String pieName, String unit, List<List<Object>> data) {
		this.title = new Title(title,null, null);
		this.tooltip =new Tooltip();
		tooltip.setPointFormat("{series.name}: <b>{point.percentage}%</b>");
		tooltip.setPercentageDecimals("0.00");
		this.series = new ArrayList<PieDataVo>();
		PieDataVo pieDataVo= new PieDataVo();
		pieDataVo.setType("pie");
		pieDataVo.setName(pieName);
		pieDataVo.setData(data);
		series.add(pieDataVo);
		return this.toString();
	}
	
	private void init(){
		this.chart = new Chart("", null, null, false, null, null, null, null, null);
		this.credits = new Credits();
		this.plotOptions  = new PlotOptions();
		DataLabels dataLabels = new DataLabels();
		dataLabels.setEnabled(true);
		dataLabels.setFormatter("function() {this.point.percentage = Highcharts.numberFormat(this.point.percentage, 2)}");
		Pie pie = new Pie(true, "pointer", true, dataLabels);
		plotOptions.setPie(pie);
		Events events = new Events("function() {getList(this);}");
		Point point = new Point(events);
		Series series = new Series("pointer", point);
		plotOptions.setSeries(series);
	}
	
	@Override
	public String toString() {
		return BeanUtil.getToString(this, false);
	}

}
