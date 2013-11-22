package com.gooagoo.igus.mall.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IMallService
{

    /**
     * 获取积分兑换物列表
     * @param request
     * @return
     */
    public TransData<Object> getConvertThingList(HttpServletRequest request);

    /**
     * 积分兑换
     * @param request
     * @return
     */
    public TransData<Object> integralConvert(HttpServletRequest request);

    /**
     * 查询用户收货地址列表
     * @param request
     * @return
     */
    public TransData<Object> getShippingAddressList(HttpServletRequest request);

}
