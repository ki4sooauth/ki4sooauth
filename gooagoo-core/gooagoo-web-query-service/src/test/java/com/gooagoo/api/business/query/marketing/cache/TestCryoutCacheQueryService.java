package com.gooagoo.api.business.query.marketing.cache;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestCryoutCacheQueryService
{

    public CryoutCacheQueryService cryoutCacheQueryService;

    @Before
    public void testBefore()
    {
        this.cryoutCacheQueryService = ApplicationContextUtils.getBean(CryoutCacheQueryService.class);
    }

    /**
     * 查询吆喝
     * @throws Exception
     */
    @Test
    public void testFindUserCryout() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
