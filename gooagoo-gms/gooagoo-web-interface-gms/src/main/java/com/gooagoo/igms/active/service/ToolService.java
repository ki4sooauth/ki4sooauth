package com.gooagoo.igms.active.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface ToolService
{
    /**
     * 发布购好奇
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> release(HttpServletRequest request) throws Exception;
}
