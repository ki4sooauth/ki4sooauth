package com.gooagoo.entity.cache;

import java.io.Serializable;

public class ActivityCache implements Serializable {
	private static final long serialVersionUID = 1L;
	private String _id; // 活动内容id(mongodb键值)
	private String contentType;// 活动内容类型

	public void setId(String id) {
		this._id = id;
	}

	public String getId() {
		return _id;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
