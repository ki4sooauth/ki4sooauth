package com.gooagoo.api.business.query.marketing.coupon;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestCouponQueryService
{

    public CouponQueryService couponQueryService;

    @Before
    public void testBefore()
    {
        this.couponQueryService = ApplicationContextUtils.getBean(CouponQueryService.class);
    }

    /**
     * 通过主键获取优惠凭证基本信息（包括优惠凭证内容、使用校验、模板数据）
     * @throws Exception
     */
    @Test
    public void testGetCouponInfoById() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 根据条件查询总记录数
     * @throws Exception
     */
    @Test
    public void testCountCouponInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 根据条件查询优惠凭证基本信息（包括优惠凭证内容、使用校验、模板数据）
     * @throws Exception
     */
    @Test
    public void testSelectCouponInfoByExample() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 6.1.5. 优惠凭证详情
     * @throws Exception
     */
    @Test
    public void testFindCouponDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
