package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.SysAuthorityGeneratorCoreService;
import com.gooagoo.entity.generator.sys.SysAuthority;
import com.gooagoo.entity.generator.sys.SysAuthorityExample;
import com.gooagoo.entity.generator.sys.SysAuthorityKey;
import com.gooagoo.dao.generator.sys.SysAuthorityMapper;

@Service
public class SysAuthorityGeneratorCoreServiceImpl implements SysAuthorityGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(SysAuthorityExample sysAuthorityExample) 
    {
        return this.sysAuthorityMapper.deleteByExample(sysAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SysAuthorityKey sysAuthorityKey = new SysAuthorityKey();
        sysAuthorityKey.setAuthorityId(primaryKey);
        return this.sysAuthorityMapper.deleteByPrimaryKey(sysAuthorityKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysAuthorityExample sysAuthorityExample) 
    {
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setIsDel("Y");
        return this.sysAuthorityMapper.updateByExampleSelective(sysAuthority,sysAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        SysAuthority sysAuthority = new SysAuthority();
        sysAuthority.setAuthorityId(primaryKey);
        sysAuthority.setIsDel("Y");
        return this.sysAuthorityMapper.updateByPrimaryKeySelective(sysAuthority) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysAuthority sysAuthority) 
    {
        return this.sysAuthorityMapper.insertSelective(sysAuthority) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysAuthority sysAuthority,SysAuthorityExample sysAuthorityExample) 
    {
        return this.sysAuthorityMapper.updateByExampleSelective(sysAuthority,sysAuthorityExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysAuthority sysAuthority) 
    {
        return this.sysAuthorityMapper.updateByPrimaryKeySelective(sysAuthority) > 0 ? true : false;
    }

}
