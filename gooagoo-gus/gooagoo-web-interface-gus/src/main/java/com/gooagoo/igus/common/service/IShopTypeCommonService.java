package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IShopTypeCommonService
{

    /**
     * 获取商家类型列表
     * 
     * @param request
     * @return
     */
    public TransData<Object> getShopTypeList(HttpServletRequest request);

}
