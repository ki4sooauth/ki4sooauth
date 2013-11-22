package com.gooagoo.api.business.query.marketing.rule;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestRuleResultQueryService
{

    public RuleResultQueryService ruleResultQueryService;

    @Before
    public void testBefore()
    {
        this.ruleResultQueryService = ApplicationContextUtils.getBean(RuleResultQueryService.class);
    }

    /**
     * 推荐商品列表（分页查推荐有效期内的商品）
     * @throws Exception
     */
    @Test
    public void testFindRuleResultForCache() throws Exception
    {
        Assert.assertNull("查询有效、未删除、已发布、发布人群1,2的规则对应的规则结果为空", this.ruleResultQueryService.findRuleResultForCache());
    }

}
