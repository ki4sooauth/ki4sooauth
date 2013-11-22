package com.gooagoo.igms.map.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface GridService
{
    /**
    * 网格数据初始化
    * @param request
    * @return
    * @throws Exception
    */
    public TransData<Object> initGridInfo(HttpServletRequest request) throws Exception;

    /**
     * 获取网格信息数据
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Map<String, String>> getGridInfo(HttpServletRequest request) throws Exception;
}
