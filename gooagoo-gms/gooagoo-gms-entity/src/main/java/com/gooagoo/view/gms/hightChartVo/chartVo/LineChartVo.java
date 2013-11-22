package com.gooagoo.view.gms.hightChartVo.chartVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.gooagoo.view.gms.hightChartVo.base.Chart;
import com.gooagoo.view.gms.hightChartVo.base.Column;
import com.gooagoo.view.gms.hightChartVo.base.Credits;
import com.gooagoo.view.gms.hightChartVo.base.Events;
import com.gooagoo.view.gms.hightChartVo.base.Exporting;
import com.gooagoo.view.gms.hightChartVo.base.Labels;
import com.gooagoo.view.gms.hightChartVo.base.Legend;
import com.gooagoo.view.gms.hightChartVo.base.PlotLines;
import com.gooagoo.view.gms.hightChartVo.base.PlotOptions;
import com.gooagoo.view.gms.hightChartVo.base.Point;
import com.gooagoo.view.gms.hightChartVo.base.Series;
import com.gooagoo.view.gms.hightChartVo.base.Style;
import com.gooagoo.view.gms.hightChartVo.base.Subtitle;
import com.gooagoo.view.gms.hightChartVo.base.Title;
import com.gooagoo.view.gms.hightChartVo.base.Tooltip;
import com.gooagoo.view.gms.hightChartVo.base.XAxis;
import com.gooagoo.view.gms.hightChartVo.base.YAxis;
import com.gooagoo.view.gms.hightChartVo.base.YDataVo;
import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class LineChartVo implements Serializable {
	private Chart chart;
	private Title title;
	private Credits credits;
	private PlotOptions plotOptions;
	private Exporting exporting;
	private Subtitle subtitle;
	private XAxis xAxis;
	private YAxis yAxis;
	private Tooltip tooltip;
	private Legend legend;
	private List<YDataVo> series;

	public LineChartVo() {
		super();
		this.init();
	}

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	public PlotOptions getPlotOptions() {
		return plotOptions;
	}

	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}

	public Exporting getExporting() {
		return exporting;
	}

	public void setExporting(Exporting exporting) {
		this.exporting = exporting;
	}

	public Subtitle getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(Subtitle subtitle) {
		this.subtitle = subtitle;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public YAxis getyAxis() {
		return yAxis;
	}

	public void setyAxis(YAxis yAxis) {
		this.yAxis = yAxis;
	}

	public Tooltip getTooltip() {
		return tooltip;
	}

	public void setTooltip(Tooltip tooltip) {
		this.tooltip = tooltip;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public List<YDataVo> getSeries() {
		return series;
	}

	public void setSeries(List<YDataVo> series) {
		this.series = series;
	}
   
	/**
	 * 生成图字符串方法
	 * 
	 * @param title  图标题
	 * @param yName y轴名称
	 * @param unit tooltip 单位
	 * @param xData x轴数据
	 * @param dataMap y轴数据
	 * @return
	 */
	public String create(String title, String yName, String unit, List<?> xData, Map<String, List<?>> dataMap) {
		this.title.setText(title);
		this.xAxis.setCategories(xData);
		Title title2 = new Title(yName, null, null);
		this.yAxis.setTitle(title2);
		this.tooltip =new Tooltip("function() {return '<b>' +this.x + '</b><br/>' + this.series.name + ': '+this.y+'"+unit+"';}", null);
		this.series = new ArrayList<YDataVo>();
		YDataVo yDataVo = null;
		Set<Entry<String, List<?>>> entrySet = dataMap.entrySet();
		for (Entry<String, List<?>> entry : entrySet) {
			yDataVo = new YDataVo();
			yDataVo.setName(entry.getKey());
			yDataVo.setData(entry.getValue());
			series.add(yDataVo);
		}
		return this.toString();
	}
	
	
	private void init() {
		this.chart = new Chart("container", null, null, null, "line", 300, 750, 130, 25);
		this.title = new Title(null, -20, null);
		this.credits = new Credits();
		this.plotOptions = new PlotOptions();
		Column column = new Column();
		column.setPointPadding(0.2F);
		column.setBorderWidth(0);
		plotOptions.setColumn(column);
		this.exporting = new Exporting();
		this.xAxis = new XAxis();
		Labels labels = new Labels();
		labels.setRotation(15);
		labels.setY(20);
		Style style = new Style();
		style.setColor("#3E576F");
		style.setFont("italic");
		labels.setStyle(style);
		xAxis.setLabels(labels);
		List<PlotLines> plotLines = new ArrayList<PlotLines>();
		PlotLines lines = new PlotLines(0, 1, "#808080");
		plotLines.add(lines);
		this.yAxis = new YAxis(0, false, null, plotLines, null, null);
		this.legend = new Legend("vertical", "right", "top", -10, 100, 0, null, null, null, null, null);
		plotOptions.setColumn(column);
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
