package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ISecurityCardService
{

    /**
     * 查询用户已绑定的密保卡
     * @param request
     * @return
     */
    public TransData<Object> getUserSecurityCard(HttpServletRequest request);

    /**
     * 绑定密保卡
     * @param request
     * @return
     */
    public TransData<Object> setUserSecurityCard(HttpServletRequest request);

    /**
     * 解除绑定的密保卡
     * @param request
     * @return
     */
    public TransData<Object> deleteUserSecurityCard(HttpServletRequest request);

}
