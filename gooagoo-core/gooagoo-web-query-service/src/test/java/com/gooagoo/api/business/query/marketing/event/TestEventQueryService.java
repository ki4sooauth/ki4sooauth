package com.gooagoo.api.business.query.marketing.event;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestEventQueryService
{

    public EventQueryService eventQueryService;

    @Before
    public void testBefore()
    {
        this.eventQueryService = ApplicationContextUtils.getBean(EventQueryService.class);
    }

    /**
     * 6.6.5. 查看事件详情
     * @throws Exception
     */
    @Test
    public void testFindEventDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testFindEventList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
