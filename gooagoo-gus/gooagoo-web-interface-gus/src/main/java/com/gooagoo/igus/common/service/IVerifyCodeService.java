package com.gooagoo.igus.common.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IVerifyCodeService
{

    /**
     * 获取随机验证码
     * @param request
     * @return
     */
    public TransData<Object> getVerifyCode(HttpServletRequest request);

    /**
     * 校验随机验证码
     * @param request
     * @return
     */
    public TransData<Object> checkVerifyCode(HttpServletRequest request);

}
