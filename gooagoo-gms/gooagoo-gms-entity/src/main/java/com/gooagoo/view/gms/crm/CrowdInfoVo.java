package com.gooagoo.view.gms.crm;

import java.io.Serializable;

public class CrowdInfoVo implements Serializable{
	private static final long serialVersionUID = -5839704822236287357L;
	
	private String crowdId;  //用户群Id
	private String crowdName; //用户群名称
	private String crowdDesc;//用户群描述
	public String getCrowdId() {
		return crowdId;
	}
	public void setCrowdId(String crowdId) {
		this.crowdId = crowdId;
	}
	public String getCrowdName() {
		return crowdName;
	}
	public void setCrowdName(String crowdName) {
		this.crowdName = crowdName;
	}
	public String getCrowdDesc() {
		return crowdDesc;
	}
	public void setCrowdDesc(String crowdDesc) {
		this.crowdDesc = crowdDesc;
	}
	
	
	

}
