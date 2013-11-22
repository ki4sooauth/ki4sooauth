package com.gooagoo.api.business.query.marketing.analysis;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestHotSellersQueryService
{

    public HotSellersQueryService hotSellersQueryService;

    @Before
    public void testBefore()
    {
        this.hotSellersQueryService = ApplicationContextUtils.getBean(HotSellersQueryService.class);
    }

    /**
     * 热卖商品（分页，根据个人定制）redis
     * @throws Exception
     */
    @Test
    public void testHotSeller() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
