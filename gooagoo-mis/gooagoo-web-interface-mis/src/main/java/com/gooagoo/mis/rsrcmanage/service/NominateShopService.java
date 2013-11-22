package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MNominateShopBusiness;

public interface NominateShopService
{
    /**
     * 查询所有商品列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateShopBusiness>> queryShopList(HttpServletRequest request) throws Exception;

    /**
     * 推荐商品操作页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateShopPage(HttpServletRequest request) throws Exception;

    /**
     * 推荐商品操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateShop(HttpServletRequest request) throws Exception;

    /**
     * 查询推荐商品列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateShopBusiness>> queryNominateShop(HttpServletRequest request) throws Exception;

    /**
     * 取消推荐商品操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateShop(HttpServletRequest request) throws Exception;

    /**
     * 修改推荐商品页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateShopTPage(HttpServletRequest request) throws Exception;

    /**
     * 修改推荐商品操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateShopT(HttpServletRequest request) throws Exception;

    /**
     * 验证商品是否已推荐
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkNominateShopT(HttpServletRequest request) throws Exception;

}
