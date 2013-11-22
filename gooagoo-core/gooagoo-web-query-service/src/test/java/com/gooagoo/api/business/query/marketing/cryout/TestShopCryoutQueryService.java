package com.gooagoo.api.business.query.marketing.cryout;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopCryoutQueryService
{

    public ShopCryoutQueryService shopCryoutQueryService;

    @Before
    public void testBefore()
    {
        this.shopCryoutQueryService = ApplicationContextUtils.getBean(ShopCryoutQueryService.class);
    }

    /**
     * 6.4.5. 查询吆喝列表
     * @throws Exception
     */
    @Test
    public void testFindShopCryoutList() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 6.4.6. 查看吆喝详情
     * @throws Exception
     */
    @Test
    public void testFindShopCryoutDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
