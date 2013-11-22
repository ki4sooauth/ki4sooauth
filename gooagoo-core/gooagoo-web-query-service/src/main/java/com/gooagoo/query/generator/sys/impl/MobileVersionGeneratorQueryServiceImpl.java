package com.gooagoo.query.generator.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.sys.MobileVersionGeneratorQueryService;
import com.gooagoo.entity.generator.sys.MobileVersion;
import com.gooagoo.entity.generator.sys.MobileVersionExample;
import com.gooagoo.entity.generator.sys.MobileVersionKey;
import com.gooagoo.dao.generator.sys.MobileVersionMapper;

@Service
public class MobileVersionGeneratorQueryServiceImpl implements MobileVersionGeneratorQueryService
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

}
