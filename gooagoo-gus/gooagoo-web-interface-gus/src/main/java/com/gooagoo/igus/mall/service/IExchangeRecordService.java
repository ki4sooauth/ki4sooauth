package com.gooagoo.igus.mall.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IExchangeRecordService
{

    /**
     * 查询兑换记录列表
     * @param request
     * @return
     */
    public TransData<Object> getConvertRecordList(HttpServletRequest request);

}
