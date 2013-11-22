package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.SysAuthorityGeneratorQueryService;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysAuthorityKey;
import com.gooagoo.dao.generator.sys.SysAuthorityMapper;

@Service
public class SysAuthorityGeneratorQueryServiceImpl implements SysAuthorityGeneratorQueryService
{

    @Autowired
    private SysAuthorityMapper sysAuthorityMapper;

    @Override
    public Integer countByExample(SysAuthorityExample sysAuthorityExample) 
    {
        return this.sysAuthorityMapper.countByExample(sysAuthorityExample);
    }

    @Override
    public List<SysAuthority> selectByExample(SysAuthorityExample sysAuthorityExample) 
    {
        return this.sysAuthorityMapper.selectByExample(sysAuthorityExample);
    }

    @Override
    public SysAuthority selectUnDelByPrimaryKey(String primaryKey) 
    {
        SysAuthorityKey sysAuthorityKey = new SysAuthorityKey();
        sysAuthorityKey.setIsDel("N");
        sysAuthorityKey.setAuthorityId(primaryKey);
        return this.sysAuthorityMapper.selectByPrimaryKey(sysAuthorityKey);
    }

    @Override
    public SysAuthority selectByPrimaryKey(String primaryKey) 
    {
        SysAuthorityKey sysAuthorityKey = new SysAuthorityKey();
        sysAuthorityKey.setAuthorityId(primaryKey);
        return this.sysAuthorityMapper.selectByPrimaryKey(sysAuthorityKey);
    }

}
