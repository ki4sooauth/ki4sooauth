package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IGoodsCommonService
{

    /**
     * 热卖商品列表
     * @param request
     * @return
     */
    public TransData<Object> getHotSaleGoodsList(HttpServletRequest request);

    /**
     * 热评商品列表
     * @param request
     * @return
     */
    public TransData<Object> getHotCommentGoodsList(HttpServletRequest request);

    /**
     * 最新商品列表
     * @param request
     * @return
     */
    public TransData<Object> getNewestGoodsList(HttpServletRequest request);

    /**
     * 猜您喜欢
     * @param request
     * @return
     */
    public TransData<Object> getGuessLiskGoodsList(HttpServletRequest request);

    /**
     * 推荐商品列表
     * @param request
     * @return
     */
    public TransData<Object> getRecommendationGoodsList(HttpServletRequest request);

}
