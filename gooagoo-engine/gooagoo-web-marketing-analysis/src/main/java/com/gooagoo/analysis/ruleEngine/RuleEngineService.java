package com.gooagoo.analysis.ruleEngine;

import java.util.List;

import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.analysis.entity.RuleInput;

public interface RuleEngineService
{
    /**
     * 营销分析
     * @param obj   行为对象
     * @return 分析结果
     * @throws Exception
     */
    public List<RuleInfo> matchingRule(RuleInput ruleInput) throws Exception;
}
