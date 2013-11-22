package com.gooagoo.mis.usermanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.gooagoo.view.mis.enterprise.MShopRole2;

public interface ShopRoleManageService
{
    /**
     * 新增商家角色
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> addShopRoleManage(HttpServletRequest request) throws Exception;

    /**
     * 修改商家角色
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> updateShopRoleManage(HttpServletRequest request) throws Exception;

    /**
     * 删除商家角色
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> deleteShopRoleManage(HttpServletRequest request) throws Exception;

    /**
     * 查询所有商家角色
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MShopRole2>> queryAllShopRoleManage(HttpServletRequest request) throws Exception;

    /**
     * 查询商家角色详细
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<MShopRole2> queryShopRoleManage(HttpServletRequest request) throws Exception;

    /**
     * 分配商家角色页面
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<MZTreeNode>> queryShopRoleAuthority2(HttpServletRequest request) throws Exception;

    /**
     * 分配商家角色权限
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> assignShopRoleManage(HttpServletRequest request) throws Exception;
}
