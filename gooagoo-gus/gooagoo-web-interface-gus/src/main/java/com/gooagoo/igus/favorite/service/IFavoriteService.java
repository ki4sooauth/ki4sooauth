package com.gooagoo.igus.favorite.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IFavoriteService
{

    /**
     * 查询已收藏商品列表
     * @param request
     * @return
     */
    public TransData<Object> getFavoriteGoodsList(HttpServletRequest request);

    /**
     * 查询已收藏活动列表
     * @param request
     * @return
     */
    public TransData<Object> getFavotiteActivityList(HttpServletRequest request);

    /**
     * 查询已收藏优惠凭证列表
     * @param request
     * @return
     */
    public TransData<Object> getFavoriteCouponList(HttpServletRequest request);

    /**
     * 取消收藏
     * @param request
     * @return
     */
    public TransData<Object> deleteFavorite(HttpServletRequest request);
}
