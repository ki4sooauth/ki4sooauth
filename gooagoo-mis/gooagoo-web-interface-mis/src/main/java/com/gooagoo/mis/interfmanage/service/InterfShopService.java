package com.gooagoo.mis.interfmanage.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.merchantInterface.MShopInterfaceInfo;

public interface InterfShopService
{

    /**
     * 商家接口信息新增
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> add(HttpServletRequest request) throws GooagooException;

    /**
     * 商家接口信息修改
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> update(HttpServletRequest request) throws Exception;

    /**
     * 商家接口信息删除
     * @param HttpServletRequest request
     * @return
     * @throws Exception
     */
    public TransData<Object> delete(HttpServletRequest request) throws GooagooException;

    /**
     * 商家分配接口
     * @return
     */
    public TransData<Object> allotShopInterf(HttpServletRequest request) throws Exception;

    /**
     * 查询商家接口信息列表(分页)
     * @param basicInfoRequest
     * @return
     * @throws GooagooException
     */
    public TransData<PageModel<MShopInterfaceInfo>> searchShopInterfList(HttpServletRequest request) throws Exception;

    /**
     * 查询商家接口信息(详细)
     * @param request
     * @return
     * @throws GooagooException
     */
    public TransData<MShopInterfaceInfo> getShopInterfDetail(HttpServletRequest request) throws Exception;

}
