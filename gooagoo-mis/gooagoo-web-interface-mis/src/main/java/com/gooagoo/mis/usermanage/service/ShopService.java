package com.gooagoo.mis.usermanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopEntityInfo;
import com.gooagoo.view.mis.enterprise.MShopInfo;
import com.gooagoo.view.mis.enterprise.MShopLidInfo;

public interface ShopService
{

    /**
     * 查询所有商家信息(分页)
     * @param basicInfoRequest
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MShopInfo>> searchShopList(HttpServletRequest request) throws Exception;

    /**
     * 查询所有商家信息
     * @param basicInfoRequest
     * @return
     * @throws Exception
     */
    public TransData<List<MShopInfo>> searchShopListNo(HttpServletRequest request) throws Exception;

    
    /**
     * 审核商家
     * @param shopIds
     * @return
     * @throws Exception
     */
    public TransData<Object> verify(HttpServletRequest request) throws Exception;

    /**
     * 审核商家（未通过）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> notApproved(HttpServletRequest request) throws Exception;

    /**
     * 锁定商家
     * @param shopIds
     * @return
     * @throws Exception
     */
    public TransData<Object> lock(HttpServletRequest request) throws Exception;

    /**
     * 查询商家Lid信息
     * @param shopId
     * @return
     * @throws Exception
     * @throws Exception 
     */
    public TransData<PageModel<MShopLidInfo>> searchLidInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除商家Lid信息
     * @param shopId
     * @param lid
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopLid(HttpServletRequest request) throws Exception;

    /**
     * Lid信息分配
     * @param shopId
     * @param lidInfoRequest
     * @return
     * @throws Exception
     */
    public TransData<Object> allotLid(HttpServletRequest request) throws Exception;

    /**
     *根据商家编码查询实体店list
     * @param shopId
     * @return
     * @throws Exception
     */
    public TransData<List<MShopEntityInfo>> searchAllShopEntity(HttpServletRequest request) throws Exception;
}
