package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.CryoutInfoGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.CryoutInfoKey;
import com.gooagoo.dao.generator.marketing.CryoutInfoMapper;

@Service
public class CryoutInfoGeneratorCoreServiceImpl implements CryoutInfoGeneratorCoreService
{

    @Autowired
    private CryoutInfoMapper cryoutInfoMapper;

    @Override
    public Integer countByExample(CryoutInfoExample cryoutInfoExample) 
    {
        return this.cryoutInfoMapper.countByExample(cryoutInfoExample);
    }

    @Override
    public List<CryoutInfo> selectByExample(CryoutInfoExample cryoutInfoExample) 
    {
        return this.cryoutInfoMapper.selectByExample(cryoutInfoExample);
    }

    @Override
    public CryoutInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        CryoutInfoKey cryoutInfoKey = new CryoutInfoKey();
        cryoutInfoKey.setIsDel("N");
        cryoutInfoKey.setCryoutInfoId(primaryKey);
        return this.cryoutInfoMapper.selectByPrimaryKey(cryoutInfoKey);
    }

    @Override
    public CryoutInfo selectByPrimaryKey(String primaryKey) 
    {
        CryoutInfoKey cryoutInfoKey = new CryoutInfoKey();
        cryoutInfoKey.setCryoutInfoId(primaryKey);
        return this.cryoutInfoMapper.selectByPrimaryKey(cryoutInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(CryoutInfoExample cryoutInfoExample) 
    {
        return this.cryoutInfoMapper.deleteByExample(cryoutInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        CryoutInfoKey cryoutInfoKey = new CryoutInfoKey();
        cryoutInfoKey.setCryoutInfoId(primaryKey);
        return this.cryoutInfoMapper.deleteByPrimaryKey(cryoutInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(CryoutInfoExample cryoutInfoExample) 
    {
        CryoutInfo cryoutInfo = new CryoutInfo();
        cryoutInfo.setIsDel("Y");
        return this.cryoutInfoMapper.updateByExampleSelective(cryoutInfo,cryoutInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        CryoutInfo cryoutInfo = new CryoutInfo();
        cryoutInfo.setCryoutInfoId(primaryKey);
        cryoutInfo.setIsDel("Y");
        return this.cryoutInfoMapper.updateByPrimaryKeySelective(cryoutInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(CryoutInfo cryoutInfo) 
    {
        return this.cryoutInfoMapper.insertSelective(cryoutInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(CryoutInfo cryoutInfo,CryoutInfoExample cryoutInfoExample) 
    {
        return this.cryoutInfoMapper.updateByExampleSelective(cryoutInfo,cryoutInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(CryoutInfo cryoutInfo) 
    {
        return this.cryoutInfoMapper.updateByPrimaryKeySelective(cryoutInfo) > 0 ? true : false;
    }

}
