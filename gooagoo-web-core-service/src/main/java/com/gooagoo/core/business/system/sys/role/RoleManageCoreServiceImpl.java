package com.gooagoo.core.business.system.sys.role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.system.sys.role.RoleManageCoreService;
import com.gooagoo.api.generator.core.sys.SysRoleAuthorityGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.dao.generator.sys.SysRoleMapper;
import com.gooagoo.dao.generator.sys.SysUserRoleMapper;
import com.gooagoo.entity.generator.sys.SysRole;
import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class RoleManageCoreServiceImpl implements RoleManageCoreService

{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Autowired
    private SysRoleAuthorityGeneratorCoreService sysRoleAuthorityGeneratorCoreService;

    @Override
    public boolean addRole(SysRole sysRole) throws Exception
    {
        sysRole.setIsDel("N");
        return this.sysRoleMapper.insertSelective(sysRole) > 0 ? true : false;
    }

    @Override
    public boolean updateRole(SysRole sysRole) throws Exception
    {
        return this.sysRoleMapper.updateByPrimaryKeySelective(sysRole) > 0 ? true : false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean delRole(String roleId) throws Exception
    {
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(roleId);
        sysRole.setIsDel("Y");
        //删除角色表
        if (this.sysRoleMapper.updateByPrimaryKeySelective(sysRole) < 0)
        {
            GooagooLog.warn("删除角色表失败" + new Gson().toJson(sysRole));
            throw new OperateFailException("删除角色表失败");
        }
        //删除用户-角色关联表
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setIsDel("Y");
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andRoleIdEqualTo(roleId).andIsDelEqualTo("N");
        if (this.sysUserRoleMapper.updateByExampleSelective(sysUserRole, sysUserRoleExample) < 0)
        {
            GooagooLog.warn("删除用户-角色关联表失败" + new Gson().toJson(sysUserRole));
            throw new OperateFailException("删除用户-角色关联表失败");
        }
        //删除角色-权限关联表
        SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
        sysRoleAuthority.setIsDel("Y");
        SysRoleAuthorityExample sysRoleAuthorityExample = new SysRoleAuthorityExample();
        sysRoleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId).andIsDelEqualTo("N");
        if (!this.sysRoleAuthorityGeneratorCoreService.updateByExampleSelective(sysRoleAuthority, sysRoleAuthorityExample))
        {
            GooagooLog.warn("删除角色-权限关联表失败" + new Gson().toJson(sysUserRole));
            throw new OperateFailException("删除角色-权限关联表失败");
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean assignRoles(String userId, String[] roleIds) throws Exception
    {
        if (!StringUtils.hasText(userId))
        {
            GooagooLog.warn("给管理员分配角色时管理员用户ID为空");
            return false;
        }

        SysUserRole sysUserRole;
        //删除管理员用户既有的所有角色
        SysUserRoleExample sysUserRoleExample = new SysUserRoleExample();
        sysUserRoleExample.createCriteria().andUserIdEqualTo(userId);
        if (this.sysUserRoleMapper.deleteByExample(sysUserRoleExample) < 0)
        {
            GooagooLog.warn("删除管理员用户既有的所有角色失败" + new Gson().toJson(sysUserRoleExample));
            throw new OperateFailException("删除用户-角色关联表失败");
        }
        for (String string : roleIds)
        {
            sysUserRole = new SysUserRole();
            sysUserRole.setSysUserRoleId(com.gooagoo.common.utils.StringUtils.getUUID());
            sysUserRole.setUserId(userId);
            sysUserRole.setRoleId(string);
            sysUserRole.setIsDel("N");
            if (this.sysUserRoleMapper.insertSelective(sysUserRole) < 0)
            {
                GooagooLog.warn("删除管理员用户既有的所有角色失败" + new Gson().toJson(sysUserRole));
                throw new OperateFailException("删除用户-角色关联表失败");
            }
        }
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean assignPermissions(String roleId, List<String> authoritys) throws Exception
    {
        if (!StringUtils.hasText(roleId))
        {
            GooagooLog.warn("给角色分配权限时角色ID为空");
            return false;
        }
        SysRoleAuthorityExample sysRoleAuthorityExample = new SysRoleAuthorityExample();
        sysRoleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
        List<SysRoleAuthority> sysRoleAuthorities = this.sysRoleAuthorityGeneratorCoreService.selectByExample(sysRoleAuthorityExample);
        if (sysRoleAuthorities != null && sysRoleAuthorities.size() > 0)
        {
            this.sysRoleAuthorityGeneratorCoreService.deleteByExample(sysRoleAuthorityExample);
        }
        for (String string : authoritys)
        {
            SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
            sysRoleAuthority.setSysRoleAuthorityId(com.gooagoo.common.utils.StringUtils.getUUID());
            sysRoleAuthority.setAuthorityId(string);
            sysRoleAuthority.setRoleId(roleId);
            sysRoleAuthority.setIsDel("N");
            if (!this.sysRoleAuthorityGeneratorCoreService.insertSelective(sysRoleAuthority))
            {
                GooagooLog.info("为后台管理员角色设置权限失败" + new Gson().toJson(sysRoleAuthority));
                throw new OperateFailException("为后台管理员角色设置权限失败");
            }
        }
        return true;
    }
}
