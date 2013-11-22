package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.SysRoleGeneratorCoreService;
import com.gooagoo.entity.generator.sys.SysRole;
import com.gooagoo.entity.generator.sys.SysRoleExample;
import com.gooagoo.entity.generator.sys.SysRoleKey;
import com.gooagoo.dao.generator.sys.SysRoleMapper;

@Service
public class SysRoleGeneratorCoreServiceImpl implements SysRoleGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(SysRoleExample sysRoleExample) 
    {
        return this.sysRoleMapper.deleteByExample(sysRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SysRoleKey sysRoleKey = new SysRoleKey();
        sysRoleKey.setRoleId(primaryKey);
        return this.sysRoleMapper.deleteByPrimaryKey(sysRoleKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysRoleExample sysRoleExample) 
    {
        SysRole sysRole = new SysRole();
        sysRole.setIsDel("Y");
        return this.sysRoleMapper.updateByExampleSelective(sysRole,sysRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        SysRole sysRole = new SysRole();
        sysRole.setRoleId(primaryKey);
        sysRole.setIsDel("Y");
        return this.sysRoleMapper.updateByPrimaryKeySelective(sysRole) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysRole sysRole) 
    {
        return this.sysRoleMapper.insertSelective(sysRole) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysRole sysRole,SysRoleExample sysRoleExample) 
    {
        return this.sysRoleMapper.updateByExampleSelective(sysRole,sysRoleExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysRole sysRole) 
    {
        return this.sysRoleMapper.updateByPrimaryKeySelective(sysRole) > 0 ? true : false;
    }

}
