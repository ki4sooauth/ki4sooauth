package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.IntegralInfoKey;
import com.gooagoo.dao.generator.member.IntegralInfoMapper;

@Service
public class IntegralInfoGeneratorQueryServiceImpl implements IntegralInfoGeneratorQueryService
{

    @Autowired
    private IntegralInfoMapper integralInfoMapper;

    @Override
    public Integer countByExample(IntegralInfoExample integralInfoExample) 
    {
        return this.integralInfoMapper.countByExample(integralInfoExample);
    }

    @Override
    public List<IntegralInfo> selectByExample(IntegralInfoExample integralInfoExample) 
    {
        return this.integralInfoMapper.selectByExample(integralInfoExample);
    }

    @Override
    public IntegralInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        IntegralInfoKey integralInfoKey = new IntegralInfoKey();
        integralInfoKey.setIsDel("N");
        integralInfoKey.setIntegralId(primaryKey);
        return this.integralInfoMapper.selectByPrimaryKey(integralInfoKey);
    }

    @Override
    public IntegralInfo selectByPrimaryKey(String primaryKey) 
    {
        IntegralInfoKey integralInfoKey = new IntegralInfoKey();
        integralInfoKey.setIntegralId(primaryKey);
        return this.integralInfoMapper.selectByPrimaryKey(integralInfoKey);
    }

}
