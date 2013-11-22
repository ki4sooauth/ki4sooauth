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
public class TestCollectStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public CollectStatisticCoreService collectStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 
     * @throws Exception
     */
    @Test
    public void testCouponCollectTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testCouponCollectPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testActivityCollectTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testActivityCollectPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testGoodsCollectTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testGoodsCollectPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testCategoryCollectTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类收藏人群
     * @throws Exception
     */
    @Test
    public void testCategoryCollectPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 
     * @throws Exception
     */
    @Test
    public void testBrandCollectTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类收藏人群
     * @throws Exception
     */
    @Test
    public void testBrandCollectPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
