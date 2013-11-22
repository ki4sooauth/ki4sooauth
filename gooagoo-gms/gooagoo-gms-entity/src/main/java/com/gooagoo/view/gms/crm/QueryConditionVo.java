package com.gooagoo.view.gms.crm;

import java.io.Serializable;

public class QueryConditionVo implements Serializable {
	private static final long serialVersionUID = -6502725503140464630L;
	private String queryId;
	private String queryName;
	private String queryDesc;

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryDesc() {
		return queryDesc;
	}

	public void setQueryDesc(String queryDesc) {
		this.queryDesc = queryDesc;
	}

}
