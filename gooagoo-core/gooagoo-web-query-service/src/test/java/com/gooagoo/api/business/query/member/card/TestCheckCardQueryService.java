package com.gooagoo.api.business.query.member.card;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestCheckCardQueryService
{

    public CheckCardQueryService checkCardQueryService;

    @Before
    public void testBefore()
    {
        this.checkCardQueryService = ApplicationContextUtils.getBean(CheckCardQueryService.class);
    }

    /**
     * gtsc11
     * @throws Exception
     */
    @Test
    public void testCheckCard() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
