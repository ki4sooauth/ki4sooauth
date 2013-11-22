package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.RuleInfoGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.RuleInfoKey;
import com.gooagoo.dao.generator.marketing.RuleInfoMapper;

@Service
public class RuleInfoGeneratorQueryServiceImpl implements RuleInfoGeneratorQueryService
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

}
