package com.gooagoo.core.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.sys.MobileVersionGeneratorCoreService;
import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.entity.generator.sys.MobileVersionKey;
import com.gooagoo.dao.generator.sys.MobileVersionMapper;

@Service
public class MobileVersionGeneratorCoreServiceImpl implements MobileVersionGeneratorCoreService
{

    @Autowired
    private MobileVersionMapper mobileVersionMapper;

    @Override
    public Integer countByExample(MobileVersionExample mobileVersionExample) 
    {
        return this.mobileVersionMapper.countByExample(mobileVersionExample);
    }

    @Override
    public List<MobileVersion> selectByExample(MobileVersionExample mobileVersionExample) 
    {
        return this.mobileVersionMapper.selectByExample(mobileVersionExample);
    }

    @Override
    public MobileVersion selectUnDelByPrimaryKey(String primaryKey) 
    {
        MobileVersionKey mobileVersionKey = new MobileVersionKey();
        mobileVersionKey.setIsDel("N");
        mobileVersionKey.setId(primaryKey);
        return this.mobileVersionMapper.selectByPrimaryKey(mobileVersionKey);
    }

    @Override
    public MobileVersion selectByPrimaryKey(String primaryKey) 
    {
        MobileVersionKey mobileVersionKey = new MobileVersionKey();
        mobileVersionKey.setId(primaryKey);
        return this.mobileVersionMapper.selectByPrimaryKey(mobileVersionKey);
    }

    @Override
    public boolean physicalDeleteByExample(MobileVersionExample mobileVersionExample) 
    {
        return this.mobileVersionMapper.deleteByExample(mobileVersionExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        MobileVersionKey mobileVersionKey = new MobileVersionKey();
        mobileVersionKey.setId(primaryKey);
        return this.mobileVersionMapper.deleteByPrimaryKey(mobileVersionKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(MobileVersionExample mobileVersionExample) 
    {
        MobileVersion mobileVersion = new MobileVersion();
        mobileVersion.setIsDel("Y");
        return this.mobileVersionMapper.updateByExampleSelective(mobileVersion,mobileVersionExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        MobileVersion mobileVersion = new MobileVersion();
        mobileVersion.setId(primaryKey);
        mobileVersion.setIsDel("Y");
        return this.mobileVersionMapper.updateByPrimaryKeySelective(mobileVersion) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(MobileVersion mobileVersion) 
    {
        return this.mobileVersionMapper.insertSelective(mobileVersion) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(MobileVersion mobileVersion,MobileVersionExample mobileVersionExample) 
    {
        return this.mobileVersionMapper.updateByExampleSelective(mobileVersion,mobileVersionExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(MobileVersion mobileVersion) 
    {
        return this.mobileVersionMapper.updateByPrimaryKeySelective(mobileVersion) > 0 ? true : false;
    }

}
