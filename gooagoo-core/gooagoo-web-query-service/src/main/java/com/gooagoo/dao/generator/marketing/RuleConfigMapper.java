package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;
import com.gooagoo.entity.generator.marketing.RuleConfigKey;

public interface RuleConfigMapper
{

    public Integer countByExample(RuleConfigExample ruleConfigExample);

    public List<RuleConfig> selectByExample(RuleConfigExample ruleConfigExample);

    public RuleConfig selectByPrimaryKey(RuleConfigKey ruleConfigKey);

}
