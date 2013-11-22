package com.gooagoo.api.business.core.marketing.qualitygoods;

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

import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestQualityGoodsCoreService extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public QualityGoodsCoreService qualityGoodsCoreService;

    @Override
    @Resource(name = "marketingSource")
    public void setDataSource(DataSource dataSource)
    {
        super.setDataSource(dataSource);
    }

    /**
     * 添加精品
     * @throws Exception
     */
    @Test
    public void testAddQualityGood() throws Exception
    {
        MarketingQualityGoods marketingQualityGoods = new MarketingQualityGoods();
        marketingQualityGoods.setId("2");
        marketingQualityGoods.setGoodsId("1");
        marketingQualityGoods.setQualityTypeLeaf(1);
        marketingQualityGoods.setQualityTypeRoot(1);
        marketingQualityGoods.setShopId("00017Q3EG198TUUV50000HFYOBYEH00F");
        boolean isSucceed = this.qualityGoodsCoreService.addQualityGood(marketingQualityGoods);
        Assert.isTrue(isSucceed, "添加精品");
    }

    /**
     * 编辑精品
     * @throws Exception
     */
    @Test
    public void testUpdateQualityGood() throws Exception
    {
        MarketingQualityGoods marketingQualityGoods = new MarketingQualityGoods();
        marketingQualityGoods.setId("1");
        marketingQualityGoods.setGoodsId("2");
        boolean isSucceed = this.qualityGoodsCoreService.updateQualityGood(marketingQualityGoods);
        Assert.isTrue(isSucceed, "编辑精品");
    }

    /**
     * 删除精品
     * @throws Exception
     */
    @Test
    public void testDeleteQualityGood() throws Exception
    {
        boolean isSucceed = this.qualityGoodsCoreService.deleteQualityGood("1");
        Assert.isTrue(isSucceed, "删除精品");
    }

}
