package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.SysUserRoleGeneratorQueryService;
import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.entity.generator.sys.SysUserRoleKey;
import com.gooagoo.dao.generator.sys.SysUserRoleMapper;

@Service
public class SysUserRoleGeneratorQueryServiceImpl implements SysUserRoleGeneratorQueryService
{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public Integer countByExample(SysUserRoleExample sysUserRoleExample) 
    {
        return this.sysUserRoleMapper.countByExample(sysUserRoleExample);
    }

    @Override
    public List<SysUserRole> selectByExample(SysUserRoleExample sysUserRoleExample) 
    {
        return this.sysUserRoleMapper.selectByExample(sysUserRoleExample);
    }

    @Override
    public SysUserRole selectUnDelByPrimaryKey(String primaryKey) 
    {
        SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
        sysUserRoleKey.setIsDel("N");
        sysUserRoleKey.setSysUserRoleId(primaryKey);
        return this.sysUserRoleMapper.selectByPrimaryKey(sysUserRoleKey);
    }

    @Override
    public SysUserRole selectByPrimaryKey(String primaryKey) 
    {
        SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
        sysUserRoleKey.setSysUserRoleId(primaryKey);
        return this.sysUserRoleMapper.selectByPrimaryKey(sysUserRoleKey);
    }

}
