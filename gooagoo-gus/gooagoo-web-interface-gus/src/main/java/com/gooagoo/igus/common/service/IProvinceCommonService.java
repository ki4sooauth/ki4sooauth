package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IProvinceCommonService
{

    /**
     * 查询省列表
     * @param request
     * @return
     */
    public TransData<Object> getProvinceList(HttpServletRequest request);
}
