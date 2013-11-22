package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IPasswordService
{

    /**
    * 修改密码
    * @param request
    * @return
    */
    public TransData<Object> updatePassword(HttpServletRequest request);
}
