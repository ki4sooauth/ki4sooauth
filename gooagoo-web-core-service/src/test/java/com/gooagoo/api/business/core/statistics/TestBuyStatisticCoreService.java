package com.gooagoo.api.business.core.statistics;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class TestBuyStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public BuyStatisticCoreService buyStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询商品购买次数
     * @throws Exception
     */
    @Test
    public void testGoodsBuyTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商品购买人群
     * @throws Exception
     */
    @Test
    public void testGoodsBuyPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类购买次数
     * @throws Exception
     */
    @Test
    public void testCategoryBuyTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类购买人群
     * @throws Exception
     */
    @Test
    public void testCategoryBuyPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品牌购买次数
     * @throws Exception
     */
    @Test
    public void testBrandBuyTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品牌购买人群
     * @throws Exception
     */
    @Test
    public void testBrandBuyPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 区域销量排行
     * @throws Exception
     */
    @Test
    public void testSalesRanking() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 用户消费次数
     * @throws Exception
     */
    @Test
    public void testConsumptionNum() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
