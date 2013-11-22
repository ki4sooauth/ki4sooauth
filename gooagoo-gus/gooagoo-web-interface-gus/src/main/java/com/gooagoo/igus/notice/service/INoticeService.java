package com.gooagoo.igus.notice.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;


public interface INoticeService
{
    /**
     * 获取通知列表
     * @param request
     * @return
     */
    public TransData<Object> getNoticeList(HttpServletRequest request);

    /**
     *  删除通知
     * @param request
     * @return
     */
    public TransData<Object> deleteNotice(HttpServletRequest request);


    /**
     * 收藏活动
     * @param request
     * @return
     */
    public TransData<Object> favoriteActive(HttpServletRequest request);

    /**
     * 收藏商品
     * @param request
     * @return
     */
    public TransData<Object> favoriteGoods(HttpServletRequest request);

    /**
     * 收藏优惠凭证
     * @param request
     * @return
     */
    public TransData<Object> favoriteCoupon(HttpServletRequest request);

    /**
     * 加入购物清单
     * @param request
     * @return
     */
    public TransData<Object> addToShoppinglist(HttpServletRequest request);

}
