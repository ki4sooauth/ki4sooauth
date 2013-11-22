package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IAccountService
{

    /**
     * 设置用户名
     * @param request
     * @return
     */
    public TransData<Object> setAccount(HttpServletRequest request);

}
