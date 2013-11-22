package com.gooagoo.igus.merchant.web.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IWebMerchantService
{

    /**
     * 获取网站端活动展示需要的数据
     * @param request
     * @return
     */
    public TransData<Object> getActiveData(HttpServletRequest request);

    /**
     * 处理网站端收藏活动
     * @param request
     * @return
     */
    public TransData<Object> favoriteActive(HttpServletRequest request);

    /**
     * 获取网站端优惠凭证展示需要的数据
     * @param request
     * @return
     */
    public TransData<Object> getCouponData(HttpServletRequest request);

    /**
     * 处理网站端收藏优惠凭证
     * @param request
     * @return
     */
    public TransData<Object> favoriteCoupon(HttpServletRequest request);

    /**
     * 获取网站端商品展示需要的基本数据
     * @param request
     * @return
     */
    public TransData<Object> getGoodsData(HttpServletRequest request);

    /**
     * 获取网站端商品评论列表
     * @param request
     * @return
     */
    public TransData<Object> getGoodsCommentList(HttpServletRequest request);

    /**
     * 处理网站端收藏商品
     * @param request
     * @return
     */
    public TransData<Object> favoriteGoods(HttpServletRequest request);

    /**
     * 处理网站端商品加入购物清单
     * @param request
     * @return
     */
    public TransData<Object> addToShoppinglist(HttpServletRequest request);

    /**
     *查询用户收获地址列表
     * @param request
     * @return
     */
    public TransData<Object> getShippingAddressList(HttpServletRequest request);

    /**
     * 处理网站端积分兑换
     * @param request
     * @return
     */
    public TransData<Object> integralConvert(HttpServletRequest request);
}
