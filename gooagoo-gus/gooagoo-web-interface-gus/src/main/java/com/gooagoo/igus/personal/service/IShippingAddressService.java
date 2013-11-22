package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IShippingAddressService
{
    /**
     * 获取收货地址列表
     * @param request
     * @return
     */
    public TransData<Object> getShippingAddressList(HttpServletRequest request);

    /**
     * 增加收货地址
     * @param request
     * @return
     */
    public TransData<Object> addShippingAddress(HttpServletRequest request);

    /**
     * 设为默认收货地址
     * @param request
     * @return
     */
    public TransData<Object> setDefaultShippingAddress(HttpServletRequest request);

    /**
     * 修改收货地址
     * @param request
     * @return
     */
    public TransData<Object> updateShippingAddress(HttpServletRequest request);

    /**
     * 删除收货地址
     * @param request
     * @return
     */
    public TransData<Object> deleteShippingAddress(HttpServletRequest request);
}
