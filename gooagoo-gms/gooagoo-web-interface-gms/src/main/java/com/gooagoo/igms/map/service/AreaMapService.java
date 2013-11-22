package com.gooagoo.igms.map.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.map.FAreaMapInfo;

public interface AreaMapService
{

    /**
     * 添加区域地图信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> addAreaMap(HttpServletRequest request) throws Exception;

    /**
     * 修改区域地图信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<String> updateAreaMap(HttpServletRequest request) throws Exception;

    /**
     * 删除区域地图信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> delAreaMap(HttpServletRequest request) throws Exception;

    /**
     * 区域地图信息列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FAreaMapInfo>> pageAreaMap(HttpServletRequest request) throws Exception;

    /**
     * 获取区域地图信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> getAreaMapInfo(HttpServletRequest request) throws Exception;

}
