package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestMemberStatisticQueryService
{

    public MemberStatisticQueryService memberStatisticQueryService;

    @Before
    public void testBefore()
    {
        this.memberStatisticQueryService = ApplicationContextUtils.getBean(MemberStatisticQueryService.class);
    }

    /**
     * 商家关注用户
     * @throws Exception
     */
    @Test
    public void testFindAttention() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 商家会员用户
     * @throws Exception
     */
    @Test
    public void testFindMember() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
