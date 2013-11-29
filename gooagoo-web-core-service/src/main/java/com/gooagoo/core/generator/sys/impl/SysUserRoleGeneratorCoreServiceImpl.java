package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.SysUserRoleGeneratorCoreService;
import com.gooagoo.entity.generator.sys.SysUserRole;
import com.gooagoo.entity.generator.sys.SysUserRoleExample;
import com.gooagoo.entity.generator.sys.SysUserRoleKey;
import com.gooagoo.dao.generator.sys.SysUserRoleMapper;

@Service
public class SysUserRoleGeneratorCoreServiceImpl implements SysUserRoleGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(SysUserRoleExample sysUserRoleExample) 
    {
        return this.sysUserRoleMapper.deleteByExample(sysUserRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
        sysUserRoleKey.setSysUserRoleId(primaryKey);
        return this.sysUserRoleMapper.deleteByPrimaryKey(sysUserRoleKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysUserRoleExample sysUserRoleExample) 
    {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setIsDel("Y");
        return this.sysUserRoleMapper.updateByExampleSelective(sysUserRole,sysUserRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setSysUserRoleId(primaryKey);
        sysUserRole.setIsDel("Y");
        return this.sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysUserRole sysUserRole) 
    {
        return this.sysUserRoleMapper.insertSelective(sysUserRole) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysUserRole sysUserRole,SysUserRoleExample sysUserRoleExample) 
    {
        return this.sysUserRoleMapper.updateByExampleSelective(sysUserRole,sysUserRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysUserRole sysUserRole) 
    {
        return this.sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole) > 0 ? true : false;
    }

}
