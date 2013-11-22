package com.gooagoo.api.business.query.log;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestLogQueryService
{

    public LogQueryService logQueryService;

    @Before
    public void testBefore()
    {
        this.logQueryService = ApplicationContextUtils.getBean(LogQueryService.class);
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testSelectBehaveLog() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testSelectShopLog() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testSelectSysLog() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
