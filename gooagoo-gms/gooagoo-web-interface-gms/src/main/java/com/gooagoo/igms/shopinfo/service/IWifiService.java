package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FWifiInfo;

public interface IWifiService
{
    /**
     * 添加wifi信息
     * @param request
     */
    public TransData<Object> addWifiInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除wifi信息
     * @param request
     */
    public TransData<Object> deleteWifiInfo(HttpServletRequest request) throws Exception;

    /**
     * 查询wifi详细信息
     * @param request
     */
    public TransData<FWifiInfo> getWifiInfo(HttpServletRequest request) throws Exception;

    /**
     * 分页查询wifi信息
     * @param request
     */
    public TransData<PageModel<FWifiInfo>> pageWifiInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改wifi信息
     * @param request
     */
    public TransData<Object> updateWifiInfo(HttpServletRequest request) throws Exception;

}
