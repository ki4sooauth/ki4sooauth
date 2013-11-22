package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.RuleInfoGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.RuleInfoKey;
import com.gooagoo.dao.generator.marketing.RuleInfoMapper;

@Service
public class RuleInfoGeneratorCoreServiceImpl implements RuleInfoGeneratorCoreService
{

    @Autowired
    private RuleInfoMapper ruleInfoMapper;

    @Override
    public Integer countByExample(RuleInfoExample ruleInfoExample) 
    {
        return this.ruleInfoMapper.countByExample(ruleInfoExample);
    }

    @Override
    public List<RuleInfo> selectByExample(RuleInfoExample ruleInfoExample) 
    {
        return this.ruleInfoMapper.selectByExample(ruleInfoExample);
    }

    @Override
    public RuleInfo selectUnDelByPrimaryKey(String primaryKey) 
    {
        RuleInfoKey ruleInfoKey = new RuleInfoKey();
        ruleInfoKey.setIsDel("N");
        ruleInfoKey.setRuleId(primaryKey);
        return this.ruleInfoMapper.selectByPrimaryKey(ruleInfoKey);
    }

    @Override
    public RuleInfo selectByPrimaryKey(String primaryKey) 
    {
        RuleInfoKey ruleInfoKey = new RuleInfoKey();
        ruleInfoKey.setRuleId(primaryKey);
        return this.ruleInfoMapper.selectByPrimaryKey(ruleInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(RuleInfoExample ruleInfoExample) 
    {
        return this.ruleInfoMapper.deleteByExample(ruleInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        RuleInfoKey ruleInfoKey = new RuleInfoKey();
        ruleInfoKey.setRuleId(primaryKey);
        return this.ruleInfoMapper.deleteByPrimaryKey(ruleInfoKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(RuleInfoExample ruleInfoExample) 
    {
        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setIsDel("Y");
        return this.ruleInfoMapper.updateByExampleSelective(ruleInfo,ruleInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        RuleInfo ruleInfo = new RuleInfo();
        ruleInfo.setRuleId(primaryKey);
        ruleInfo.setIsDel("Y");
        return this.ruleInfoMapper.updateByPrimaryKeySelective(ruleInfo) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(RuleInfo ruleInfo) 
    {
        return this.ruleInfoMapper.insertSelective(ruleInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(RuleInfo ruleInfo,RuleInfoExample ruleInfoExample) 
    {
        return this.ruleInfoMapper.updateByExampleSelective(ruleInfo,ruleInfoExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(RuleInfo ruleInfo) 
    {
        return this.ruleInfoMapper.updateByPrimaryKeySelective(ruleInfo) > 0 ? true : false;
    }

}
