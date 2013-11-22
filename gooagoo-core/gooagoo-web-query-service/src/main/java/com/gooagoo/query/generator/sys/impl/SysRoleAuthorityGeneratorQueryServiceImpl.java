package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.SysRoleAuthorityGeneratorQueryService;
import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityKey;
import com.gooagoo.dao.generator.sys.SysRoleAuthorityMapper;

@Service
public class SysRoleAuthorityGeneratorQueryServiceImpl implements SysRoleAuthorityGeneratorQueryService
{

    @Autowired
    private SysRoleAuthorityMapper sysRoleAuthorityMapper;

    @Override
    public Integer countByExample(SysRoleAuthorityExample sysRoleAuthorityExample) 
    {
        return this.sysRoleAuthorityMapper.countByExample(sysRoleAuthorityExample);
    }

    @Override
    public List<SysRoleAuthority> selectByExample(SysRoleAuthorityExample sysRoleAuthorityExample) 
    {
        return this.sysRoleAuthorityMapper.selectByExample(sysRoleAuthorityExample);
    }

    @Override
    public SysRoleAuthority selectUnDelByPrimaryKey(String primaryKey) 
    {
        SysRoleAuthorityKey sysRoleAuthorityKey = new SysRoleAuthorityKey();
        sysRoleAuthorityKey.setIsDel("N");
        sysRoleAuthorityKey.setSysRoleAuthorityId(primaryKey);
        return this.sysRoleAuthorityMapper.selectByPrimaryKey(sysRoleAuthorityKey);
    }

    @Override
    public SysRoleAuthority selectByPrimaryKey(String primaryKey) 
    {
        SysRoleAuthorityKey sysRoleAuthorityKey = new SysRoleAuthorityKey();
        sysRoleAuthorityKey.setSysRoleAuthorityId(primaryKey);
        return this.sysRoleAuthorityMapper.selectByPrimaryKey(sysRoleAuthorityKey);
    }

}
