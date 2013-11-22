package com.gooagoo.api.business.query.marketing.cache;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestCouponCacheQueryService
{

    public CouponCacheQueryService couponCacheQueryService;

    @Before
    public void testBefore()
    {
        this.couponCacheQueryService = ApplicationContextUtils.getBean(CouponCacheQueryService.class);
    }

    /**
     * 查询优惠凭证
     * @throws Exception
     */
    @Test
    public void testFindCoupon() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
