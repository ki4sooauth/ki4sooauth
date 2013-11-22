package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopLidDetail;

public interface IShopLidDetailService
{
    /**
     * 修改商家lid分配详细信息
     * @param request
     * @return
     */
    public TransData<Object> updateLidDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询商家lid分配详细信息
     * @param request
     * @return
     */
    public TransData<FShopLidDetail> getLidDetail(HttpServletRequest request) throws Exception;

    /**
     *分页 查询商家lid分配详细信息
     * @param request
     * @return
     */
    public TransData<PageModel<FShopLidDetail>> pageLidDetail(HttpServletRequest request) throws Exception;

}
