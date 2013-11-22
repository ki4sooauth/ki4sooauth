package com.gooagoo.dao.generator.marketing;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleInfoExample;
import com.gooagoo.entity.generator.marketing.RuleInfoKey;

public interface RuleInfoMapper
{

    public Integer countByExample(RuleInfoExample ruleInfoExample);

    public List<RuleInfo> selectByExample(RuleInfoExample ruleInfoExample);

    public RuleInfo selectByPrimaryKey(RuleInfoKey ruleInfoKey);

    public Integer deleteByExample(RuleInfoExample ruleInfoExample);

    public Integer deleteByPrimaryKey(RuleInfoKey ruleInfoKey);

    public Integer insertSelective(RuleInfo ruleInfo);

    public Integer updateAllByExample(@Param("record") RuleInfo ruleInfo, @Param("example") RuleInfoExample ruleInfoExample);

    public Integer updateByExampleSelective(@Param("record") RuleInfo ruleInfo, @Param("example") RuleInfoExample ruleInfoExample);

    public Integer updateByPrimaryKeySelective(RuleInfo ruleInfo);

}
