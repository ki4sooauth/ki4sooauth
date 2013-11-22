package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IActiveCommonService
{

	/**
     * 猜您喜欢
     * @param request
     * @return
     */
    public TransData<Object> getGuessLiskActiveList(HttpServletRequest request);
    
    /**
     * 推荐活动列表
     * @param request
     * @return
     */
    public TransData<Object> getRecommendationActivityList(HttpServletRequest request);
}
