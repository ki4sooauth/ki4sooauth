package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.entity.generator.sys.SysUserRoleKey;

public interface SysUserRoleMapper
{

    public Integer countByExample(SysUserRoleExample sysUserRoleExample);

    public List<SysUserRole> selectByExample(SysUserRoleExample sysUserRoleExample);

    public SysUserRole selectByPrimaryKey(SysUserRoleKey sysUserRoleKey);

    public Integer deleteByExample(SysUserRoleExample sysUserRoleExample);

    public Integer deleteByPrimaryKey(SysUserRoleKey sysUserRoleKey);

    public Integer insertSelective(SysUserRole sysUserRole);

    public Integer updateAllByExample(@Param("record") SysUserRole sysUserRole, @Param("example") SysUserRoleExample sysUserRoleExample);

    public Integer updateByExampleSelective(@Param("record") SysUserRole sysUserRole, @Param("example") SysUserRoleExample sysUserRoleExample);

    public Integer updateByPrimaryKeySelective(SysUserRole sysUserRole);

}
