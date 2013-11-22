package com.gooagoo.igms.shopinfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.ZTreeNode;
import com.gooagoo.view.gms.shopinfo.FShopAuthority;

public interface IShopAuthorityService
{
    /**
     * 获取权限树信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<ZTreeNode>> getAuthority(HttpServletRequest request) throws Exception;

    /**
     * 获取角色拥有权限（id）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<String>> getRoleOwnerAuth(HttpServletRequest request) throws Exception;

    /**
     * 判断商家/商家用户是否有该权限
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> checkAuthID(HttpServletRequest request) throws Exception;

    /**
     * 获取用户权限列表
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<FShopAuthority>> getUserAuthories(HttpServletRequest request) throws Exception;
}
