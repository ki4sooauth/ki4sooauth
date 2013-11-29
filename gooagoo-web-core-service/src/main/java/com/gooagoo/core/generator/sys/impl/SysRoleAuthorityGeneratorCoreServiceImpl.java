package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.SysRoleAuthorityGeneratorCoreService;
import com.gooagoo.entity.generator.sys.SysRoleAuthority;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityExample;
import com.gooagoo.entity.generator.sys.SysRoleAuthorityKey;
import com.gooagoo.dao.generator.sys.SysRoleAuthorityMapper;

@Service
public class SysRoleAuthorityGeneratorCoreServiceImpl implements SysRoleAuthorityGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(SysRoleAuthorityExample sysRoleAuthorityExample) 
    {
        return this.sysRoleAuthorityMapper.deleteByExample(sysRoleAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SysRoleAuthorityKey sysRoleAuthorityKey = new SysRoleAuthorityKey();
        sysRoleAuthorityKey.setSysRoleAuthorityId(primaryKey);
        return this.sysRoleAuthorityMapper.deleteByPrimaryKey(sysRoleAuthorityKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysRoleAuthorityExample sysRoleAuthorityExample) 
    {
        SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
        sysRoleAuthority.setIsDel("Y");
        return this.sysRoleAuthorityMapper.updateByExampleSelective(sysRoleAuthority,sysRoleAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        SysRoleAuthority sysRoleAuthority = new SysRoleAuthority();
        sysRoleAuthority.setSysRoleAuthorityId(primaryKey);
        sysRoleAuthority.setIsDel("Y");
        return this.sysRoleAuthorityMapper.updateByPrimaryKeySelective(sysRoleAuthority) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysRoleAuthority sysRoleAuthority) 
    {
        return this.sysRoleAuthorityMapper.insertSelective(sysRoleAuthority) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysRoleAuthority sysRoleAuthority,SysRoleAuthorityExample sysRoleAuthorityExample) 
    {
        return this.sysRoleAuthorityMapper.updateByExampleSelective(sysRoleAuthority,sysRoleAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysRoleAuthority sysRoleAuthority) 
    {
        return this.sysRoleAuthorityMapper.updateByPrimaryKeySelective(sysRoleAuthority) > 0 ? true : false;
    }

}
