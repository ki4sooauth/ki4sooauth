package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ISecurityQuestionService
{

    /**
     * 查询用户已设置的密保问题
     * @param request
     * @return
     */
    public TransData<Object> getUserSecurityQuestion(HttpServletRequest request);

    /**
     * 验证用户密码
     * @param request
     * @return
     */
    public TransData<Object> checkUserPassword(HttpServletRequest request);

    /**
     * 查询系统内置密保问题
     * @param request
     * @return
     */
    public TransData<Object> getSysSecurityQuestion(HttpServletRequest request);

    /**
     * 设置密保问题
     * @param request
     * @return
     */
    public TransData<Object> setUserSecurityQuestion(HttpServletRequest request);

    /**
     * 删除密保问题
     * @param request
     * @return
     */
    public TransData<Object> deleteUserSecurityQuestion(HttpServletRequest request);

}
