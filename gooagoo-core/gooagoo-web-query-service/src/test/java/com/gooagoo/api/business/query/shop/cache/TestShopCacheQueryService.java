package com.gooagoo.api.business.query.shop.cache;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopCacheQueryService
{

    public ShopCacheQueryService shopCacheQueryService;

    @Before
    public void testBefore()
    {
        this.shopCacheQueryService = ApplicationContextUtils.getBean(ShopCacheQueryService.class);
    }

    /**
     * 查询商家信息
     * @throws Exception
     */
    @Test
    public void testFindShopInfo() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
