package com.gooagoo.igms.shopinfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopEntityInfo;
import com.gooagoo.view.gms.shopinfo.FShopInvoiceInfo;

public interface IShopEntityService
{
    /**
     * 添加实体店信息
     * @param entityInfo
     * @return
     */
    public TransData<Object> addEntity(HttpServletRequest request) throws Exception;

    /**
     * 修改实体店信息
     * @param entityInfo
     * @return
     */
    public TransData<Object> updateEntity(HttpServletRequest request) throws Exception;

    /**
     * 删除实体店信息
     * @param entityInfo
     * @return
     */
    public TransData<Object> deleteEntity(HttpServletRequest request) throws Exception;

    /**
     * 查询实体店信息
     * @param entityInfo
     * @return
     */
    public TransData<FShopEntityInfo> getEntity(HttpServletRequest request) throws Exception;

    /**
     * 分页查询实体店信息
     * @param entityInfo
     * @return
     */
    public TransData<PageModel<FShopEntityInfo>> pageEntity(HttpServletRequest request) throws Exception;

    /**
     * 添加实体店联系方式
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopLink(HttpServletRequest request) throws Exception;

    /**
     * 修改实体店联系方式
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> updateShopLink(HttpServletRequest request) throws Exception;

    /**
     * 修改实体店GPS信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> addGPSInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改实体店GPS信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> updateGPSInfo(HttpServletRequest request) throws Exception;

    /**
     * 添加小票信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopInvoiceInfo(HttpServletRequest request) throws Exception;

    /**
     * 查询小票信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<List<FShopInvoiceInfo>> ListShopInvoiceInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除小票信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> delShopInvoiceInfo(HttpServletRequest request) throws Exception;
}
