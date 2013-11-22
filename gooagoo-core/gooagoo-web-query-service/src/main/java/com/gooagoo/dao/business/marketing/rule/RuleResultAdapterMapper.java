package com.gooagoo.dao.business.marketing.rule;

import java.util.List;

import com.gooagoo.entity.generator.marketing.RuleResult;

public interface RuleResultAdapterMapper
{

    /**
     * 查询有效、未删除、已发布、发布人群1,2的规则对应的规则结果 
     * @return
     */
    public List<RuleResult> findRuleResult();
}
