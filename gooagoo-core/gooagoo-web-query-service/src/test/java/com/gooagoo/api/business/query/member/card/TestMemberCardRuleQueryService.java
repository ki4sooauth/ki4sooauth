package com.gooagoo.api.business.query.member.card;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestMemberCardRuleQueryService
{

    public MemberCardRuleQueryService memberCardRuleQueryService;

    @Before
    public void testBefore()
    {
        this.memberCardRuleQueryService = ApplicationContextUtils.getBean(MemberCardRuleQueryService.class);
    }

    /**
     * 商家查询发卡规则详细信息
     * @throws Exception
     */
    @Test
    public void testFindMemberCardRule() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
