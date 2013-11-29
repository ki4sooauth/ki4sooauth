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

import com.gooagoo.entity.generator.goods.GoodsFeature;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestGoodsFeatureCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public GoodsFeatureCoreService goodsFeatureCoreService;

    @Override
    @Resource(name = "goodsSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 通过主键删除商品特征项信息
     * @throws Exception
     */
    @Test
    public void testDeleteGoodsFeature() throws Exception
    {
        String id = "1";
        boolean isSucceed = this.goodsFeatureCoreService.deleteGoodsFeature(id);
        Assert.isTrue(isSucceed, "删除商品特征项");
    }

    /**
     * 添加商品特征项信息
     * @throws Exception
     */
    @Test
    public void testAddGoodsFeature() throws Exception
    {
        GoodsFeature goodsFeature = new GoodsFeature();
        goodsFeature.setId("2");
        goodsFeature.setTypeCode("1");
        goodsFeature.setTypeName("test11");
        goodsFeature.setEnumValue("[1,2,3]");
        goodsFeature.setIsDisplay("Y");
        goodsFeature.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        goodsFeature.setGoodsSerial("1");
        boolean isSucceed = this.goodsFeatureCoreService.addGoodsFeature(goodsFeature);
        Assert.isTrue(isSucceed, "添加商品特征项");
    }

    /**
     * 通过主键修改商品特征项信息
     * @throws Exception
     */
    @Test
    public void testUpdateGoodsFeature() throws Exception
    {
        GoodsFeature goodsFeature = new GoodsFeature();
        goodsFeature.setId("1");
        goodsFeature.setTypeName("test12");
        boolean isSucceed = this.goodsFeatureCoreService.updateGoodsFeature(goodsFeature);
        Assert.isTrue(isSucceed, "修改商品特征项");
    }

}
