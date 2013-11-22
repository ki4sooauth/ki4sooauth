package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ICityCommonService
{

    /**
     * 查询市列表
     * @param request
     * @return
     */
    public TransData<Object> getCityList(HttpServletRequest request);

}
