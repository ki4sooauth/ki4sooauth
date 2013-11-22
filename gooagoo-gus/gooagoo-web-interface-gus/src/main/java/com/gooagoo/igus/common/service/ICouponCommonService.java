package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ICouponCommonService
{

    /**
     * 猜您喜欢
     * @param request
     * @return
     */
    public TransData<Object> getGuessLiskCouponList(HttpServletRequest request);

    /**
     * 推荐优惠凭证列表
     * @param request
     * @return
     */
    public TransData<Object> getRecommendationCouponList(HttpServletRequest request);

}
