package com.gooagoo.igms.marketing.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FShopIntegralConvert;

public interface IntegralDeliverService
{

    /**
     * 修改积分兑换
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> deliver(HttpServletRequest request) throws Exception;

    /**
     * 分页查询积分兑换信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FShopIntegralConvert>> pageIntegralDeliver(HttpServletRequest request) throws Exception;

}
