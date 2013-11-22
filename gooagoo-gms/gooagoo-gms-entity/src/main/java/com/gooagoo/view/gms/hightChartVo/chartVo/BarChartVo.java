package com.gooagoo.view.gms.hightChartVo.chartVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.gooagoo.view.gms.hightChartVo.base.Bar;
import com.gooagoo.view.gms.hightChartVo.base.Chart;
import com.gooagoo.view.gms.hightChartVo.base.Column;
import com.gooagoo.view.gms.hightChartVo.base.Credits;
import com.gooagoo.view.gms.hightChartVo.base.DataLabels;
import com.gooagoo.view.gms.hightChartVo.base.Events;
import com.gooagoo.view.gms.hightChartVo.base.Exporting;
import com.gooagoo.view.gms.hightChartVo.base.Labels;
import com.gooagoo.view.gms.hightChartVo.base.Legend;
import com.gooagoo.view.gms.hightChartVo.base.PlotOptions;
import com.gooagoo.view.gms.hightChartVo.base.Point;
import com.gooagoo.view.gms.hightChartVo.base.Series;
import com.gooagoo.view.gms.hightChartVo.base.Subtitle;
import com.gooagoo.view.gms.hightChartVo.base.Title;
import com.gooagoo.view.gms.hightChartVo.base.Tooltip;
import com.gooagoo.view.gms.hightChartVo.base.XAxis;
import com.gooagoo.view.gms.hightChartVo.base.YAxis;
import com.gooagoo.view.gms.hightChartVo.base.YDataVo;
import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class BarChartVo implements Serializable {
	private Chart chart;
	private Title title;
	private Subtitle subtitle;
	private XAxis xAxis;
	private YAxis yAxis;
	private Tooltip tooltip;
	private PlotOptions plotOptions;
	private Legend legend;
	private Credits credits;
	private Exporting exporting;
	private List<YDataVo> series;

	public BarChartVo() {
		init();
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

	public PlotOptions getPlotOptions() {
		return plotOptions;
	}

	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public Credits getCredits() {
		return credits;
	}

	public void setCredits(Credits credits) {
		this.credits = credits;
	}

	public Exporting getExporting() {
		return exporting;
	}

	public void setExporting(Exporting exporting) {
		this.exporting = exporting;
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
	 * @param title
	 *            图标题
	 * @param yName
	 *            y轴名称
	 * @param unit
	 *            tooltip 单位
	 * @param xData
	 *            x轴数据
	 * @param dataMap
	 *            y轴数据
	 * @return
	 */
	public String create(String title, String yName, String unit, List<?> xData, Map<String, List<?>> dataMap) {
		this.title = new Title(title, null, null);
		this.xAxis = new XAxis(xData, null, null);
		this.yAxis.getTitle().setText(yName);
		this.tooltip = new Tooltip("function() {return '<b>' + this.x + '</b><br/>'+this.series.name+'' + this.y+'" + unit + "';}", unit);
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
		this.chart = new Chart(null, null, null, null, "bar", null, null, null, null);
		Title title = new Title(null, null, "high");
		Labels l = new Labels();
		l.setOverflow("justify");
		this.yAxis = new YAxis(0, null, title, null, l, null);
		this.plotOptions = new PlotOptions();
		Column column = new Column();
		column.setPointPadding(0.2F);
		column.setBorderWidth(0);
		plotOptions.setColumn(column);
		Events events = new Events("function() {getList(this);}");
		Point point = new Point(events);
		Series series = new Series("pointer", point);
		plotOptions.setSeries(series);
		Bar bar = new Bar();
		DataLabels labels = new DataLabels();
		labels.setEnabled(true);
		bar.setDataLabels(labels);
		this.plotOptions.setBar(bar);
		this.legend = new Legend("vertical", "right", "top", -100, 100, 1, true, "#FFFFFF", null, true, null);
		this.credits = new Credits();
		this.exporting = new Exporting();
	}

	@Override
	public String toString() {
		return BeanUtil.getToString(this, false);
	}

}
