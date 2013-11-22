package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IShopCommonService
{

    /**
     * 获取推荐商家列表
     * @param request
     * @return
     */
    public TransData<Object> getRecommendationShopList(HttpServletRequest request);

    /**
     * 获取商家列表
     * @param request
     * @return
     */
    public TransData<Object> getShopList(HttpServletRequest request);

}
