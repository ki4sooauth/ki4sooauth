package com.gooagoo.igus.merchant.mobile.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IMobileMerchantService
{

    /**
     * 获取手机端活动展示需要的数据
     * @param requestrequest
     * @return
     */
    public TransData<Object> getActiveData(HttpServletRequest request);

    /**
     * 处理手机端收藏活动
     * @param request
     * @return
     */
    public TransData<Object> favoriteActive(HttpServletRequest request);

    /**
     * 获取手机端优惠凭证展示需要的数据
     * @param request
     * @return
     */
    public TransData<Object> getCouponData(HttpServletRequest request);

    /**
     * 处理手机端收藏优惠凭证
     * @param request
     * @return
     */
    public TransData<Object> favoriteCoupon(HttpServletRequest request);

    /**
     * 获取手机端商品展示需要的数据
     * @param request
     * @return
     */
    public TransData<Object> getGoodsData(HttpServletRequest request);

    /**
     * 获取手机端商品评论列表
     * @param request
     * @return
     */
    public TransData<Object> getGoodsCommentList(HttpServletRequest request);

    /**
     * 处理手机端收藏商品
     * @param request
     * @return
     */
    public TransData<Object> favoriteGoods(HttpServletRequest request);

    /**
     * 获取手机端积分商城展示需要的数据
     * @param request
     * @return
     */
    public TransData<Object> getIntegralMallData(HttpServletRequest request);

    /**
     * 处理手机端积分兑换
     * @param request
     * @return
     */
    public TransData<Object> integralConvert(HttpServletRequest request);

    /**
     * 获取手机端区域商品销量排行
     * @param request
     * @return
     */
    public TransData<Object> getPositionMarketingRank(HttpServletRequest request);

    /**
     * 获取手机端的收货人信息（得到地址）
     * @param request
     * @return
     */
    public TransData<Object> getConsigneeInfo(HttpServletRequest request);

}
