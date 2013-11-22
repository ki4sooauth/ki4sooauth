package com.gooagoo.igus.calendar.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ICalendarService
{

    /**
     * 获取活动信息的列表
     * @param request
     * @return
     */
    public TransData<Object> getActiveList(HttpServletRequest request);

    /**
     * 获取购物清单列表
     * @param request
     * @return
     */
    public TransData<Object> getShoppinglistList(HttpServletRequest request);
    
    /**
     * 获取账单信息列表
     * @param request
     * @return
     */
    public TransData<Object> getBillList(HttpServletRequest request);
}
