package com.gooagoo.igms.marketing.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FShopIntegral;

public interface IntegralService
{
    /**
     * 创建积分兑换
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws Exception;

    /**
     * 修改积分兑换
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 删除积分兑换
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws Exception;

    /**
     * 获取积分兑换信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<FShopIntegral> getIntegralConvert(HttpServletRequest request) throws Exception;

    /**
     * 分页查询积分兑换信息
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FShopIntegral>> pageIntegralConvert(HttpServletRequest request) throws Exception;
}
