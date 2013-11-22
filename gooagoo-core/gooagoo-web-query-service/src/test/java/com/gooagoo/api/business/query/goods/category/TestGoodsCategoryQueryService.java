package com.gooagoo.api.business.query.goods.category;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Before;
import org.junit.Test;

import com.gooagoo.api.business.query.utils.ApplicationContextUtils;
import com.gooagoo.entity.generator.goods.GoodsCategory;

public class TestGoodsCategoryQueryService
{

    public GoodsCategoryQueryService goodsCategoryQueryService;

    @Before
    public void testBefore()
    {
        this.goodsCategoryQueryService = ApplicationContextUtils.getBean(GoodsCategoryQueryService.class);
    }

    /**
     * 根据父类查询所有子类品类列表
     * @throws Exception
     */
    @Test
    public void testFindGoodsCategoryListByParent() throws Exception
    {

        Assert.assertNotNull("", "");
    }

    /**
     * 根据父类查询所有子类品类列表
     * @throws Exception
     */
    @Test
    public void testFindDistinctGoodsCategoryList() throws Exception
    {
        String shopId = null;
        String shopEntityId = null;
        List<GoodsCategory> goodsCategoryList = this.goodsCategoryQueryService.findDistinctGoodsCategoryList(shopId, shopEntityId);
        Assert.assertTrue("根据商家编号和实体店编号获取品类列表失败", CollectionUtils.isNotEmpty(goodsCategoryList));
    }
}
