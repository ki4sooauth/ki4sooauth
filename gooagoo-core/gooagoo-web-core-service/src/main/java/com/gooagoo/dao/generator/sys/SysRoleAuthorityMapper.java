package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityKey;

public interface SysRoleAuthorityMapper
{

    public Integer countByExample(SysRoleAuthorityExample sysRoleAuthorityExample);

    public List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample sysRoleAuthorityExample);

    public SysRoleAuthority selectByPrimaryKey(SysRoleAuthorityKey sysRoleAuthorityKey);

    public Integer deleteByExample(SysRoleAuthorityExample sysRoleAuthorityExample);

    public Integer deleteByPrimaryKey(SysRoleAuthorityKey sysRoleAuthorityKey);

    public Integer insertSelective(SysRoleAuthority sysRoleAuthority);

    public Integer updateAllByExample(@Param("record") SysRoleAuthority sysRoleAuthority, @Param("example") SysRoleAuthorityExample sysRoleAuthorityExample);

    public Integer updateByExampleSelective(@Param("record") SysRoleAuthority sysRoleAuthority, @Param("example") SysRoleAuthorityExample sysRoleAuthorityExample);

    public Integer updateByPrimaryKeySelective(SysRoleAuthority sysRoleAuthority);

}
