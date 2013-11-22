package com.gooagoo.mis.rsrcmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.systemHierarchy.MPlatformRegion;

/**
 * @author Administrator
 *
 */
public interface PlatformRegionService
{
    /**
     * 新增小平台信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addPlatformRegion(HttpServletRequest request) throws Exception;

    /**
     * 删除小平台信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> deletePlatformRegion(HttpServletRequest request) throws Exception;

    /**
     * 查询小平台详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MPlatformRegion> queryPlatformRegionInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改小平台信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updatePlatformRegion(HttpServletRequest request) throws Exception;

    /**
     * 查询所有小平台信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MPlatformRegion>> queryPlatformRegionList(HttpServletRequest request) throws Exception;
}
