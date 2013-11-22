package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysRole;
import com.gooagoo.entity.generator.sys.SysRoleExample;
import com.gooagoo.entity.generator.sys.SysRoleKey;

public interface SysRoleMapper
{

    public Integer countByExample(SysRoleExample sysRoleExample);

    public List<SysRole> selectByExample(SysRoleExample sysRoleExample);

    public SysRole selectByPrimaryKey(SysRoleKey sysRoleKey);

}
