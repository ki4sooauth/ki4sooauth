package com.gooagoo.query.business.marketing.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.marketing.rule.RuleResultQueryService;
import com.gooagoo.dao.business.marketing.rule.RuleResultAdapterMapper;
import com.gooagoo.entity.generator.marketing.RuleResult;

@Service
public class RuleResultQueryServiceImpl implements RuleResultQueryService
{

    @Autowired
    private RuleResultAdapterMapper ruleResultAdapterMapper;

    @Override
    public List<RuleResult> findRuleResultForCache() throws Exception
    {
        return this.ruleResultAdapterMapper.findRuleResult();
    }

}
