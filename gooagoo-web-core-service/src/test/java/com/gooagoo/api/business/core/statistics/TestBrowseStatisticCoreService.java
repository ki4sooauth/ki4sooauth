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
public class TestBrowseStatisticCoreService  extends AbstractTransactionalJUnit4SpringContextTests
{

    @Autowired
    public BrowseStatisticCoreService browseStatisticCoreService;

    @Override
    @Resource(name = "")
    public void setDataSource(DataSource dataSource)
    {
       super.setDataSource(dataSource);
    }
    /**
     * 查询商家服务工具营销信息浏览次数
     * @throws Exception
     */
    @Test
    public void testToolBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商家服务工具营销信息浏览人群
     * @throws Exception
     */
    @Test
    public void testToolsBrowsPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询优惠凭证浏览次数
     * @throws Exception
     */
    @Test
    public void testCouponBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询优惠凭证浏览人群
     * @throws Exception
     */
    @Test
    public void testCouponBrowsPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询活动浏览次数
     * @throws Exception
     */
    @Test
    public void testActivityBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询活动浏览人群
     * @throws Exception
     */
    @Test
    public void testActivityBrowsPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商品浏览次数
     * @throws Exception
     */
    @Test
    public void testGoodsBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询商品浏览人群
     * @throws Exception
     */
    @Test
    public void testGoodsBrowsPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类浏览次数
     * @throws Exception
     */
    @Test
    public void testCategoryBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品类浏览人群
     * @throws Exception
     */
    @Test
    public void testCategoryBrowsPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品牌浏览次数
     * @throws Exception
     */
    @Test
    public void testBrandBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询品牌浏览人群
     * @throws Exception
     */
    @Test
    public void testBrandBrowsPoeple() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询吆喝浏览次数
     * @throws Exception
     */
    @Test
    public void testCryoutBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询吆喝浏览人群
     * @throws Exception
     */
    @Test
    public void testCryoutBrowsPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询通知浏览次数
     * @throws Exception
     */
    @Test
    public void testNoticeBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询通知浏览人群
     * @throws Exception
     */
    @Test
    public void testNoticeBrowsPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询购好奇浏览次数
     * @throws Exception
     */
    @Test
    public void testPurchaseAndcuriosityBrowsTimes() throws Exception
    {

       Assert.isTrue(true, "");
    }

    /**
     * 查询购好奇浏览人群
     * @throws Exception
     */
    @Test
    public void testPurchaseAndcuriosityBrowsPeople() throws Exception
    {

       Assert.isTrue(true, "");
    }

}
