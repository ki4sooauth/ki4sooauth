package com.gooagoo.api.business.query.marketing.shortmessage;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShortMessageQueryService
{

    public ShortMessageQueryService shortMessageQueryService;

    @Before
    public void testBefore()
    {
        this.shortMessageQueryService = ApplicationContextUtils.getBean(ShortMessageQueryService.class);
    }

    /**
     * 6.5.5. 查看短信详情
     * @throws Exception
     */
    @Test
    public void testFindShortMessageDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testFindShortMessageList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
