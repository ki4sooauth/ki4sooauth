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

import com.gooagoo.entity.generator.goods.GoodsBrand;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestGoodsBrandCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public GoodsBrandCoreService goodsBrandCoreService;

    @Override
    @Resource(name = "goodsSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 通过主键删除品牌信息
     * @throws Exception
     */
    @Test
    public void testDeleteGoodsBrand() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.goodsBrandCoreService.deleteGoodsBrand(id);
        Assert.isTrue(isSucceed, "删除品牌");
    }

    /**
     * 添加品牌信息
     * @throws Exception
     */
    @Test
    public void testAddGoodsBrand() throws Exception
    {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setId("2");
        goodsBrand.setBrandId("1");
        goodsBrand.setBrandName("test11");
        goodsBrand.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        goodsBrand.setShopEntityId("00017Q3EG198TUUV50000HFYOBYEH00F");
        goodsBrand.setSort(0);
        boolean isSucceed = this.goodsBrandCoreService.addGoodsBrand(goodsBrand);
        Assert.isTrue(isSucceed, "添加品牌");
    }

    /**
     * 通过主键修改品牌信息
     * @throws Exception
     */
    @Test
    public void testUpdateGoodsBrand() throws Exception
    {
        GoodsBrand goodsBrand = new GoodsBrand();
        goodsBrand.setId("1");
        goodsBrand.setBrandName("test12");
        boolean isSucceed = this.goodsBrandCoreService.updateGoodsBrand(goodsBrand);
        Assert.isTrue(isSucceed, "修改品牌");
    }

}
