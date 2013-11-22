package com.gooagoo.igms.resource.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.resource.AdBidInfoView;
import com.gooagoo.view.gms.resource.AdView;

public interface AuctionService {
	/**
	 * 广告位竞拍
	 * 
	 * @param request
	 * @return
	 * @throws Exception 
	 */
	public TransData<Object> auction(HttpServletRequest request) throws Exception;

	/**
	 * 查询所有广告位信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TransData<List<AdView>> findAllAd(HttpServletRequest request) throws Exception;

	/**
	 * 获取广告位况拍信息
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public TransData<List<AdBidInfoView>> getAdBidInfo(HttpServletRequest request) throws Exception;

}
