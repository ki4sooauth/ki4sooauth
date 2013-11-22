package com.gooagoo.query.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.marketing.RuleConfigGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;
import com.gooagoo.entity.generator.marketing.RuleConfigKey;
import com.gooagoo.dao.generator.marketing.RuleConfigMapper;

@Service
public class RuleConfigGeneratorQueryServiceImpl implements RuleConfigGeneratorQueryService
{

    @Autowired
    private RuleConfigMapper ruleConfigMapper;

    @Override
    public Integer countByExample(RuleConfigExample ruleConfigExample) 
    {
        return this.ruleConfigMapper.countByExample(ruleConfigExample);
    }

    @Override
    public List<RuleConfig> selectByExample(RuleConfigExample ruleConfigExample) 
    {
        return this.ruleConfigMapper.selectByExample(ruleConfigExample);
    }

    @Override
    public RuleConfig selectUnDelByPrimaryKey(String primaryKey) 
    {
        RuleConfigKey ruleConfigKey = new RuleConfigKey();
        ruleConfigKey.setIsDel("N");
        ruleConfigKey.setId(primaryKey);
        return this.ruleConfigMapper.selectByPrimaryKey(ruleConfigKey);
    }

    @Override
    public RuleConfig selectByPrimaryKey(String primaryKey) 
    {
        RuleConfigKey ruleConfigKey = new RuleConfigKey();
        ruleConfigKey.setId(primaryKey);
        return this.ruleConfigMapper.selectByPrimaryKey(ruleConfigKey);
    }

}
