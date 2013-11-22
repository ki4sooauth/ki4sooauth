package com.gooagoo.core.generator.marketing.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.marketing.RuleConfigGeneratorCoreService;
import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;
import com.gooagoo.entity.generator.marketing.RuleConfigKey;
import com.gooagoo.dao.generator.marketing.RuleConfigMapper;

@Service
public class RuleConfigGeneratorCoreServiceImpl implements RuleConfigGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(RuleConfigExample ruleConfigExample) 
    {
        return this.ruleConfigMapper.deleteByExample(ruleConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        RuleConfigKey ruleConfigKey = new RuleConfigKey();
        ruleConfigKey.setId(primaryKey);
        return this.ruleConfigMapper.deleteByPrimaryKey(ruleConfigKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(RuleConfigExample ruleConfigExample) 
    {
        RuleConfig ruleConfig = new RuleConfig();
        ruleConfig.setIsDel("Y");
        return this.ruleConfigMapper.updateByExampleSelective(ruleConfig,ruleConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        RuleConfig ruleConfig = new RuleConfig();
        ruleConfig.setId(primaryKey);
        ruleConfig.setIsDel("Y");
        return this.ruleConfigMapper.updateByPrimaryKeySelective(ruleConfig) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(RuleConfig ruleConfig) 
    {
        return this.ruleConfigMapper.insertSelective(ruleConfig) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(RuleConfig ruleConfig,RuleConfigExample ruleConfigExample) 
    {
        return this.ruleConfigMapper.updateByExampleSelective(ruleConfig,ruleConfigExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(RuleConfig ruleConfig) 
    {
        return this.ruleConfigMapper.updateByPrimaryKeySelective(ruleConfig) > 0 ? true : false;
    }

}
