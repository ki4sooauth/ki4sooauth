package com.gooagoo.igms.marketing.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FCoupon;
import com.gooagoo.view.gms.marketing.FCouponGrantInfo;

public interface CouponService
{
    /**
     * 创建优惠凭证
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改优惠凭证
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 审核优惠凭证
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> check(HttpServletRequest request) throws Exception;

    /**
     * 发布优惠凭证
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> release(HttpServletRequest request) throws Exception;

    /**
     * 删除优惠凭证
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 获取优惠凭证信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<FCoupon> getCoupon(HttpServletRequest request) throws Exception;

    /**
     * 分页查询优惠凭证信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FCoupon>> pageCoupon(HttpServletRequest request) throws Exception;

    /**
     * 分页查询优惠凭证号段号码信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FCouponGrantInfo>> pageCouponGrantInfo(HttpServletRequest request) throws Exception;
}
