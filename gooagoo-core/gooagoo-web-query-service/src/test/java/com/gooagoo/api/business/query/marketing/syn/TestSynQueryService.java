package com.gooagoo.api.business.query.marketing.syn;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestSynQueryService
{

    public SynQueryService synQueryService;

    @Before
    public void testBefore()
    {
        this.synQueryService = ApplicationContextUtils.getBean(SynQueryService.class);
    }

    /**
     * 原营销引擎同步
     * @throws Exception
     */
    @Test
    public void testSynQueryForEvent() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
