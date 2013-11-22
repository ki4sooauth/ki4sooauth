package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.SysUserInfoGeneratorQueryService;
import com.gooagoo.entity.generator.sys.SysUserInfo;
import com.gooagoo.entity.generator.sys.SysUserInfoExample;
import com.gooagoo.entity.generator.sys.SysUserInfoKey;
import com.gooagoo.dao.generator.sys.SysUserInfoMapper;

@Service
public class SysUserInfoGeneratorQueryServiceImpl implements SysUserInfoGeneratorQueryService
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

}
