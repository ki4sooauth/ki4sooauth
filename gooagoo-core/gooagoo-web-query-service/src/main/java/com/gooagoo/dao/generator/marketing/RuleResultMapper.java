package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.marketing.RuleResultExample;
import com.gooagoo.entity.generator.marketing.RuleResultKey;

public interface RuleResultMapper
{

    public Integer countByExample(RuleResultExample ruleResultExample);

    public List<RuleResult> selectByExample(RuleResultExample ruleResultExample);

    public RuleResult selectByPrimaryKey(RuleResultKey ruleResultKey);

}
