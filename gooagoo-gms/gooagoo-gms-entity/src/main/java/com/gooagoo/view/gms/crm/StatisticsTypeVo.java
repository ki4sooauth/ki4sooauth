package com.gooagoo.view.gms.crm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StatisticsTypeVo implements Serializable {
	private String codeType; //编码类型（自定义：C，系统自带:O）
	private String code; // 统计类编码 
	private String name; // 统计类型名称
     
	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
