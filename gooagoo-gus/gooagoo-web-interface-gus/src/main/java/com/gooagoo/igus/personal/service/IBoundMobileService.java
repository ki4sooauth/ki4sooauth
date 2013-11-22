package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IBoundMobileService
{
    /**
     * 手机号码是否存在
     * @param request
     * @return
     */
    public TransData<Object> mobileExist(HttpServletRequest request);

    /**
     * 发送邮件（验证邮箱和短信验证码）
     * @param request
     * @return
     */
    public TransData<Object> sendEmail(HttpServletRequest request);

    /**
     * 邮箱验证身份
     * @param request
     * @return
     */
    public TransData<Object> emailAuthentication(HttpServletRequest request);

    /**
     * 获取短信验证码
     * @param request
     * @return
     */
    public TransData<Object> getMessageCode(HttpServletRequest request);

    /**
     * 绑定手机号码
     * @param request
     * @return
     */
    public TransData<Object> boundMobile(HttpServletRequest request);

}
