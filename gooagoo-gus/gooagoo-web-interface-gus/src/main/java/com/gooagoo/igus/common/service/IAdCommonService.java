package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IAdCommonService
{

    /**
     * 查询广告信息
     * @param request
     * @return
     */
    public TransData<Object> getAdInfo(HttpServletRequest request);

}
