package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MNominateGoodsBusiness;

public interface NominateGoodsService
{
    /**
     * 查询所有商家的商品列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateGoodsBusiness>> queryGoodsList(HttpServletRequest request) throws Exception;

    /**
     * 推荐商品页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateGoodsPage(HttpServletRequest request) throws Exception;
    
    /**
     * 推荐商品操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addNominateGoods(HttpServletRequest request) throws Exception;

    /**
     * 查询推荐商品列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MNominateGoodsBusiness>> queryNominateGoods(HttpServletRequest request) throws Exception;

    /**
     * 取消推荐商品操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateGoods(HttpServletRequest request) throws Exception;

    /**
     * 修改推荐商品页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateGoodsTPage(HttpServletRequest request) throws Exception;
    
    /**
     * 修改推荐商品操作
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateNominateGoodsT(HttpServletRequest request) throws Exception;
    
    /**
     * 验证商品是否已推荐
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkNominateGoodsT(HttpServletRequest request) throws Exception;
    
}
