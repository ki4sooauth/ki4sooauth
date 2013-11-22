package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityKey;

public interface SysRoleAuthorityMapper
{

    public Integer countByExample(SysRoleAuthorityExample sysRoleAuthorityExample);

    public List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample sysRoleAuthorityExample);

    public SysRoleAuthority selectByPrimaryKey(SysRoleAuthorityKey sysRoleAuthorityKey);

}
