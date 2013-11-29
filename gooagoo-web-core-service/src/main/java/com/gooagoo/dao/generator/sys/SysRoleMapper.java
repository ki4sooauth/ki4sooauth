package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.SysRole;
import com.gooagoo.entity.generator.sys.SysRoleExample;
import com.gooagoo.entity.generator.sys.SysRoleKey;

public interface SysRoleMapper
{

    public Integer countByExample(SysRoleExample sysRoleExample);

    public List<SysRole> selectByExample(SysRoleExample sysRoleExample);

    public SysRole selectByPrimaryKey(SysRoleKey sysRoleKey);

    public Integer deleteByExample(SysRoleExample sysRoleExample);

    public Integer deleteByPrimaryKey(SysRoleKey sysRoleKey);

    public Integer insertSelective(SysRole sysRole);

    public Integer updateAllByExample(@Param("record") SysRole sysRole, @Param("example") SysRoleExample sysRoleExample);

    public Integer updateByExampleSelective(@Param("record") SysRole sysRole, @Param("example") SysRoleExample sysRoleExample);

    public Integer updateByPrimaryKeySelective(SysRole sysRole);

}
