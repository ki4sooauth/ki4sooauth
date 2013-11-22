package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FTableInfo;

public interface ITableInfoService
{
    /**
     * 添加桌号信息
     * @param request
     */
    public TransData<Object> addTableInfo(HttpServletRequest request) throws Exception;

    /**
     *删除桌号信息
     * @param request
     */
    public TransData<Object> deleteTableInfo(HttpServletRequest request) throws Exception;

    /**
     * 查询桌号详细
     * @param request
     */
    public TransData<FTableInfo> getTableInfo(HttpServletRequest request) throws Exception;

    /**
     * 分页查询桌号信息
     * @param request
     */
    public TransData<PageModel<FTableInfo>> pageTableInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改桌号信息
     * @param request
     */
    public TransData<Object> updateTableInfo(HttpServletRequest request) throws Exception;

    /**
     * 餐桌状态
     * @param request
     */
    public TransData<Object> getDeskStatus(HttpServletRequest request) throws Exception;

    /**
     * 餐桌状态详情
     * @param request
     */
    public TransData<Object> getDeskStatusDetail(HttpServletRequest request) throws Exception;

}
