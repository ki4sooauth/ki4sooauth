package com.gooagoo.igms.shopinfo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.shopinfo.FShopRole;

public interface IShopRoleService
{
    /**
     * 添加角色信息
     * @param request
     * @return
     */
    public TransData<Object> addShopRole(HttpServletRequest request) throws Exception;

    /**
     * 修改角色信息
     * @param request
     * @return
     */
    public TransData<Object> updateShopRole(HttpServletRequest request) throws Exception;

    /**
     * 删除角色信息
     * @param request
     * @return
     */
    public TransData<Object> deleteShopRole(HttpServletRequest request) throws Exception;

    /**
     * 删除角色信息
     * @param request
     * @return
     */
    public TransData<FShopRole> getShopRole(HttpServletRequest request) throws Exception;

    /**
     * 分页查询角色信息
     * @param request
     * @return
     */
    public TransData<PageModel<FShopRole>> pageShopRole(HttpServletRequest request) throws Exception;
    
    
    /**
     * 查询所有的角色信息
     * @param request
     * @return
     */
    public TransData<List<FShopRole>> getAllShopRole(HttpServletRequest request) throws Exception;

    /**
     * 给角色绑定权限
     * @param request
     * @return
     */
    public TransData<Object> bindAuthority(HttpServletRequest request) throws Exception;
    /**
     * 查询用户己有角色信息
     * @param request
     * @return
     */
    public TransData<List<String>> getUserOwnRole(HttpServletRequest request) throws Exception;
}
