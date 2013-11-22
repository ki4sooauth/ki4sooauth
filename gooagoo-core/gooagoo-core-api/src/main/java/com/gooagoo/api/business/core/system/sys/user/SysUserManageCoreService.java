package com.gooagoo.api.business.core.system.sys.user;

import com.gooagoo.entity.generator.sys.SysUserInfo;

/**
 *  系统管理员管理
 */
public interface SysUserManageCoreService

{

    /**
     * 新增系统管理员
     * @param sysUserInfo
     * @return
     * @throws Exception
     */
    public boolean addSysUser(SysUserInfo sysUserInfo) throws Exception;

    /**
     * 编辑系统管理员信息
     * @param sysUserInfo
     * @return
     * @throws Exception
     */
    public boolean updateSysUser(SysUserInfo sysUserInfo) throws Exception;

    /**
     * 删除系统管理员
     * @param userId
     * @return
     * @throws Exception
     */
    public boolean delSysUser(String userId) throws Exception;

}
