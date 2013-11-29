package com.gooagoo.core.generator.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.member.IntegralDetailInfoGeneratorCoreService;
import com.gooagoo.entity.generator.member.IntegralDetailInfo;
import com.gooagoo.entity.generator.member.IntegralDetailInfoExample;
import com.gooagoo.entity.generator.member.IntegralDetailInfoKey;
import com.gooagoo.dao.generator.member.IntegralDetailInfoMapper;

@Service
public class IntegralDetailInfoGeneratorCoreServiceImpl implements IntegralDetailInfoGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(IntegralDetailInfoExample integralDetailInfoExample) 
    {
        return this.integralDetailInfoMapper.deleteByExample(integralDetailInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        IntegralDetailInfoKey integralDetailInfoKey = new IntegralDetailInfoKey();
        integralDetailInfoKey.setIntegralId(primaryKey);
        return this.integralDetailInfoMapper.deleteByPrimaryKey(integralDetailInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(IntegralDetailInfoExample integralDetailInfoExample) 
    {
        IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
        integralDetailInfo.setIsDel("Y");
        return this.integralDetailInfoMapper.updateByExampleSelective(integralDetailInfo,integralDetailInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        IntegralDetailInfo integralDetailInfo = new IntegralDetailInfo();
        integralDetailInfo.setIntegralId(primaryKey);
        integralDetailInfo.setIsDel("Y");
        return this.integralDetailInfoMapper.updateByPrimaryKeySelective(integralDetailInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(IntegralDetailInfo integralDetailInfo) 
    {
        return this.integralDetailInfoMapper.insertSelective(integralDetailInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(IntegralDetailInfo integralDetailInfo,IntegralDetailInfoExample integralDetailInfoExample) 
    {
        return this.integralDetailInfoMapper.updateByExampleSelective(integralDetailInfo,integralDetailInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(IntegralDetailInfo integralDetailInfo) 
    {
        return this.integralDetailInfoMapper.updateByPrimaryKeySelective(integralDetailInfo) > 0 ? true : false;
    }

}
