package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.marketing.RuleResultExample;
import com.gooagoo.entity.generator.marketing.RuleResultKey;

public interface RuleResultMapper
{

    public Integer countByExample(RuleResultExample ruleResultExample);

    public List<RuleResult> selectByExample(RuleResultExample ruleResultExample);

    public RuleResult selectByPrimaryKey(RuleResultKey ruleResultKey);

    public Integer deleteByExample(RuleResultExample ruleResultExample);

    public Integer deleteByPrimaryKey(RuleResultKey ruleResultKey);

    public Integer insertSelective(RuleResult ruleResult);

    public Integer updateAllByExample(@Param("record") RuleResult ruleResult, @Param("example") RuleResultExample ruleResultExample);

    public Integer updateByExampleSelective(@Param("record") RuleResult ruleResult, @Param("example") RuleResultExample ruleResultExample);

    public Integer updateByPrimaryKeySelective(RuleResult ruleResult);

}
