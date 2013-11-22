package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;


public interface IBoundEmailService
{
    /**
     * 邮箱是否存在
     * @param request
     * @return
     */
    public TransData<Object> emailExist(HttpServletRequest request);

    /**
     * 发送邮件(验证邮箱和短信验证码)
     * @param request
     * @return
     */
    public TransData<Object> sendEmail(HttpServletRequest request);

    /**
     * 绑定邮箱账号
     * @param request
     * @return
     */
    public TransData<Object> boundEmail(HttpServletRequest request);

    /**
     * 获取短信验证码
     * @param request
     * @return
     */
    public TransData<Object> getMessageCode(HttpServletRequest request);

}
