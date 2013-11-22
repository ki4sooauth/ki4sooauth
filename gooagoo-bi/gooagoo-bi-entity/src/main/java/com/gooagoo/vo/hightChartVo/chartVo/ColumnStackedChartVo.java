package com.gooagoo.vo.hightChartVo.chartVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.gooagoo.vo.hightChartVo.base.Chart;
import com.gooagoo.vo.hightChartVo.base.Column;
import com.gooagoo.vo.hightChartVo.base.Credits;
import com.gooagoo.vo.hightChartVo.base.DataLabels;
import com.gooagoo.vo.hightChartVo.base.Events;
import com.gooagoo.vo.hightChartVo.base.Exporting;
import com.gooagoo.vo.hightChartVo.base.Legend;
import com.gooagoo.vo.hightChartVo.base.PlotOptions;
import com.gooagoo.vo.hightChartVo.base.Point;
import com.gooagoo.vo.hightChartVo.base.Series;
import com.gooagoo.vo.hightChartVo.base.StackLabels;
import com.gooagoo.vo.hightChartVo.base.Style;
import com.gooagoo.vo.hightChartVo.base.Title;
import com.gooagoo.vo.hightChartVo.base.Tooltip;
import com.gooagoo.vo.hightChartVo.base.XAxis;
import com.gooagoo.vo.hightChartVo.base.YAxis;
import com.gooagoo.vo.hightChartVo.base.YDataVo;
import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class ColumnStackedChartVo implements Serializable {
	private Chart chart;
	private Credits credits;
	private Title title;
	private Exporting exporting;
	private XAxis xAxis;
	private YAxis yAxis;
	private Legend legend;
	private Tooltip tooltip;
	private PlotOptions plotOptions;
	private List<YDataVo> series;
    
	
	
	public ColumnStackedChartVo() {
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

	public Exporting getExporting() {
		return exporting;
	}

	public void setExporting(Exporting exporting) {
		this.exporting = exporting;
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

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
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
	 * @param xName     x轴名称
	 * @param yName y轴名称
	 * @param unit tooltip 单位
	 * @param xData x轴数据
	 * @param dataMap y轴数据
	 * @return
	 */
	public String create(String title, String xName, String yName, String unit, List<?> xData, Map<String, List<?>> dataMap) {
		this.title = new Title(title, null, null);
		this.xAxis = new XAxis(xData, null, null);
		Title title2 = new Title(xName, null, null);
		this.yAxis.setTitle(title2);
		this.tooltip =new Tooltip("function() {return '<b>' + this.x + '</b><br/>'+ this.series.name + ': ' + this.y+ '<br/>' + 'Total: '+ this.point.stackTotal;}", null);
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

	
	private void init(){
		this.chart = new Chart("", null, null, null, "column", null, null, null, null);
		this.credits = new Credits();
		this.exporting = new Exporting();
		Style style = new Style("(Highcharts.theme && Highcharts.theme.textColor)|| 'gray'", null, "bold");
		StackLabels stackLabels = new StackLabels(true,style);
		this.yAxis = new  YAxis(0, null, null, null, null,stackLabels);
		this.legend=new Legend(null, "right", "top", -100, 20, 1, true, " (Highcharts.theme && Highcharts.theme.legendBackgroundColorSolid)|| 'white'", "#CCC", false, null);
		this.plotOptions = new PlotOptions();
		Column column = new Column();
		column.setStacking("normal");
		DataLabels dataLabels = new DataLabels();
		dataLabels.setEnabled(true);
		dataLabels.setColor("(Highcharts.theme && Highcharts.theme.dataLabelsColor)|| 'white'");
		column.setDataLabels(dataLabels);
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
