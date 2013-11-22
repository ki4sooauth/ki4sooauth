package com.gooagoo.api.business.core.system.sys.role;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysRole;

/**
 *  后台用户角色管理
 */
public interface RoleManageCoreService

{

    /**
     * 新增角色
     * @param SysRole
     * @return
     * @throws Exception
     */
    public boolean addRole(SysRole sysRole) throws Exception;

    /**
     * 编辑角色
     * @param SysRole
     * @return
     * @throws Exception
     */
    public boolean updateRole(SysRole sysRole) throws Exception;

    /**
     * 删除角色
     * @param roleId
     * @return
     * @throws Exception
     */
    public boolean delRole(String roleId) throws Exception;

    /**
     * 给管理员分配角色
     * @param userId
     * @param roleIds
     * @return
     * @throws Exception
     */
    public boolean assignRoles(String userId, String[] roleIds) throws Exception;

    /**
     * 给角色分配权限
     * @param roleId
     * @param authoritys
     * @return
     * @throws Exception
     */
    public boolean assignPermissions(String roleId, List<String> authoritys) throws Exception;
}
