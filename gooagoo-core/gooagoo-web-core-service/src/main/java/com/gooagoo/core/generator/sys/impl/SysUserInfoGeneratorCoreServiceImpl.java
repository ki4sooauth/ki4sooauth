package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.SysUserInfoGeneratorCoreService;
import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserInfoExample;
import com.gooagoo.entity.generator.sys.SysUserInfoKey;
import com.gooagoo.dao.generator.sys.SysUserInfoMapper;

@Service
public class SysUserInfoGeneratorCoreServiceImpl implements SysUserInfoGeneratorCoreService
{

    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @Override
    public Integer countByExample(SysUserInfoExample sysUserInfoExample) 
    {
        return this.sysUserInfoMapper.countByExample(sysUserInfoExample);
    }

    @Override
    public List<SysUserInfo> selectByExample(SysUserInfoExample sysUserInfoExample) 
    {
        return this.sysUserInfoMapper.selectByExample(sysUserInfoExample);
    }

    @Override
    public SysUserInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        SysUserInfoKey sysUserInfoKey = new SysUserInfoKey();
        sysUserInfoKey.setIsDel("N");
        sysUserInfoKey.setUserId(primaryKey);
        return this.sysUserInfoMapper.selectByPrimaryKey(sysUserInfoKey);
    }

    @Override
    public SysUserInfo selectByPrimaryKey(String primaryKey) 
    {
        SysUserInfoKey sysUserInfoKey = new SysUserInfoKey();
        sysUserInfoKey.setUserId(primaryKey);
        return this.sysUserInfoMapper.selectByPrimaryKey(sysUserInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(SysUserInfoExample sysUserInfoExample) 
    {
        return this.sysUserInfoMapper.deleteByExample(sysUserInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        SysUserInfoKey sysUserInfoKey = new SysUserInfoKey();
        sysUserInfoKey.setUserId(primaryKey);
        return this.sysUserInfoMapper.deleteByPrimaryKey(sysUserInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(SysUserInfoExample sysUserInfoExample) 
    {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setIsDel("Y");
        return this.sysUserInfoMapper.updateByExampleSelective(sysUserInfo,sysUserInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setUserId(primaryKey);
        sysUserInfo.setIsDel("Y");
        return this.sysUserInfoMapper.updateByPrimaryKeySelective(sysUserInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(SysUserInfo sysUserInfo) 
    {
        return this.sysUserInfoMapper.insertSelective(sysUserInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(SysUserInfo sysUserInfo,SysUserInfoExample sysUserInfoExample) 
    {
        return this.sysUserInfoMapper.updateByExampleSelective(sysUserInfo,sysUserInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(SysUserInfo sysUserInfo) 
    {
        return this.sysUserInfoMapper.updateByPrimaryKeySelective(sysUserInfo) > 0 ? true : false;
    }

}
