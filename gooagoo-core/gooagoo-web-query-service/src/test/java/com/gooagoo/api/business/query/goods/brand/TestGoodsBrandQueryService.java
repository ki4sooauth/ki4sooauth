package com.gooagoo.api.business.query.goods.brand;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.generator.goods.GoodsBrand;

public class TestGoodsBrandQueryService
{

    public GoodsBrandQueryService goodsBrandQueryService;

    @Before
    public void testBefore()
    {
        this.goodsBrandQueryService = ApplicationContextUtils.getBean(GoodsBrandQueryService.class);
    }

    /**
     * 根据商家编号和实体店编号获取品牌列表(去重)
     */
    @Test
    public void testFindDistinctGoodsBrandList() throws Exception
    {
        String shopId = null;
        String shopEntityId = null;
        List<GoodsBrand> goodsBrandList = this.goodsBrandQueryService.findDistinctGoodsBrandList(shopId, shopEntityId);
        Assert.assertTrue("根据商家编号和实体店编号获取品牌列表失败", CollectionUtils.isNotEmpty(goodsBrandList));
    }
}
