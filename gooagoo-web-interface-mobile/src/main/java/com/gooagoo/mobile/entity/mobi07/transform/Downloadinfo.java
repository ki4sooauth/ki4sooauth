package com.gooagoo.mobile.entity.mobi07.transform;

import java.io.Serializable;

/**
 *  下载地图信息 
 */
public class Downloadinfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	/**  地圖壓縮包下載地址  */
	private String downloadurl = "";

	/**
	 * 设置 地圖壓縮包下載地址 
	 * @param downloadurl	 地圖壓縮包下載地址 
	 */
	public void setDownloadurl(String downloadurl)
	{
		this.downloadurl = downloadurl != null ? downloadurl : "";
	}

	/**
	 * 获取 地圖壓縮包下載地址 
	 * @return	 地圖壓縮包下載地址 
	 */
	public String getDownloadurl()
	{
		return this.downloadurl;
	}
}