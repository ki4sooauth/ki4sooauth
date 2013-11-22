package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IPhoneService
{

    /**
     * 绑定手机 -- 2013.07.24 潘响说不用
     * @param request
     * @return
     */
    public TransData<Object> bindPhone(HttpServletRequest request) throws Exception;

}
