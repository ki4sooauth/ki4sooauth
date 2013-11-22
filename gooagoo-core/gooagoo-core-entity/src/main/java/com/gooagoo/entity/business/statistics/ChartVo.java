package com.gooagoo.entity.business.statistics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class ChartVo implements Serializable {
	private List<String> xData = new ArrayList<String>(); // x轴数据

	private Map<String, List<Long>> yData = new HashMap<String, List<Long>>(); // y轴数据
																				// map的key为图例名称

	public List<String> getxData() {
		return xData;
	}

	public void setxData(List<String> xData) {
		this.xData = xData;
	}

	public Map<String, List<Long>> getyData() {
		return yData;
	}

	public void setyData(Map<String, List<Long>> yData) {
		this.yData = yData;
	}

}
