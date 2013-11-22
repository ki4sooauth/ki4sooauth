package com.gooagoo.igus.personal.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IPersonalInfoService
{

    /**
     * 查询个人信息
     * @param request
     * @return
     */
    public TransData<Object> getPersonalInfo(HttpServletRequest request);

    /**
     * 修改个人信息
     * @param request
     * @return
     */
    public TransData<Object> updatePersonalInfo(HttpServletRequest request);

    /**
     * 修改头像
     * @param request
     * @return
     */
    public TransData<Object> updateHeadPic(HttpServletRequest request);
}
