package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.RuleResultGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.marketing.RuleResultExample;
import com.gooagoo.entity.generator.marketing.RuleResultKey;
import com.gooagoo.dao.generator.marketing.RuleResultMapper;

@Service
public class RuleResultGeneratorCoreServiceImpl implements RuleResultGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(RuleResultExample ruleResultExample) 
    {
        return this.ruleResultMapper.deleteByExample(ruleResultExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        RuleResultKey ruleResultKey = new RuleResultKey();
        ruleResultKey.setRuleResultId(primaryKey);
        return this.ruleResultMapper.deleteByPrimaryKey(ruleResultKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(RuleResultExample ruleResultExample) 
    {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setIsDel("Y");
        return this.ruleResultMapper.updateByExampleSelective(ruleResult,ruleResultExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        RuleResult ruleResult = new RuleResult();
        ruleResult.setRuleResultId(primaryKey);
        ruleResult.setIsDel("Y");
        return this.ruleResultMapper.updateByPrimaryKeySelective(ruleResult) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(RuleResult ruleResult) 
    {
        return this.ruleResultMapper.insertSelective(ruleResult) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(RuleResult ruleResult,RuleResultExample ruleResultExample) 
    {
        return this.ruleResultMapper.updateByExampleSelective(ruleResult,ruleResultExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(RuleResult ruleResult) 
    {
        return this.ruleResultMapper.updateByPrimaryKeySelective(ruleResult) > 0 ? true : false;
    }

}
