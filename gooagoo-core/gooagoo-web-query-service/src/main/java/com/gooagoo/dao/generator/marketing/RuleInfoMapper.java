package com.gooagoo.dao.generator.marketing;

import java.util.List;

import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.RuleInfoKey;

public interface RuleInfoMapper
{

    public Integer countByExample(RuleInfoExample ruleInfoExample);

    public List<RuleInfo> selectByExample(RuleInfoExample ruleInfoExample);

    public RuleInfo selectByPrimaryKey(RuleInfoKey ruleInfoKey);

}
