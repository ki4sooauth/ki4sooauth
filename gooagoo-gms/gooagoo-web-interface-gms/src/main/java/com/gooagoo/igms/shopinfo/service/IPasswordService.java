package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IPasswordService
{
    /**
     * 修改用户密码
     * @param request
     * @return
     */
    public TransData<Object> updatePwd(HttpServletRequest request) throws Exception;

}
