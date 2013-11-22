package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.entity.generator.sys.SysUserRoleKey;

public interface SysUserRoleMapper
{

    public Integer countByExample(SysUserRoleExample sysUserRoleExample);

    public List<SysUserRole> selectByExample(SysUserRoleExample sysUserRoleExample);

    public SysUserRole selectByPrimaryKey(SysUserRoleKey sysUserRoleKey);

}
