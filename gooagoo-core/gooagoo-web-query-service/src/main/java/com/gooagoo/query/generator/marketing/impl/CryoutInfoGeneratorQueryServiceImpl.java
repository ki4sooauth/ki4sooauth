package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.entity.generator.marketing.CryoutInfoExample;
import com.gooagoo.entity.generator.marketing.CryoutInfoKey;
import com.gooagoo.dao.generator.marketing.CryoutInfoMapper;

@Service
public class CryoutInfoGeneratorQueryServiceImpl implements CryoutInfoGeneratorQueryService
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

}
