package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.SysRoleGeneratorQueryService;
import com.gooagoo.entity.generator.sys.SysRole;
import com.gooagoo.entity.generator.sys.SysRoleExample;
import com.gooagoo.entity.generator.sys.SysRoleKey;
import com.gooagoo.dao.generator.sys.SysRoleMapper;

@Service
public class SysRoleGeneratorQueryServiceImpl implements SysRoleGeneratorQueryService
{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public Integer countByExample(SysRoleExample sysRoleExample) 
    {
        return this.sysRoleMapper.countByExample(sysRoleExample);
    }

    @Override
    public List<SysRole> selectByExample(SysRoleExample sysRoleExample) 
    {
        return this.sysRoleMapper.selectByExample(sysRoleExample);
    }

    @Override
    public SysRole selectUnDelByPrimaryKey(String primaryKey) 
    {
        SysRoleKey sysRoleKey = new SysRoleKey();
        sysRoleKey.setIsDel("N");
        sysRoleKey.setRoleId(primaryKey);
        return this.sysRoleMapper.selectByPrimaryKey(sysRoleKey);
    }

    @Override
    public SysRole selectByPrimaryKey(String primaryKey) 
    {
        SysRoleKey sysRoleKey = new SysRoleKey();
        sysRoleKey.setRoleId(primaryKey);
        return this.sysRoleMapper.selectByPrimaryKey(sysRoleKey);
    }

}
