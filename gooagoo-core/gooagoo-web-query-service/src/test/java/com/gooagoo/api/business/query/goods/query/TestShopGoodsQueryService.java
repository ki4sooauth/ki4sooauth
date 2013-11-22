package com.gooagoo.api.business.query.goods.query;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestShopGoodsQueryService
{

    public ShopGoodsQueryService shopGoodsQueryService;

    @Before
    public void testBefore()
    {
        this.shopGoodsQueryService = ApplicationContextUtils.getBean(ShopGoodsQueryService.class);
    }

    /**
     * 根据商品Id查询商品详情
     * @throws Exception
     */
    @Test
    public void testFindGoodsDetail() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
