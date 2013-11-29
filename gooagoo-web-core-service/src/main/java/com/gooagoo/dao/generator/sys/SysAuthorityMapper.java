package com.gooagoo.dao.generator.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysAuthorityKey;

public interface SysAuthorityMapper
{

    public Integer countByExample(SysAuthorityExample sysAuthorityExample);

    public List<SysAuthority> selectByExample(SysAuthorityExample sysAuthorityExample);

    public SysAuthority selectByPrimaryKey(SysAuthorityKey sysAuthorityKey);

    public Integer deleteByExample(SysAuthorityExample sysAuthorityExample);

    public Integer deleteByPrimaryKey(SysAuthorityKey sysAuthorityKey);

    public Integer insertSelective(SysAuthority sysAuthority);

    public Integer updateAllByExample(@Param("record") SysAuthority sysAuthority, @Param("example") SysAuthorityExample sysAuthorityExample);

    public Integer updateByExampleSelective(@Param("record") SysAuthority sysAuthority, @Param("example") SysAuthorityExample sysAuthorityExample);

    public Integer updateByPrimaryKeySelective(SysAuthority sysAuthority);

}
