package com.gooagoo.mis.sysmanage.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.common.MMisLoginInfo;
import com.gooagoo.view.mis.sysUserManage.MSysUserInfo;
import com.gooagoo.view.mis.sysUserManage.MSysUserRole;

public interface SysUserService
{

    /**
     * 登录验证
     * @param userId
     * @param pwd
     * @return true-登录成功 false-登录失败
     * @throws GooagooException
     */
    public TransData<MMisLoginInfo> checkLogin(HttpServletRequest request) throws Exception;

    /**
     * 修改密码
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> modifyPassword(HttpServletRequest request) throws Exception;

    /**
     * 查询登录用户信息
     * @param userId 用户ID
     * @throws Exception
     */
    public TransData<String> searchUserAuthority(HttpServletRequest request) throws Exception;

    /**
     * 添加系统管理员
     * @param sysUserInfo
     * @return
     * @throws Exception
     */
    public TransData<Object> addSysUser(HttpServletRequest request) throws Exception;

    /**
     * 查询用户详情
     * @param userId
     * @return
     * @throws Exception
     */
    public TransData<MSysUserInfo> searchSysUserDetail(HttpServletRequest request) throws Exception;

    /**
     * 查询用户拥的有角色
     * @param userId
     * @return
     * @throws Exception
     */
    public TransData<List<MSysUserRole>> searchUserRoles(HttpServletRequest request) throws Exception;

    /**
     * 修改系统管理员
     * @param sysUserInfo
     * @return
     * @throws Exception
     */
    public TransData<Object> updateSysUser(HttpServletRequest request) throws Exception;

    /**
     * 删除管理员
     * @param userId
     * @return
     * @throws Exception
     */
    public TransData<Object> delSysUser(HttpServletRequest request) throws Exception;

    /**
     * 查询所有管理员
     * @return
     * @throws Exception
     */
    public TransData<PageModel<MSysUserInfo>> searchAllSysUser(HttpServletRequest request) throws Exception;

    /**
     * 用户分配角色
     * @param userId
     * @param roleIds
     * @return
     * @throws Exception
     */
    public TransData<Object> allotRole(HttpServletRequest request) throws Exception;
}
