package com.gooagoo.api.business.query.statistics.user;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestCouponStatisticQueryService
{

    public CouponStatisticQueryService couponStatisticService;

    @Before
    public void testBefore()
    {
        this.couponStatisticService = ApplicationContextUtils.getBean(CouponStatisticQueryService.class);
    }

    /**
     * 猜你喜欢的优惠凭证
     * @throws Exception
     */
    @Test
    public void testQueryGuessYouTastes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
