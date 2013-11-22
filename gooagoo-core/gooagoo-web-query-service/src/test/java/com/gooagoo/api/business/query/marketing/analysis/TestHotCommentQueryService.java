package com.gooagoo.api.business.query.marketing.analysis;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestHotCommentQueryService
{

    public HotCommentQueryService hotCommentQueryService;

    @Before
    public void testBefore()
    {
        this.hotCommentQueryService = ApplicationContextUtils.getBean(HotCommentQueryService.class);
    }

    /**
     * 热品商品（分页，根据个人定制）redis
     * @throws Exception
     */
    @Test
    public void testHotComment() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
