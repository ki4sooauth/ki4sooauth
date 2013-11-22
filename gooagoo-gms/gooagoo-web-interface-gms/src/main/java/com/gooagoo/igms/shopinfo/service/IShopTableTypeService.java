package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopTableType;

public interface IShopTableTypeService
{
    /**
     * 餐桌类型查询
     * @param request
     * @return
     */
    public TransData<FShopTableType> getTableType(HttpServletRequest request) throws Exception;

    /**
     * 餐桌类型添加
     * @param request
     * @return
     */
    public TransData<Object> addTableType(HttpServletRequest request) throws Exception;

    /**
     * 餐桌类型删除
     * @param request
     * @return
     */
    public TransData<Object> delTableType(HttpServletRequest request) throws Exception;

    /**
     * 餐桌类型修改
     * @param request
     * @return
     */
    public TransData<Object> updateTableType(HttpServletRequest request) throws Exception;

    /**
     * 分页查询餐桌类型
     * @param request
     * @return
     */
    public TransData<PageModel<FShopTableType>> listTableType(HttpServletRequest request) throws Exception;

}
