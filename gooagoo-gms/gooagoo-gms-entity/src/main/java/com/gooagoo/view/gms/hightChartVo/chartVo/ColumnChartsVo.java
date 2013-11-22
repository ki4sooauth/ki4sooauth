package com.gooagoo.view.gms.hightChartVo.chartVo;

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

public class ColumnChartsVo {
	private Chart chart;
	private Credits credits;
	private Title title;
	private Subtitle subtitle;
	private XAxis xAxis;
	private YAxis yAxis;
	private Tooltip tooltip;
	private Exporting exporting;
	private Legend legend;
	private PlotOptions plotOptions;
	private List<YDataVo> series;

	public ColumnChartsVo() {
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

	public Exporting getExporting() {
		return exporting;
	}

	public void setExporting(Exporting exporting) {
		this.exporting = exporting;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public PlotOptions getPlotOptions() {
		return plotOptions;
	}

	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
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
	 * @param xName
	 *            x轴名称
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
	public String create(String title, String xName, String yName, String unit, List<?> xData, Map<String, List<?>> dataMap,boolean isDisplayLegend) {
		this.title = new Title(title, null, null);
		Title t = new Title(xName, null, null);
		this.xAxis = new XAxis(xData, null, t);
		Title title2 = new Title(yName, null, null);
		this.yAxis.setTitle(title2);
		this.legend.setEnabled(isDisplayLegend);
		this.tooltip = new Tooltip("<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td><td style=\"padding:0\"><b>{point.y}"+unit+"</b></td></tr>", null, null,"<span style=\"font-size:10px\">{point.key}</span><table>", "</table>", true, true, null, null);
		this.series = new ArrayList<YDataVo>();
		YDataVo yDataVo = null;
		Set<Entry<String, List<?>>> entrySet = dataMap.entrySet();
		for (Entry<String, List<?>> entry : entrySet) {
			yDataVo = new YDataVo();
			yDataVo.setName(entry.getKey());
			yDataVo.setData(entry.getValue());
			this.series.add(yDataVo);
		}
		return this.toString();
	}

	public void init() {
		this.chart = new Chart("", null, null, null, "column", null, null, null, null);
		this.yAxis = new YAxis(0, false, null, null, null, null);
		this.credits = new Credits();
		this.legend = new Legend(null, null, null, null, null, null, null, null, null, null, false);
		this.exporting = new Exporting();
		this.plotOptions = new PlotOptions();
		Column column = new Column();
		column.setPointPadding(0.2F);
		column.setBorderWidth(0);
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
