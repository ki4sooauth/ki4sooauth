package com.gooagoo.igus.favorite.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;


public interface IMeritFavoriteService
{
    /**
     * 查询值得收藏商品列表
     * @param request
     * @return
     */
    public TransData<Object> getMeritFavoriteGoodsList(HttpServletRequest request);

    /**
     * 查询值得收藏活动列表
     * @param request
     * @return
     */
    public TransData<Object> getMeritFavoriteActivityList(HttpServletRequest request);

    /**
     *查询值得收藏优惠凭证列表
     * @param request
     * @return
     */
    public TransData<Object> getMeritfavoriteCouponList(HttpServletRequest request);

    /**
     * 收藏商品
     * @param request
     * @return
     */
    public TransData<Object> favoriteGoods(HttpServletRequest request);

    /**
     * 收藏活动
     * @param request
     * @return
     */
    public TransData<Object> favoriteActivity(HttpServletRequest request);

    /**
     * 收藏优惠凭证
     * @param request
     * @return
     */
    public TransData<Object> favoriteCoupon(HttpServletRequest request);

}
