package com.gooagoo.dao.generator.sys;

import java.util.List;

import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysAuthorityKey;

public interface SysAuthorityMapper
{

    public Integer countByExample(SysAuthorityExample sysAuthorityExample);

    public List<SysAuthority> selectByExample(SysAuthorityExample sysAuthorityExample);

    public SysAuthority selectByPrimaryKey(SysAuthorityKey sysAuthorityKey);

}
