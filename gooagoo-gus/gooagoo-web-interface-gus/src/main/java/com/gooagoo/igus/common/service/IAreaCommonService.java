package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IAreaCommonService
{
    /**
     * 查询区列表
     * @param request
     * @return
     */
    public TransData<Object> getAreaList(HttpServletRequest request);

}
