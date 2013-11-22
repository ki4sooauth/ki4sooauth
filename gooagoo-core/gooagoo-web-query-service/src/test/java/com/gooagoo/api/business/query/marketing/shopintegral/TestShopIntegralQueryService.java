package com.gooagoo.api.business.query.marketing.shopintegral;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopIntegralQueryService
{

    public ShopIntegralQueryService shopIntegralQueryService;

    @Before
    public void testBefore()
    {
        this.shopIntegralQueryService = ApplicationContextUtils.getBean(ShopIntegralQueryService.class);
    }

    /**
     * 6.3.1. 兑换物品列表（分页、排序）
     * @throws Exception
     */
    @Test
    public void testFindTradeList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 6.3.3. 积分兑换信息列表查询
     * @throws Exception
     */
    @Test
    public void testFindShopIntegralConvert() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 积分特批列表查询
     * @throws Exception
     */
    @Test
    public void testFindIntegralSpecialApproval() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
