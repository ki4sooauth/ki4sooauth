package com.gooagoo.api.business.query.statistics.user;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
public class TestGoodsStatisticQueryService
{

    public GoodsStatisticQueryService goodsStatisticService;

    @Before
    public void testBefore()
    {
        this.goodsStatisticService = ApplicationContextUtils.getBean(GoodsStatisticQueryService.class);
    }

    /**
     * 猜你喜欢的商品
     * @throws Exception
     */
    @Test
    public void testQueryGuessYouTastes() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 热评商品
     * @throws Exception
     */
    @Test
    public void testQueryHotComments() throws Exception
    {

       Assert.assertNotNull("", "");
    }

    /**
     * 热卖商品
     * @throws Exception
     */
    @Test
    public void testQueryHotSales() throws Exception
    {

       Assert.assertNotNull("", "");
    }

}
