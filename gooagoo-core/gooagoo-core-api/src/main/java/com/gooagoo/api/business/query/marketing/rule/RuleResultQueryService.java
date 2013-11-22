package com.gooagoo.api.business.query.marketing.rule;

import java.util.List;

import com.gooagoo.entity.generator.marketing.RuleResult;

public interface RuleResultQueryService
{
    /**
     * 查询有效、未删除、已发布、发布人群1,2的规则对应的规则结果 
     * @return
     * @throws Exception
     */
    public List<RuleResult> findRuleResultForCache() throws Exception;

}
