package com.gooagoo.api.business.core.goods.manage;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.gooagoo.entity.generator.goods.GoodsCategory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestGoodsCategoryCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public GoodsCategoryCoreService goodsCategoryCoreService;

    @Override
    @Resource(name = "goodsSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 通过主键删除品类信息
     * @throws Exception
     */
    @Test
    public void testDeleteGoodsCategory() throws Exception
    {
        String id = "188O3PT7FTVM4200A1BAQJA6544BI6LL";
        boolean isSucceed = this.goodsCategoryCoreService.deleteGoodsCategory(id);
        Assert.isTrue(isSucceed, "删除品类");
    }

    /**
     * 添加品类信息
     * @throws Exception
     */
    @Test
    public void testAddGoodsCategory() throws Exception
    {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setId("2");
        goodsCategory.setParentCategoryId("-1");
        goodsCategory.setCategoryId("1");
        goodsCategory.setCategoryName("test11");
        goodsCategory.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        goodsCategory.setShopEntityId("00017Q3EG198TUUV50000HFYOBYEH00F");
        goodsCategory.setSort(0);
        boolean isSucceed = this.goodsCategoryCoreService.addGoodsCategory(goodsCategory);
        Assert.isTrue(isSucceed, "添加品类");
    }

    /**
     * 通过主键修改品类信息
     * @throws Exception
     */
    @Test
    public void testUpdateGoodsCategory() throws Exception
    {
        GoodsCategory goodsCategory = new GoodsCategory();
        goodsCategory.setId("1");
        goodsCategory.setCategoryName("test12");
        boolean isSucceed = this.goodsCategoryCoreService.updateGoodsCategory(goodsCategory);
        Assert.isTrue(isSucceed, "修改品类");
    }

}
