package com.gooagoo.api.business.query.statistics.user;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestCryoutStatisticQueryService
{

    public CryoutStatisticQueryService cryoutStatisticService;

    @Before
    public void testBefore()
    {
        this.cryoutStatisticService = ApplicationContextUtils.getBean(CryoutStatisticQueryService.class);
    }

    /**
     * 他们在说
     * @throws Exception
     */
    @Test
    public void testQueryCryoutings() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
