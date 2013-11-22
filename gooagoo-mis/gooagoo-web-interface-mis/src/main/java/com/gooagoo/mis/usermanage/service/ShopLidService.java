package com.gooagoo.mis.usermanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.enterprise.MShopLidInfo;

public interface ShopLidService
{

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

}
