package com.gooagoo.query.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.member.IntegralDetailInfoGeneratorQueryService;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralDetailInfoExample;
import com.gooagoo.entity.generator.member.IntegralDetailInfoKey;
import com.gooagoo.dao.generator.member.IntegralDetailInfoMapper;

@Service
public class IntegralDetailInfoGeneratorQueryServiceImpl implements IntegralDetailInfoGeneratorQueryService
{

    @Autowired
    private IntegralDetailInfoMapper integralDetailInfoMapper;

    @Override
    public Integer countByExample(IntegralDetailInfoExample integralDetailInfoExample) 
    {
        return this.integralDetailInfoMapper.countByExample(integralDetailInfoExample);
    }

    @Override
    public List<IntegralDetailInfo> selectByExample(IntegralDetailInfoExample integralDetailInfoExample) 
    {
        return this.integralDetailInfoMapper.selectByExample(integralDetailInfoExample);
    }

    @Override
    public IntegralDetailInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        IntegralDetailInfoKey integralDetailInfoKey = new IntegralDetailInfoKey();
        integralDetailInfoKey.setIsDel("N");
        integralDetailInfoKey.setIntegralId(primaryKey);
        return this.integralDetailInfoMapper.selectByPrimaryKey(integralDetailInfoKey);
    }

    @Override
    public IntegralDetailInfo selectByPrimaryKey(String primaryKey) 
    {
        IntegralDetailInfoKey integralDetailInfoKey = new IntegralDetailInfoKey();
        integralDetailInfoKey.setIntegralId(primaryKey);
        return this.integralDetailInfoMapper.selectByPrimaryKey(integralDetailInfoKey);
    }

}
