package com.gooagoo.igms.shopinfo.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopUserInfo;

public interface IShopUserInfoService
{
    /**
     * 添加营销中心用户信息
     * @param request
     * @return
     */
    public TransData<Object> addShopUserInfo(HttpServletRequest request) throws Exception;

    /**
     * 修改营销中心用户信息
     * @param request
     * @return
     */
    public TransData<Object> updateShopUserInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除营销中心用户信息
     * @param request
     * @return
     */
    public TransData<Object> deleteShopUserInfo(HttpServletRequest request) throws Exception;

    /**
     * 删除营销中心用户信息
     * @param request
     * @return
     */
    public TransData<FShopUserInfo> getShopUserInfo(HttpServletRequest request) throws Exception;

    /**
     * 分页查询营销中心用户信息
     * @param request
     * @return
     */
    public TransData<PageModel<FShopUserInfo>> pageShopUserInfo(HttpServletRequest request) throws Exception;

    /**
     * 更改营销中心用户角色
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<Object> bindRole(HttpServletRequest request) throws Exception;
}
