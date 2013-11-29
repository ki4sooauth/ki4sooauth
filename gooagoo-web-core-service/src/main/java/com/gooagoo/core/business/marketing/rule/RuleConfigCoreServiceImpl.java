package com.gooagoo.core.business.marketing.rule;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.gooagoo.api.business.core.marketing.rule.RuleConfigCoreService;
import com.gooagoo.api.generator.core.marketing.RuleConfigGeneratorCoreService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;

public class RuleConfigCoreServiceImpl implements RuleConfigCoreService
{

    @Autowired
    private RuleConfigGeneratorCoreService ruleConfigGeneratorCoreService;

    @Override
    public boolean addRuleConfig(RuleConfig ruleConfig) throws Exception
    {
        ruleConfig.setId(UUID.getUUID());
        ruleConfig.setIsDel("N");
        return this.ruleConfigGeneratorCoreService.insertSelective(ruleConfig);
    }

    @Override
    public boolean updateRuleConfig(RuleConfig ruleConfig) throws Exception
    {
        return this.ruleConfigGeneratorCoreService.updateByPrimaryKeySelective(ruleConfig);
    }

    @Override
    public boolean deleteRuleConfig(String ids) throws Exception
    {
        if (StringUtils.isEmpty(ids))
        {
            return false;
        }
        List<String> idList = Arrays.asList(ids.split(","));
        RuleConfigExample ruleConfigExample = new RuleConfigExample();
        ruleConfigExample.createCriteria().andIdIn(idList).andIsDelEqualTo("N");
        RuleConfig ruleConfig = new RuleConfig();
        ruleConfig.setIsDel("Y");
        return this.ruleConfigGeneratorCoreService.updateByExampleSelective(ruleConfig, ruleConfigExample);
    }
}
