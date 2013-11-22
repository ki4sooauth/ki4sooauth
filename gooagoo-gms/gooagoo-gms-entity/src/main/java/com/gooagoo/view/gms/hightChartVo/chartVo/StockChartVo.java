package com.gooagoo.view.gms.hightChartVo.chartVo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.gooagoo.view.gms.hightChartVo.base.Column;
import com.gooagoo.view.gms.hightChartVo.base.Credits;
import com.gooagoo.view.gms.hightChartVo.base.Events;
import com.gooagoo.view.gms.hightChartVo.base.Exporting;
import com.gooagoo.view.gms.hightChartVo.base.Legend;
import com.gooagoo.view.gms.hightChartVo.base.PieDataVo;
import com.gooagoo.view.gms.hightChartVo.base.PlotOptions;
import com.gooagoo.view.gms.hightChartVo.base.Point;
import com.gooagoo.view.gms.hightChartVo.base.RangeSelector;
import com.gooagoo.view.gms.hightChartVo.base.Series;
import com.gooagoo.view.gms.hightChartVo.base.Title;
import com.gooagoo.view.gms.hightChartVo.base.Tooltip;
import com.gooagoo.view.gms.hightChartVo.beanUtil.BeanUtil;

/**
 * 创建x轴数据可拖拽的折线图
 * 
 * @author admin
 * 
 */
@SuppressWarnings("serial")
public class StockChartVo implements Serializable {
	private RangeSelector rangeSelector;
	private Title title;
	private Credits credits;
	private PlotOptions plotOptions;
	private Exporting exporting;
	private Legend legend;
	private List<PieDataVo> series;

	public StockChartVo() {
		super();
		this.init();
	}

	public RangeSelector getRangeSelector() {
		return rangeSelector;
	}

	public void setRangeSelector(RangeSelector rangeSelector) {
		this.rangeSelector = rangeSelector;
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

	public List<PieDataVo> getSeries() {
		return series;
	}

	public void setSeries(List<PieDataVo> series) {
		this.series = series;
	}
    
	
	public String create(String title, Map<String,List<List<Object>>> dataMap) {
		this.title= new Title(title, null, null);
		this.series = new ArrayList<PieDataVo>();
		PieDataVo pieDataVo = null;
		Tooltip tooltip = new Tooltip();
		tooltip.setValueDecimals(0);
		Set<Entry<String, List<List<Object>>>> entrySet = dataMap.entrySet();
		for (Entry<String, List<List<Object>>> entry : entrySet) {
			pieDataVo = new PieDataVo();
			pieDataVo.setName(entry.getKey());
			pieDataVo.setData(entry.getValue());
			pieDataVo.setTooltip(tooltip);
			series.add(pieDataVo);
		}
		return this.toString();
	}
	
	
	private void init() {
		this.rangeSelector = new RangeSelector(1);
		this.credits = new Credits();
		this.plotOptions = new PlotOptions();
		Column column = new Column();
		column.setPointPadding(0.2F);
		column.setBorderWidth(0);
		plotOptions.setColumn(column);
		Events events = new Events("function() {getList(this);}");
		Point point = new Point(events);
		Series series = new Series("pointer", point);
		plotOptions.setSeries(series);
		this.legend=new Legend();
		legend.setEnabled(true);
		this.exporting = new Exporting();
	}

	@Override
	public String toString() {
		return BeanUtil.getToString(this, false);
	}
}
