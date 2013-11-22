package com.gooagoo.igms.common.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface CommonService
{
    /**
     * 获取uuid
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> getUUID(HttpServletRequest request) throws Exception;
    
    
    /**
     * 获取数据据时间
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Date> getDBTime(HttpServletRequest request) throws Exception;

}
