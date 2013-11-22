package com.gooagoo.api.business.query.goods.cache;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;

public class TestGoodsCacheQueryService
{

    public GoodsCacheQueryService goodsCacheQueryService;

    @Before
    public void testBefore()
    {
        this.goodsCacheQueryService = ApplicationContextUtils.getBean(GoodsCacheQueryService.class);
    }

    /**
     * 查询商品信息
     * @throws Exception
     */
    @Test
    public void testFindGoodsInfo() throws Exception
    {
        Map<String, String> goods = goodsCacheQueryService.findGoodsInfo("0182AICPELK2NLA0NCQU1JEIISWR2HCH");
        System.out.println(goods.size());
    }

    /**
     * 查询商品品类
     * @throws Exception
     */
    @Test
    public void testFindGoodsCategory() throws Exception
    {

        // goodsCacheQueryService.findGoodsCategory(shopEntityId, categoryId);
    }

}
