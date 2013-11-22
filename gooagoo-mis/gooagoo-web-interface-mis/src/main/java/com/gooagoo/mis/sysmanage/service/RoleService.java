package com.gooagoo.mis.sysmanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MZTreeNode;
import com.gooagoo.view.mis.roleManage.MSysRole;

public interface RoleService
{

    /**
     * 添加角色
     * @param MSysRole
     * @return true-成功 false-失败
     * @throws Exception
     */
    public TransData<Object> addRole(HttpServletRequest request) throws Exception;

    /**
     * 编辑角色
     * @param MSysRole
     * @return true-成功 false-失败
     * @throws Exception
     */
    public TransData<Object> editRole(HttpServletRequest request) throws Exception;

    /**
     * 删除角色
     * @param roleId
     * @return true-成功 false-失败
     * @throws Exception
     */
    public TransData<Object> delRole(HttpServletRequest request) throws Exception;

    /**
     * 查看角色详情
     * @param roleId
     * @return 
     * @throws Exception
     */
    public TransData<MSysRole> searchRoleDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询所有角色（分页）
     * @param MSysRole
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MSysRole>> searchAllRoles(HttpServletRequest request) throws Exception;

    /**
     * 查询所有角色（List）
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<MSysRole>> searchAllListRole(HttpServletRequest request) throws Exception;

    /**
     * 为角色设置权限
     * @return
     * @throws Exception
     */
    public TransData<Object> setRoleAuthority(HttpServletRequest request) throws Exception;

    /**
     * 查询所有权限
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<List<MZTreeNode>> searchAllAuthorities(HttpServletRequest request) throws Exception;

}
