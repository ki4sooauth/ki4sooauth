package com.gooagoo.igus.coupon.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ICouponService
{

    /**
     * 获取优惠凭证列表
     * @param request
     * @return
     */
    public TransData<Object> getCouponList(HttpServletRequest request);


    /**
     * 收藏优惠凭证
     * @param request
     * @return
     */
    public TransData<Object> favoriteCoupon(HttpServletRequest request);

}
