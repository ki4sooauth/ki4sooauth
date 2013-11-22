package com.gooagoo.api.business.query.member.cache;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestMemberCacheQueryService
{

    public MemberCacheQueryService memberCacheQueryService;

    @Before
    public void testBefore()
    {
        this.memberCacheQueryService = ApplicationContextUtils.getBean(MemberCacheQueryService.class);
    }

    /**
     * 用户会员信息(类型(A关注,M会员)、电子卡号、物理卡号、积分)
     * @throws Exception
     */
    @Test
    public void testFindMembeInfo() throws Exception
    {

        Map<String, String> m = memberCacheQueryService.findMembeInfo("185JPQM4F8KPMB00A1BAQJMCHPSLC0AK", "185EVK63KPRTKH00A1BAQJMCA2H349CC");
        System.out.println(m.size());
    }

    /**
     * 用户会员信息(类型(A关注,M会员)、电子卡号、物理卡号、积分)
     * @throws Exception
     */
    @Test
    public void testFindMembeInfoByScardno() throws Exception
    {

        Assert.assertNotNull("", "");
    }

}
