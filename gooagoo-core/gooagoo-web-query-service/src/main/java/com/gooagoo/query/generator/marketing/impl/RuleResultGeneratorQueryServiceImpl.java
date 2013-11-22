package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.RuleResultGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.marketing.RuleResultExample;
import com.gooagoo.entity.generator.marketing.RuleResultKey;
import com.gooagoo.dao.generator.marketing.RuleResultMapper;

@Service
public class RuleResultGeneratorQueryServiceImpl implements RuleResultGeneratorQueryService
{

    @Autowired
    private RuleResultMapper ruleResultMapper;

    @Override
    public Integer countByExample(RuleResultExample ruleResultExample) 
    {
        return this.ruleResultMapper.countByExample(ruleResultExample);
    }

    @Override
    public List<RuleResult> selectByExample(RuleResultExample ruleResultExample) 
    {
        return this.ruleResultMapper.selectByExample(ruleResultExample);
    }

    @Override
    public RuleResult selectUnDelByPrimaryKey(String primaryKey) 
    {
        RuleResultKey ruleResultKey = new RuleResultKey();
        ruleResultKey.setIsDel("N");
        ruleResultKey.setRuleResultId(primaryKey);
        return this.ruleResultMapper.selectByPrimaryKey(ruleResultKey);
    }

    @Override
    public RuleResult selectByPrimaryKey(String primaryKey) 
    {
        RuleResultKey ruleResultKey = new RuleResultKey();
        ruleResultKey.setRuleResultId(primaryKey);
        return this.ruleResultMapper.selectByPrimaryKey(ruleResultKey);
    }

}
