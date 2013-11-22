package com.gooagoo.vo.hightChartVo.base;

import java.io.Serializable;

import com.gooagoo.vo.hightChartVo.beanUtil.BeanUtil;

@SuppressWarnings("serial")
public class Tooltip implements Serializable {
	private String pointFormat;
	private String percentageDecimals;
	private String formatter;
	private String headerFormat;
	private String footerFormat;
	private Boolean shared;
	private Boolean useHTML;
	private Integer valueDecimals;
	private String valueSuffix;
       
	public Tooltip(){
		
	}
	

	public Tooltip(String formatter, String valueSuffix) {
		super();
		this.formatter = formatter;
		this.valueSuffix = valueSuffix;
	}

	public Tooltip(String pointFormat, String percentageDecimals, String formatter, String headerFormat, String footerFormat, Boolean shared, Boolean useHTML, Integer valueDecimals, String valueSuffix) {
		super();
		this.pointFormat = pointFormat;
		this.percentageDecimals = percentageDecimals;
		this.formatter = formatter;
		this.headerFormat = headerFormat;
		this.footerFormat = footerFormat;
		this.shared = shared;
		this.useHTML = useHTML;
		this.valueDecimals = valueDecimals;
		this.valueSuffix = valueSuffix;
	}


	public String getValueSuffix() {
		return valueSuffix;
	}

	public void setValueSuffix(String valueSuffix) {
		this.valueSuffix = valueSuffix;
	}

	public Integer getValueDecimals() {
		return valueDecimals;
	}

	public void setValueDecimals(Integer valueDecimals) {
		this.valueDecimals = valueDecimals;
	}

	public String getHeaderFormat() {
		return headerFormat;
	}

	public void setHeaderFormat(String headerFormat) {
		this.headerFormat = headerFormat;
	}

	public String getFooterFormat() {
		return footerFormat;
	}

	public void setFooterFormat(String footerFormat) {
		this.footerFormat = footerFormat;
	}

	public Boolean isShared() {
		return shared;
	}

	public void setShared(Boolean shared) {
		this.shared = shared;
	}

	public Boolean isUseHTML() {
		return useHTML;
	}

	public void setUseHTML(Boolean useHTML) {
		this.useHTML = useHTML;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public String getPointFormat() {
		return pointFormat;
	}

	public void setPointFormat(String pointFormat) {
		this.pointFormat = pointFormat;
	}

	public String getPercentageDecimals() {
		return percentageDecimals;
	}

	public void setPercentageDecimals(String percentageDecimals) {
		this.percentageDecimals = percentageDecimals;
	}
   
	@Override
	public String toString() {
		return BeanUtil.getToString(this,true);
	}
}
