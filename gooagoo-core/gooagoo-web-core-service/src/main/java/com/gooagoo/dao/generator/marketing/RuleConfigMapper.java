package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.RuleConfig;
import com.gooagoo.entity.generator.marketing.RuleConfigExample;
import com.gooagoo.entity.generator.marketing.RuleConfigKey;

public interface RuleConfigMapper
{

    public Integer countByExample(RuleConfigExample ruleConfigExample);

    public List<RuleConfig> selectByExample(RuleConfigExample ruleConfigExample);

    public RuleConfig selectByPrimaryKey(RuleConfigKey ruleConfigKey);

    public Integer deleteByExample(RuleConfigExample ruleConfigExample);

    public Integer deleteByPrimaryKey(RuleConfigKey ruleConfigKey);

    public Integer insertSelective(RuleConfig ruleConfig);

    public Integer updateAllByExample(@Param("record") RuleConfig ruleConfig, @Param("example") RuleConfigExample ruleConfigExample);

    public Integer updateByExampleSelective(@Param("record") RuleConfig ruleConfig, @Param("example") RuleConfigExample ruleConfigExample);

    public Integer updateByPrimaryKeySelective(RuleConfig ruleConfig);

}
