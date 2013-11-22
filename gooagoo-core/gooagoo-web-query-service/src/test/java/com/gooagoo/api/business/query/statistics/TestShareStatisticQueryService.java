package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShareStatisticQueryService
{

    public ShareStatisticQueryService shareStatisticService;

    @Before
    public void testBefore()
    {
        this.shareStatisticService = ApplicationContextUtils.getBean(ShareStatisticQueryService.class);
    }

    /**
     * 查询优惠凭证分享次数
     * @throws Exception
     */
    @Test
    public void testCouponShareTimes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询优惠凭证分享人群
     * @throws Exception
     */
    @Test
    public void testCouponSharePeople() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
