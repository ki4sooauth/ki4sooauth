package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.mobileDevices.MMobileVersion;

public interface MobileVersionService
{
    /**
     * 查询设备类型信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MMobileVersion>> queryMobileVersion(HttpServletRequest request) throws Exception;

    /**
     * 新增设备类型
     * @param request
     * @throws Exception
     */
    public TransData<Object> addMobileVersion(HttpServletRequest request) throws Exception;
    
}
