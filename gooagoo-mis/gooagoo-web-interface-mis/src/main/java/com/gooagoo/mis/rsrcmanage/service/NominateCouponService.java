package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MNominateCouponBusiness;

public interface NominateCouponService
{
    /**
     * 查询所有优惠凭证列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateCouponBusiness>> queryCouponList(HttpServletRequest request) throws Exception;

    /**
     * 推荐优惠凭证操作页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateCouponPage(HttpServletRequest request) throws Exception;

    /**
     * 推荐优惠凭证操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateCoupon(HttpServletRequest request) throws Exception;

    /**
     * 查询推荐优惠凭证列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateCouponBusiness>> queryNominateCoupon(HttpServletRequest request) throws Exception;

    /**
     * 取消推荐优惠凭证操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateCoupon(HttpServletRequest request) throws Exception;

    /**
     * 修改推荐优惠凭证页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateCouponTPage(HttpServletRequest request) throws Exception;

    /**
     * 修改推荐优惠凭证操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateCouponT(HttpServletRequest request) throws Exception;

    /**
     * 验证优惠凭证是否已推荐
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkNominateCouponT(HttpServletRequest request) throws Exception;

}
