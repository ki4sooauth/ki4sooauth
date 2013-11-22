package com.gooagoo.api.business.query.statistics;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestUseStatisticQueryService
{

    public UseStatisticQueryService useStatisticService;

    @Before
    public void testBefore()
    {
        this.useStatisticService = ApplicationContextUtils.getBean(UseStatisticQueryService.class);
    }

    /**
     * 查询商家服务工具使用次数
     * @throws Exception
     */
    @Test
    public void testToolUseTimes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询商家服务工具使用人群
     * @throws Exception
     */
    @Test
    public void testToolUsePoeple() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询优惠凭证使用次数
     * @throws Exception
     */
    @Test
    public void testCouponUseTimes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 查询优惠凭证使用人群
     * @throws Exception
     */
    @Test
    public void testCouponUsePeople() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
